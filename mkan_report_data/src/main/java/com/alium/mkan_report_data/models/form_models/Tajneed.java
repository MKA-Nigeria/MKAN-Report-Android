package com.alium.mkan_report_data.models.form_models;

/**
 * Created by abdulmujibaliu on 8/19/17.
 */

public class Tajneed {

    private int //TAJNEED
            totalNumberNoOfKhuddam, totalNumberOfKhuddamAtAge40ByDec, totalNumberOfKhuddamWithUniform,
            totalNumberOfAtfal;

    private String  nazimTajnidPhoneNumber;

    public int getTotalNumberNoOfKhuddam() {
        return totalNumberNoOfKhuddam;
    }

    public void setTotalNumberNoOfKhuddam(int totalNumberNoOfKhuddam) {
        this.totalNumberNoOfKhuddam = totalNumberNoOfKhuddam;
    }

    public int getTotalNumberOfKhuddamAtAge40ByDec() {
        return totalNumberOfKhuddamAtAge40ByDec;
    }

    public void setTotalNumberOfKhuddamAtAge40ByDec(int totalNumberOfKhuddamAtAge40ByDec) {
        this.totalNumberOfKhuddamAtAge40ByDec = totalNumberOfKhuddamAtAge40ByDec;
    }

    public int getTotalNumberOfKhuddamWithUniform() {
        return totalNumberOfKhuddamWithUniform;
    }

    public void setTotalNumberOfKhuddamWithUniform(int totalNumberOfKhuddamWithUniform) {
        this.totalNumberOfKhuddamWithUniform = totalNumberOfKhuddamWithUniform;
    }

    public int getTotalNumberOfAtfal() {
        return totalNumberOfAtfal;
    }

    public void setTotalNumberOfAtfal(int totalNumberOfAtfal) {
        this.totalNumberOfAtfal = totalNumberOfAtfal;
    }

    public String getNazimTajnidPhoneNumber() {
        return nazimTajnidPhoneNumber;
    }

    public void setNazimTajnidPhoneNumber(String nazimTajnidPhoneNumber) {
        this.nazimTajnidPhoneNumber = nazimTajnidPhoneNumber;
    }
}
