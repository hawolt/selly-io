package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Webhook;
import com.hawolt.objects.creator.WebhookCreator;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Webhooks extends SellyResource {

    public Webhooks() {
        super("webhooks/endpoints");
    }

    public Webhook create(WebhookCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Webhook(new JSONObject(request.getBody()));
    }

    public Webhook update(WebhookCreator creator, String id) throws IOException {
        SellyRequest request = SellyRequest.update(String.format("%s/%s", location, id), creator.getJSONObject());
        return new Webhook(new JSONObject(request.getBody()));
    }

    public Webhook get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Webhook(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }

    public Pagination<Webhook> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Webhook> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Webhook.class, location, request, direction);
    }
}
