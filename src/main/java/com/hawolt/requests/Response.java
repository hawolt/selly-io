package com.hawolt.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class Response {

    private int code;
    private String body;
    private Map<String, List<String>> headers;

    public Response(Request request) throws IOException {
        HttpURLConnection connection = request.getConnection();
        headers = connection.getHeaderFields();
        this.code = connection.getResponseCode();
        this.body = read(connection);
        connection.disconnect();
    }

    public String read(HttpURLConnection connection) throws IOException {
        try (InputStream stream = connection.getInputStream()) {
            return BasicHttp.read(stream);
        } catch (IOException e1) {
            try (InputStream stream = connection.getErrorStream()) {
                return stream == null ? null : BasicHttp.read(stream);
            } catch (IOException e2) {
                throw e2;
            }
        }
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}
