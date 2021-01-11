package com.hawolt.objects.creator;

import org.json.JSONObject;

public class RuleCreator {

    private JSONObject object;

    private RuleCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {

        public Builder setAction(boolean o) {
            put("action_type", o ? "allow" : "block");
            return this;
        }

        public Builder setName(String o) {
            put("name", o);
            return this;
        }

        public Builder setEnabled(boolean o) {
            put("enabled", o);
            return this;
        }

        public Builder setRule(String o) {
            put("rule", o);
            return this;
        }

        public RuleCreator build() {
            return new RuleCreator(this);
        }
    }
}
