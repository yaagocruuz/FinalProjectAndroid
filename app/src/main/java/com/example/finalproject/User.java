package com.example.finalproject;

import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private String senha;
    private String sobrenome;
    private List<Issue> userIssues;
    private String userLocation; //Trocar de String para Location, ou algo do tipo.

    public User(){}

    public User(String name, String email, String senha, String sobrenome) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.sobrenome = sobrenome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
