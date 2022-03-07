package com.allan.web.model;

public enum Message {
    SENT("Message has been sent");
    String message;

    Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
