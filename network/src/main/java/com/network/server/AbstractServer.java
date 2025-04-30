package com.network.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractServer {
    private ServerSocket server;
    private final String host;
    private final int port;

    public AbstractServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        InetAddress address = InetAddress.getByName(host);
        server = new ServerSocket(port, 50, address);
        while (true) {
            try {
                System.out.println("Waiting for clients...");
                Socket client = server.accept();
                System.out.println("Client connected...");
                processRequest(client);
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public abstract void processRequest(Socket client);
}