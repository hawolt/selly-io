package com.hawolt.objects.creator;

import com.hawolt.objects.enumerable.Gateway;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProductCreator {

    private JSONObject object;

    private ProductCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {

        private JSONArray gateways = new JSONArray();

        public Builder setTitle(String o) {
            put("title", o);
            return this;
        }

        public Builder setDescription(String o) {
            put("description", o);
            return this;
        }

        public Builder setPrice(double o) {
            put("price", o);
            return this;
        }

        public Builder setProductType(int o) {
            put("product_type", o);
            return this;
        }

        public Builder addGateway(Gateway o) {
            gateways.put(o.toString());
            return this;
        }

        public Builder setCurrency(String o) {
            put("currency", o);
            return this;
        }

        public Builder setUnlisted(boolean o) {
            put("unlisted", o);
            return this;
        }

        public Builder setVpnBlock(boolean o) {
            put("vpn_block", o);
            return this;
        }

        public Builder setMaximumQuantity(int o) {
            put("maximum_quantity", o);
            return this;
        }

        public Builder setMinimumQuantity(int o) {
            put("minimum_quantity", o);
            return this;
        }

        public Builder setStockDelimiter(String o) {
            put("stock_delimiter", o);
            return this;
        }

        public Builder setStockAmount(int o) {
            put("stock_amount", o);
            return this;
        }

        public Builder setCryptoConfirmations(int o) {
            put("crypto_confirmations", o);
            return this;
        }

        public Builder setMaxRiskLevel(int o) {
            put("max_risk_level", o);
            return this;
        }

        public Builder setDynamicUrl(String o) {
            put("dynamic_url", o);
            return this;
        }

        public Builder setInfo(String o) {
            put("info", o);
            return this;
        }

        public Builder setCustom(JSONArray o) {
            put("custom", o);
            return this;
        }


        public Builder setWebhookUrl(String o) {
            put("webhook_url", o);
            return this;
        }


        public ProductCreator build() {
            return new ProductCreator(this.put("gateways", gateways));
        }
    }
}
