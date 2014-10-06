package com.foo;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class App {

    public static void main(String[] args) throws Exception {
        if(args.length!=2) {
            System.out.println("Usage: java -jar WebServer.jar <port> <response text>");
            System.exit(1);
        }

        Integer port = Integer.parseInt(args[0]);
        String responseText = args[1];

        System.out.println("Started with: "+responseText+" on port "+port);
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RequestHandler(responseText));
        server.setExecutor(null);
        server.start();
    }
}
