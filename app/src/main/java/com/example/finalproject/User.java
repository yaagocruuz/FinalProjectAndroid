package com.example.finalproject;

import java.util.List;

public class User {
    private String userId;
    private String firstName;
    private String email;
    private String lastName;
    private List<Issue> userIssues;
    private String userLocation; //Trocar de String para Location, ou algo do tipo.

    public User(){}

    public User(String firstName, String email, String lastName) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Issue> getUserIssues() {
        return userIssues;
    }

    public void setUserIssues(List<Issue> userIssues) {
        this.userIssues = userIssues;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
}
