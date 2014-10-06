package com.foo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler  {
    private String responseText;

    RequestHandler(String responseText) {
        this.responseText = responseText;
    }

    public void handle(HttpExchange t) throws IOException {
        t.sendResponseHeaders(200, responseText.length());
        OutputStream os = t.getResponseBody();
        os.write(responseText.getBytes());
        os.close();
    }
}
