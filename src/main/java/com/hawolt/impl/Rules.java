package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Rule;
import com.hawolt.objects.creator.RuleCreator;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Rules extends SellyResource {

    public Rules() {
        super("webhooks/endpoints");
    }

    public Rule create(RuleCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Rule(new JSONObject(request.getBody()));
    }

    public Rule update(RuleCreator creator, String id) throws IOException {
        SellyRequest request = SellyRequest.update(String.format("%s/%s", location, id), creator.getJSONObject());
        return new Rule(new JSONObject(request.getBody()));
    }

    public Rule get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Rule(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }

    public Pagination<Rule> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Rule> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Rule::new, location, request, direction);
    }
}
