package com.example.finalproject;

import java.util.List;

class Issue {
    private int issueId;
    private String issueName;
    private User issueAssignee; // Quem é atribuido a tarefa
    private User issueAssigner; //Quem atribui a tarefa
    private double issueTotalHours;
    private double issueRemainingHours;
    private List<WorkLog> issueWorkLog; // uma lista com o work log do usuario para essa issue

}
