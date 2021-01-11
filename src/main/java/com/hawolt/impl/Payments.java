package com.hawolt.impl;

import com.hawolt.SellyRequest;
import com.hawolt.SellyResource;
import com.hawolt.objects.Payment;
import com.hawolt.objects.creator.PaymentCreator;
import org.json.JSONObject;

import java.io.IOException;

public class Payments extends SellyResource {

    public Payments() {
        super("pay");
    }

    public Payment create(PaymentCreator creator) throws IOException {
        SellyRequest request = SellyRequest.post(location, creator.getJSONObject());
        return new Payment(new JSONObject(request.getBody()));
    }

    public boolean delete(String id) throws IOException {
        SellyRequest request = SellyRequest.delete(String.format("%s/%s", location, id));
        return request.getCode() == 204;
    }
}
