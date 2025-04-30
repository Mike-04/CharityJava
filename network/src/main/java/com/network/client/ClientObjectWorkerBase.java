package com.network.client;

import com.network.objectprotocol.IRequest;
import com.network.objectprotocol.IResponse;
import com.network.client.ServerProcessingException;
import com.service.IAppService;

import java.io.*;
import java.net.Socket;

public abstract class ClientObjectWorkerBase implements Runnable, Serializable {
    private final Socket connection;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;
    private volatile boolean connected;

    public ClientObjectWorkerBase( Socket connection) {
        this.connection = connection;

        ObjectInputStream in=null;
        ObjectOutputStream out=null;

        try{
            out=new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in=new ObjectInputStream(connection.getInputStream());
            connected=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        input=in;
        output=out;
    }

    @Override
    public void run() {
        while(connected){
            try{
                System.out.println("Waiting for request ...");
                Object request = input.readObject();
                System.out.println("Received request "+request);
                IResponse response=handleRequest((IRequest)request);
                if (response!=null){
                    sendResponse(response);
                }
            } catch (EOFException e) {
                System.out.println("Client disconnected from le server");
                connected=false;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }catch (ClassNotFoundException e){
                throw new RuntimeException(e);
            }


        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            input.close();
            output.close();
            connection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract IResponse handleRequest(IRequest request);

    protected void sendResponse(IResponse response) throws IOException {
        System.out.println("sending response "+response);
        synchronized (output) {
            output.writeObject(response);
            output.flush();
        }
    }
}