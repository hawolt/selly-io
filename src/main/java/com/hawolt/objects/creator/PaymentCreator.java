package com.hawolt.objects.creator;

import com.hawolt.objects.Payment;
import org.json.JSONObject;

public class PaymentCreator {

    private JSONObject object;

    private PaymentCreator(JSONObject object) {
        this.object = object;
    }

    public JSONObject getJSONObject() {
        return object;
    }

    public Payment build() {
        return new Payment(object);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends JSONObject {

        public Builder setTitle(String o) {
            put("title", o);
            return this;
        }

        public Builder setCustomerEmail(String o) {
            put("email", o);
            return this;
        }

        public Builder setCurrency(String o) {
            put("currency", o);
            return this;
        }

        public Builder setValue(double o) {
            put("value", o);
            return this;
        }

        public Builder setGateway(String o) {
            put("gateway", o);
            return this;
        }

        public Builder setConfirmations(int o) {
            put("confirmations", o);
            return this;
        }

        public Builder setWhitelabel(boolean o) {
            put("white_label", o);
            return this;
        }

        public Builder setIpAddress(String o) {
            put("ip_address", o);
            return this;
        }

        public Builder setReturnUrl(String o) {
            put("return_url", o);
            return this;
        }

        public Builder setWebhookUrl(String o) {
            put("webhook_url", o);
            return this;
        }

        public PaymentCreator build() {
            return new PaymentCreator(this);
        }
    }
}
