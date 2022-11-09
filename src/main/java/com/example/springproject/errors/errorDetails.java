package com.example.springproject.errors;

public class errorDetails {
    private String message;
    private String uri;

    public errorDetails(String message, String uri) {
        this.message = message;
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "errorDetails{" +
                "message='" + message + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
