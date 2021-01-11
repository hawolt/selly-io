package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONArray;
import org.json.JSONObject;

public class Product extends SellyJson {
    private String id, title, description, currency, stockDelimiter, dynamicUrl, info, webhookUrl, createdAt, updatedAt;
    private int stock, productType, maximumQuantity, minimumQuantity, stockAmount, cryptoConfirmations, maxRiskLevel;
    private double price;
    private JSONArray gateways, custom;
    private boolean priv, unlisted, vpnBlock;
    private JSONObject image, file;

    public Product(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.title = o.getString("title");
        this.description = o.getString("description");
        this.stock = o.getString("stock").matches("[0-9]+") ? Integer.parseInt(o.getString("stock")) : -1;
        this.price = o.getDouble("price");
        this.currency = o.getString("currency");
        this.productType = o.getInt("product_type");
        this.gateways = o.getJSONArray("gateways");
        this.priv = o.getBoolean("private");
        this.unlisted = o.getBoolean("private");
        this.vpnBlock = o.getBoolean("vpn_block");
        this.maximumQuantity = o.getInt("maximum_quantity");
        this.minimumQuantity = o.getInt("minimum_quantity");
        this.stockDelimiter = o.getString("stock_delimiter");
        this.stockAmount = o.getInt("stock_amount");
        this.image = o.getJSONObject("image");
        this.cryptoConfirmations = o.getInt("crypto_confirmations");
        this.maxRiskLevel = o.getInt("max_risk_level");
        this.dynamicUrl = o.getString("dynamic_url");
        this.info = o.getString("info");
        this.file = o.getJSONObject("file");
        this.custom = o.getJSONArray("custom");
        this.webhookUrl = o.getString("webhook_url");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStockDelimiter() {
        return stockDelimiter;
    }

    public String getDynamicUrl() {
        return dynamicUrl;
    }

    public String getInfo() {
        return info;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int getStock() {
        return stock;
    }

    public int getProductType() {
        return productType;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public int getCryptoConfirmations() {
        return cryptoConfirmations;
    }

    public int getMaxRiskLevel() {
        return maxRiskLevel;
    }

    public double getPrice() {
        return price;
    }

    public JSONArray getGateways() {
        return gateways;
    }

    public JSONArray getCustom() {
        return custom;
    }

    public boolean isPrivate() {
        return priv;
    }

    public boolean isUnlisted() {
        return unlisted;
    }

    public boolean isVpnBlock() {
        return vpnBlock;
    }

    public JSONObject getImage() {
        return image;
    }

    public JSONObject getFile() {
        return file;
    }
}
