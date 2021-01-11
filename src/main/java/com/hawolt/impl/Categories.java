package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Category;
import com.hawolt.objects.creator.CategoryCreator;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Categories extends SellyResource {

    public Categories() {
        super("webhooks/endpoints");
    }

    public Category create(CategoryCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Category(new JSONObject(request.getBody()));
    }

    public Category update(CategoryCreator creator, String id) throws IOException {
        SellyRequest request = SellyRequest.update(String.format("%s/%s", location, id), creator.getJSONObject());
        return new Category(new JSONObject(request.getBody()));
    }

    public Category get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Category(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }

    public Pagination<Category> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Category> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Category::new, location, request, direction);
    }
}
