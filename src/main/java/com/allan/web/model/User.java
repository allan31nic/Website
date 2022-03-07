package com.allan.web.model;

import javax.validation.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Email can not be empty")
    private String userEmail;


    public User() {
    }

    public User(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                '}';
    }
}
