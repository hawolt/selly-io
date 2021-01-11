package com.hawolt.impl;

import com.hawolt.SellyException;
import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Order;
import com.hawolt.pagination.Pagination;
import org.json.JSONObject;

import java.io.IOException;

public class Orders extends SellyResource {

    public Orders() {
        super("orders");
    }

    public Order get(String id) throws IOException {
        SellyRequest request = SellyRequest.get(String.format("%s/%s", location, id));
        return new Order(new JSONObject(request.getBody()));
    }

    public Pagination<Order> getAll() throws IOException, SellyException {
        return getAll(Pagination.Direction.ASCENDING);
    }

    public Pagination<Order> getAll(Pagination.Direction direction) throws IOException, SellyException {
        SellyRequest request = SellyRequest.get(location);
        return new Pagination<>(Order::new, location, request, direction);
    }
}
