package com.hawolt.objects.creator;

import com.hawolt.objects.enumerable.Event;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebhookCreator {

    private JSONObject object;

    private WebhookCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {

        private JSONArray events = new JSONArray();

        public Builder setUrl(String o) {
            put("url", o);
            return this;
        }

        public Builder addEvent(Event e) {
            events.put(e.toString());
            return this;
        }

        public WebhookCreator build() {
            return new WebhookCreator(this.put("events", events));
        }
    }
}
