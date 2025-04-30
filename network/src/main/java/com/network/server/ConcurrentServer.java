package com.network.server;

import java.net.Socket;

public abstract class ConcurrentServer extends AbstractServer {
    public ConcurrentServer(String host, int port) {
        super(host, port);
    }

    @Override
    public void processRequest(Socket client) {
        Thread tw = createWorker(client);
        tw.start();
    }

    protected abstract Thread createWorker(Socket client);
}