package com.hawolt.requests;


import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class Request {
    private HttpURLConnection connection;

    public Request(String endpoint, Method method, boolean output) throws IOException {
        connection = BasicHttp.open(endpoint);
        connection.setRequestMethod(method.name());
        connection.setDoOutput(output);
    }

    public void addHeader(String key, String value) {
        connection.setRequestProperty(key, value);
    }

    public void write(String output) throws IOException {
        try (OutputStream out = connection.getOutputStream()) {
            out.write(output.getBytes());
            out.flush();
        }
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

}
