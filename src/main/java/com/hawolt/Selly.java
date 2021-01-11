package com.hawolt;

import com.hawolt.impl.*;

import java.util.Base64;

public class Selly {

    private String email, apiKey;

    public static String AUTHORIZATION, BASE = "https://selly.io/api/v2/";

    private Blacklists blacklists = new Blacklists();
    private Rules rules = new Rules();
    private Categories categories = new Categories();
    private Orders orders = new Orders();
    private Products products = new Products();
    private Webhooks webhooks = new Webhooks();
    private Logs logs = new Logs();
    private Payments payments = new Payments();

    private Selly(String email, String api) {
        this.email = email;
        this.apiKey = api;
        Selly.AUTHORIZATION = Base64.getEncoder().encodeToString(String.format("%s:%s", email, api).getBytes());
    }

    public static Selly authenticate(String email, String api) {
        return new Selly(email, api);
    }

    public String getEmail() {
        return email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Blacklists getBlacklists() {
        return blacklists;
    }

    public Rules getRules() {
        return rules;
    }

    public Categories getCategories() {
        return categories;
    }

    public Orders getOrders() {
        return orders;
    }

    public Products getProducts() {
        return products;
    }

    public Webhooks getWebhooks() {
        return webhooks;
    }

    public Logs getLogs() {
        return logs;
    }

    public Payments getPayments() {
        return payments;
    }
}
