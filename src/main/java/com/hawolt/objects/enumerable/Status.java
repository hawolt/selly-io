package com.hawolt.objects.enumerable;

public enum Status {
    NOT_PAID(0),
    CHARGEBACK(51),
    HIGH_RISK(52),
    PARTIALLY_PAID(53),
    AWAITING_CONFIRMATIONS(54),
    PENDING_PAYPAL(55),
    REFUNDED(56),
    COMPLETED(100),
    UNKNOWN(-1);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    private static final Status[] STATUSES = Status.values();

    public static Status find(int code) {
        for (Status status : STATUSES) {
            if (status.code == code) {
                return status;
            }
        }
        return UNKNOWN;
    }

}
