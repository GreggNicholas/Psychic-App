package com.Psychic_App_HW_NICHOLAS_GREGG.Model;

public class Choice {
    private String userName;
    private double correctChoices;
    private double wrongChoices;
    private int totalChoices;


    public Choice(String userName, double correctChoices, double wrongChoices, int totalChoices) {
        this.userName = userName;
        this.correctChoices = correctChoices;
        this.wrongChoices = wrongChoices;
        this.totalChoices = totalChoices;
    }

    public String getUserName() {
        return userName;
    }

    public double getCorrectChoices() {
        return totalChoices - wrongChoices;
    }

    public double getWrongChoices() {
        return totalChoices - correctChoices;
    }

    public double getTotalChoices() {
        return wrongChoices + correctChoices;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCorrectChoices(double correctChoices) {
        this.correctChoices = correctChoices;
    }

    public void setWrongChoices(double wrongChoices) {
        this.wrongChoices = wrongChoices;
    }

    public void setTotalChoices(int totalChoices) {
        this.totalChoices = totalChoices;
    }
}


