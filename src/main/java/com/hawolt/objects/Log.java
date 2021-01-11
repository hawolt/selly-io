package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONObject;

public class Log extends SellyJson {
    private JSONObject payload, headers;
    private String id, url, response, event, nextRetryAt, createdAt, updatedAt;
    private int responseCode, retries, retryLimit;

    public Log(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.url = o.getString("url");
        this.payload = o.getJSONObject("payload");
        this.response = o.getString("response");
        this.responseCode = o.getInt("response_code");
        this.headers = o.getJSONObject("response_headers");
        this.retries = o.getInt("retries");
        this.event = o.getString("event");
        this.retryLimit = o.getInt("retry_limit");
        this.nextRetryAt = o.getString("next_retry_at");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public JSONObject getPayload() {
        return payload;
    }

    public JSONObject getHeaders() {
        return headers;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getResponse() {
        return response;
    }

    public String getEvent() {
        return event;
    }

    public String getNextRetryAt() {
        return nextRetryAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getRetries() {
        return retries;
    }

    public int getRetryLimit() {
        return retryLimit;
    }
}
