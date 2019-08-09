package com.education.files.model;

public class Error {
    private String message;
    private String value;
    private String sid;

    public Error() {
    }

    public Error(String message, String value, String sid) {
        this.message = message;
        this.value = value;
        this.sid = sid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", value='" + value + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
