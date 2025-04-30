package com.server;

import com.network.client.ClientObjectWorker;
import com.network.server.ConcurrentServer;
import com.service.IAppService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ConcurrentServer {
    private final IAppService server;

    public Server(String host, int port, IAppService server) {
        super(host, port);
        this.server = server;
        System.out.println("Created server...");
    }

    @Override
    protected Thread createWorker(Socket client) {
        ClientObjectWorker worker = new ClientObjectWorker(server, client);
        return new Thread(worker::run);
    }
}