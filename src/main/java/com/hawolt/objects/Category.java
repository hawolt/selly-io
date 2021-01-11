package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONArray;
import org.json.JSONObject;

public class Category extends SellyJson {
    private String id, title, createdAt, updatedAt;
    private JSONArray productIds;
    private boolean unlisted;
    private JSONObject image;

    public Category(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.title = o.getString("title");
        this.productIds = o.getJSONArray("product_ids");
        this.unlisted = o.getBoolean("unlisted");
        this.image = o.getJSONObject("image");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public JSONArray getProductIds() {
        return productIds;
    }

    public boolean isUnlisted() {
        return unlisted;
    }

    public JSONObject getImage() {
        return image;
    }
}
