package com.hawolt.objects;

import com.hawolt.SellyJson;
import com.hawolt.objects.enumerable.Status;
import org.json.JSONObject;

public class Order extends SellyJson{

    private String id, productID, customerEmail, customerIP, countryCode, currency, gateway, delivered, referral, cryptoAddress, cryptoValue, cryptoReceived, createdAt, updatedAt;
    private double orderValue, usdValue;
    private int statusCode, quantity;
    private Status status;

    public Order(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.productID = o.getString("product_id");
        this.customerEmail = o.getString("email");
        this.customerIP = o.getString("ip_address");
        this.countryCode = o.getString("country_code");
        this.orderValue = o.getDouble("value");
        this.usdValue = o.getDouble("usd_value");
        this.currency = o.getString("currency");
        this.gateway = o.getString("gateway");
        this.quantity = o.getInt("quantity");
        this.statusCode = o.getInt("status");
        this.delivered = o.isNull("delivered") ? null : o.getString("delivered");
        this.referral = o.isNull("referral") ? null : o.getString("referral");
        this.cryptoAddress = o.isNull("crypto_address") ? null : o.getString("crypto_address");
        this.cryptoValue = o.isNull("crypto_value") ? null : o.get("crypto_value").toString();
        this.cryptoReceived = o.isNull("crypto_received") ? null : o.get("crypto_received").toString();
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
        this.status = Status.find(statusCode);
    }

    public String getId() {
        return id;
    }

    public String getProductID() {
        return productID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public String getGateway() {
        return gateway;
    }

    public String getDelivered() {
        return delivered;
    }

    public String getReferral() {
        return referral;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public String getCryptoValue() {
        return cryptoValue;
    }

    public String getCryptoReceived() {
        return cryptoReceived;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public double getUsdValue() {
        return usdValue;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public Status getStatus() {
        return status;
    }

}
