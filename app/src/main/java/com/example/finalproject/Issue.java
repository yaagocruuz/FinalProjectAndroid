package com.example.finalproject;

import java.util.List;

class Issue {
    private String issueId;
    private String issueName;
    private String issueAssignee;
    private User issueAssigner; //Quem atribui a tarefa
    private double issueTotalHours;
    private double issueRemainingHours;
    private List<WorkLog> issueWorkLog; // uma lista com o work log do usuario para essa issue

    public Issue() {}

    public Issue(String issueName, String issueAssignee, double issueTotalHours) {
        this.issueName = issueName;
        this.issueAssignee = issueAssignee;
        this.issueTotalHours = issueTotalHours;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getIssueAssignee() {
        return issueAssignee;
    }

    public void setIssueAssignee(String issueAssignee) {
        this.issueAssignee = issueAssignee;
    }

    public User getIssueAssigner() {
        return issueAssigner;
    }

    public void setIssueAssigner(User issueAssigner) {
        this.issueAssigner = issueAssigner;
    }

    public double getIssueTotalHours() {
        return issueTotalHours;
    }

    public void setIssueTotalHours(double issueTotalHours) {
        this.issueTotalHours = issueTotalHours;
    }

    public double getIssueRemainingHours() {
        return issueRemainingHours;
    }

    public void setIssueRemainingHours(double issueRemainingHours) {
        this.issueRemainingHours = issueRemainingHours;
    }

    public List<WorkLog> getIssueWorkLog() {
        return issueWorkLog;
    }

    public void setIssueWorkLog(List<WorkLog> issueWorkLog) {
        this.issueWorkLog = issueWorkLog;
    }
}
