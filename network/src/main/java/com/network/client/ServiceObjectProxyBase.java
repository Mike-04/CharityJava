package com.network.client;

import com.network.objectprotocol.IRequest;
import com.network.objectprotocol.IResponse;
import com.network.objectprotocol.UpdateResponse;
import com.service.observer.IObserver;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ServiceObjectProxyBase {
    private String host;
    private int port;

    protected IObserver client;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket connection;

    private final Queue<IResponse> responses = new LinkedList<>();
    private volatile boolean isFinished = false;

    private final ReentrantLock lock = new ReentrantLock();
    private final Object waitHandle = new Object();

    public ServiceObjectProxyBase(String host, int port) {
        this.host = host;
        this.port = port;
    }

    protected abstract void handleUpdate(UpdateResponse update);

    protected void closeConnection() {
        isFinished = true;
        try {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
            if (connection != null) connection.close();
            client = null;
        } catch (IOException e) {
            throw new ProxyException(e);
        }
    }

    protected void sendRequest(IRequest request) {
        try {
            outputStream.writeObject(request);
            outputStream.flush();
        } catch (IOException e) {
            throw new ProxyException("Error sending object: " + e.getMessage(), e);
        }
    }

    protected IResponse readResponse() {
        IResponse response;
        try {
            synchronized (waitHandle) {
                waitHandle.wait();
            }
            lock.lock();
            try {
                response = responses.poll();
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            throw new ProxyException(e);
        }
        return response;
    }

    protected void initializeConnection() {
        try {
            connection = new Socket(host, port);
            outputStream = new ObjectOutputStream(connection.getOutputStream());
            inputStream = new ObjectInputStream(connection.getInputStream());
            isFinished = false;
            startReader();
        } catch (IOException e) {
            throw new ProxyException(e);
        }
    }

    private void startReader() {
        new Thread(this::run).start();
    }

    public void run() {
        while (!isFinished) {
            try {
                Object response = inputStream.readObject();
                System.out.println("Response Received: " + response);
                if (response instanceof UpdateResponse) {
                    System.out.println("Received UpdateResponse: " + response);
                    handleUpdate((UpdateResponse) response);
                } else {
                    lock.lock();
                    try {
                        responses.add((IResponse) response);
                    } finally {
                        lock.unlock();
                    }
                    synchronized (waitHandle) {
                        waitHandle.notify();
                    }
                }
            }
            catch (EOFException e) {
                System.err.println("Client disconnected: " + e.getMessage());
            }
            catch (IOException | ClassNotFoundException e) {
                if (exceptionThrown != null) {
                    exceptionThrown.onExceptionThrown(e);
                }
            }
        }
    }

    public interface OnExceptionThrown {
        void onExceptionThrown(Exception e);
    }

    private OnExceptionThrown exceptionThrown;

    public void setExceptionThrown(OnExceptionThrown exceptionThrown) {
        this.exceptionThrown = exceptionThrown;
    }

    protected void testConnectionOpen() {
        if (connection == null || connection.isClosed()) {
            throw new ProxyException("Connection is not open");
        }
    }
}