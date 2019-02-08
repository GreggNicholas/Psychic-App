package com.Psychic_App_HW_NICHOLAS_GREGG.Model;

public class Choice {
    private String userName;
    private int correctChoice;
    private int Choice;
    private int totalChoicesMade;


    public Choice(String userName, int correctChoice, int wrongChoice, int totalChoicesMade) {
        this.userName = userName;
        this.correctChoice = correctChoice;
        this.Choice = wrongChoice;
        this.totalChoicesMade = totalChoicesMade;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(int correctChoice) {
        this.correctChoice = correctChoice;
    }

    public int getChoice() {
        return Choice;
    }

    public void setChoice(int choice) {
        this.Choice = choice;
    }

    public int getTotalChoicesMade() {
        return totalChoicesMade;
    }

    public void setTotalChoicesMade(int totalChoicesMade) {
        this.totalChoicesMade = totalChoicesMade;
    }


}
