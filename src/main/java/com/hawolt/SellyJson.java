package com.hawolt;

import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SellyJson {
    protected JSONObject raw;

    public SellyJson(JSONObject raw) {
        this.raw = raw;
    }

    public JSONObject getOriginal() {
        return raw;
    }
}
