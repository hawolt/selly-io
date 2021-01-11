package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Product;
import com.hawolt.objects.creator.ProductCreator;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Products extends SellyResource {

    public Products() {
        super("webhooks/products");
    }

    public Product create(ProductCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Product(new JSONObject(request.getBody()));
    }

    public Product update(ProductCreator creator, String id) throws IOException {
        SellyRequest request = SellyRequest.update(String.format("%s/%s", location, id), creator.getJSONObject());
        return new Product(new JSONObject(request.getBody()));
    }

    public Product get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Product(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }

    public Pagination<Product> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Product> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Product::new, location, request, direction);
    }
}
