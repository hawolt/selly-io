package com.hawolt;

public class SellyException extends RuntimeException {

    private Type type;

    public SellyException(int code) {
        this.type = Type.find(code);
    }

    @Override
    public String getMessage() {
        return String.join(":", type.name(), String.valueOf(type.getCode()), type.getMessage());
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        UNKNOWN(-1, "Unknown Exception"),
        BAD_REQUEST(400, "Invalid parameters"),
        Unauthorized(401, "Invalid parameters"),
        Forbidden(403, "Invalid parameters"),
        NOT_FOUND(404, "Invalid parameters"),
        NOT_ACCEPTABLE(406, "Invalid parameters"),
        TOO_MANY_REQUESTS(429, "Invalid parameters"),
        INTERNAL_SERVER_ERROR(500, "Invalid parameters"),
        SERVICE_UNAVAILABLE(503, "Invalid parameters");
        private int code;
        private String message;

        Type(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        private static final Type[] TYPES = Type.values();

        public static Type find(int code) {
            for (Type type : TYPES) {
                if (type.getCode() == code) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }
}
