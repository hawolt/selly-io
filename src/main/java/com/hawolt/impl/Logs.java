package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Log;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Logs extends SellyResource {

    public Logs() {
        super("webhooks/logs");
    }

    public Log get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Log(new JSONObject(request.getBody()));
    }

    public Pagination<Log> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Log> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Log::new, location, request, direction);
    }
}
