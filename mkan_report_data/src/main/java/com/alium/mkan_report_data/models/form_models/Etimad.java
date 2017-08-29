package com.alium.mkan_report_data.models.form_models;

/**
 * Created by abdulmujibaliu on 8/19/17.
 */

public class Etimad {

    private boolean executiveMeetingConducted, hasQaidatSecretary, hasSubmittedLastMonthsReport;
    private String mutammadPhoneNumber;

    private int  //ETIMAD
            numberOfExecutiveMeetings, numberOfAttendeesAtExecutiveMeeting,
            numberPresentAtExecutiveMeetings, numberAbsentAtExecutiveMeeting,
            numberOfMulkMembersinQaidat;


    public boolean isExecutiveMeetingConducted() {
        return executiveMeetingConducted;
    }

    public void setExecutiveMeetingConducted(boolean executiveMeetingConducted) {
        this.executiveMeetingConducted = executiveMeetingConducted;
    }

    public boolean isHasQaidatSecretary() {
        return hasQaidatSecretary;
    }

    public void setHasQaidatSecretary(boolean hasQaidatSecretary) {
        this.hasQaidatSecretary = hasQaidatSecretary;
    }

    public boolean isHasSubmittedLastMonthsReport() {
        return hasSubmittedLastMonthsReport;
    }

    public void setHasSubmittedLastMonthsReport(boolean hasSubmittedLastMonthsReport) {
        this.hasSubmittedLastMonthsReport = hasSubmittedLastMonthsReport;
    }

    public String getMutammadPhoneNumber() {
        return mutammadPhoneNumber;
    }

    public void setMutammadPhoneNumber(String mutammadPhoneNumber) {
        this.mutammadPhoneNumber = mutammadPhoneNumber;
    }

    public int getNumberOfExecutiveMeetings() {
        return numberOfExecutiveMeetings;
    }

    public void setNumberOfExecutiveMeetings(int numberOfExecutiveMeetings) {
        this.numberOfExecutiveMeetings = numberOfExecutiveMeetings;
    }

    public int getNumberOfAttendeesAtExecutiveMeeting() {
        return numberOfAttendeesAtExecutiveMeeting;
    }

    public void setNumberOfAttendeesAtExecutiveMeeting(int numberOfAttendeesAtExecutiveMeeting) {
        this.numberOfAttendeesAtExecutiveMeeting = numberOfAttendeesAtExecutiveMeeting;
    }

    public int getNumberPresentAtExecutiveMeetings() {
        return numberPresentAtExecutiveMeetings;
    }

    public void setNumberPresentAtExecutiveMeetings(int numberPresentAtExecutiveMeetings) {
        this.numberPresentAtExecutiveMeetings = numberPresentAtExecutiveMeetings;
    }

    public int getNumberAbsentAtExecutiveMeeting() {
        return numberAbsentAtExecutiveMeeting;
    }

    public void setNumberAbsentAtExecutiveMeeting(int numberAbsentAtExecutiveMeeting) {
        this.numberAbsentAtExecutiveMeeting = numberAbsentAtExecutiveMeeting;
    }

    public int getNumberOfMulkMembersinQaidat() {
        return numberOfMulkMembersinQaidat;
    }

    public void setNumberOfMulkMembersinQaidat(int numberOfMulkMembersinQaidat) {
        this.numberOfMulkMembersinQaidat = numberOfMulkMembersinQaidat;
    }
}
