package com.hawolt.objects;

import com.hawolt.SellyJson;
import com.hawolt.objects.enumerable.Status;
import org.json.JSONObject;

public class Payment extends SellyJson {
    private String url, paypalKey, id, product_id, email, value, currency, gateway, usdValue, exchangeRate, token, createdAt, updatedAt, cryptoAddress, cryptoChannel, cryptoValue;
    private int quantity, statusCode;
    private Status status;

    public Payment(JSONObject o) {
        super(o);
        this.url = o.getString("url");
        this.paypalKey = o.getString("paypal_pay_key");
        this.id = o.getString("id");
        this.product_id = o.getString("product_id");
        this.email = o.getString("email");
        this.value = o.getString("value");
        this.quantity = o.getInt("quantity");
        this.currency = o.getString("currency");
        this.gateway = o.getString("gateway");
        this.statusCode = o.getInt("status");
        this.cryptoAddress = o.isNull("crypto_address") ? null : o.getString("crypto_address");
        this.cryptoChannel = o.isNull("crypto_channel") ? null : o.getString("crypto_channel");
        this.cryptoValue = o.isNull("crypto_value") ? null : o.get("crypto_value").toString();
        this.usdValue = o.getString("usd_value");
        this.exchangeRate = o.getString("exchange_rate");
        this.token = o.getString("token");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
        this.status = Status.find(statusCode);
    }

    public String getUrl() {
        return url;
    }

    public String getPaypalKey() {
        return paypalKey;
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getEmail() {
        return email;
    }

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getGateway() {
        return gateway;
    }

    public String getUsdValue() {
        return usdValue;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public String getToken() {
        return token;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public String getCryptoChannel() {
        return cryptoChannel;
    }

    public String getCryptoValue() {
        return cryptoValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Status getStatus() {
        return status;
    }
}