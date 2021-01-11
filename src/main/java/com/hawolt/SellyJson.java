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

    public <T> T asTypeOf(Class<? extends SellyJson> o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = o.getDeclaredConstructor(JSONObject.class);
        return (T) constructor.newInstance(raw);
    }

}
