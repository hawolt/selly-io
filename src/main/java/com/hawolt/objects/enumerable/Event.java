package com.hawolt.objects.enumerable;

public enum Event {
    FEEDBACK_CREATED,
    ORDER_PAID,
    ORDER_UPDATED;


    @Override
    public String toString() {
        return name().toLowerCase().replace("_", ":");
    }
}
