package com.hexasoftwares.quizbuddy.model;

public class DataModel {
    private String que;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private int correctAnswer;

    public DataModel(String que, String optA, String optB, String optC, String optD, int correctAnswer) {
        this.que = que;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.correctAnswer = correctAnswer;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
