package com.example.studentregapp.model;

public class Message {
    private String message;
    private boolean flag;

    public Message(String message, boolean flag) {
        this.message = message;
        this.flag = flag;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
