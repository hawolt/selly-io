package com.hawolt.objects.creator;

import org.json.JSONArray;
import org.json.JSONObject;

public class CategoryCreator {

    private JSONObject object;

    private CategoryCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {
        private JSONArray ids = new JSONArray();

        public Builder setTitle(String o) {
            put("title", o);
            return this;
        }

        public Builder addId(String o) {
            ids.put(o);
            return this;
        }

        public Builder setUnlisted(boolean o) {
            put("unlisted", o);
            return this;
        }


        public CategoryCreator build() {
            return new CategoryCreator(this.put("product_ids", ids));
        }
    }
}
