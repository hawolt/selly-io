package com.hawolt;

public abstract class SellyResource {
    protected String location;

    public SellyResource(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
