package com.example.finalproject;

import java.util.Date;

public class WorkLog {
    private Issue wlIssue; // issue escolhida
    private Date wlDate; // data do work log.
    private double wlHour; // Hora que foi gasta naquele dia na task especificada.
    private String wlDescription; //Descricao do que foi feito naquele dia

    public WorkLog(Issue wlIssue, Date wlDate, double wlHour, String wlDescription) {
        this.wlIssue = wlIssue;
        this.wlDate = wlDate;
        this.wlHour = wlHour;
        this.wlDescription = wlDescription;
    }

    public Issue getWlIssue() {
        return wlIssue;
    }

    public Date getWlDate() {
        return wlDate;
    }

    public double getWlHour() {
        return wlHour;
    }

    public String getWlDescription() {
        return wlDescription;
    }

    public void setWlIssue(Issue wlIssue) {
        this.wlIssue = wlIssue;
    }

    public void setWlDate(Date wlDate) {
        this.wlDate = wlDate;
    }

    public void setWlHour(double wlHour) {
        this.wlHour = wlHour;
    }

    public void setWlDescription(String wlDescription) {
        this.wlDescription = wlDescription;
    }

}
