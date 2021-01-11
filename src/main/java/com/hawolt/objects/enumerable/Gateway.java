package com.hawolt.objects.enumerable;

public enum Gateway {
    BITCOIN,
    ETHEREUM,
    PAYPAL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
