package com.Psychic_App_HW_NICHOLAS_GREGG.Model;

public class Choice {
    private double correctChoices;
    private double wrongChoices;
    private int totalChoices;

    public Choice(double correctChoices, double wrongChoices, int totalChoices) {
        this.correctChoices = correctChoices;
        this.wrongChoices = wrongChoices;
        this.totalChoices = totalChoices;
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


