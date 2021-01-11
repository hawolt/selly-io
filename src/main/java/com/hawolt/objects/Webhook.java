package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONArray;
import org.json.JSONObject;

public class Webhook extends SellyJson {
    private String id, url, createdAt, updatedAt;
    private boolean enabled;
    private JSONArray events;

    public Webhook(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.url = o.getString("url");
        this.enabled = o.getBoolean("enabled");
        this.events = o.getJSONArray("events");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public JSONArray getEvents() {
        return events;
    }
}
