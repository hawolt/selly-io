package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Blacklist;
import com.hawolt.objects.creator.BlacklistCreator;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Blacklists extends SellyResource {

    public Blacklists() {
        super("webhooks/endpoints");
    }

    public Blacklist create(BlacklistCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Blacklist(new JSONObject(request.getBody()));
    }

    public Blacklist update(BlacklistCreator creator, String id) throws IOException {
        SellyRequest request = SellyRequest.update(String.format("%s/%s", location, id), creator.getJSONObject());
        return new Blacklist(new JSONObject(request.getBody()));
    }

    public Blacklist get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Blacklist(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }

    public Pagination<Blacklist> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Blacklist> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Blacklist::new, location, request, direction);
    }
}
