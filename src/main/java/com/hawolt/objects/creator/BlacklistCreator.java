package com.hawolt.objects.creator;

import org.json.JSONObject;

public class BlacklistCreator {

    private JSONObject object;

    private BlacklistCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {

        public Builder setType(int o) {
            put("blacklist_type", o);
            return this;
        }

        public Builder setBlockedData(String o) {
            put("blocked_data", o);
            return this;
        }

        public Builder setNote(String o) {
            put("note", o);
            return this;
        }

        public BlacklistCreator build() {
            return new BlacklistCreator(this);
        }
    }
}
