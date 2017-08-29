package com.alium.mkan_report_data.models;

import com.parse.ParseObject;

/**
 * Created by abdulmujibaliu on 8/11/17.
 */

public class MKANReport {
    private boolean executiveMeetingConducted, hasQaidatSecretary, hasSubmittedLastMonthsReport;

    private String mutammadPhoneNumber, nazimTajnidPhoneNumber, nazimTaaleemPhoneNumber, nazimTarbiyyahPhoneNumber, nazimTablighPhoneNumber, nazimNauMubayeenPhoneNumber;

    private int
            //ETIMAD
            numberOfExecutiveMeetings, numberOfAttendeesAtExecutiveMeeting,
            numberPresentAtExecutiveMeetings, numberAbsentAtExecutiveMeeting,
            numberOfMulkMembersinQaidat,

    //TAJNEED
    totalNumberNoOfKhuddam, totalNumberOfKhuddamAtAge40ByDec, totalNumberOfKhuddamWithUniform,
            totalNumberOfAtfal,

    //TALEEM
    totalNumberOfTaleemClassesConductedInMonth, totalNoOfHoursSpentInTaaleemClasses,
            numberOfKhuddamThatParticipatedInTalimulQuranSession, numberOfKhuddamThatParticipatedInAgeGroupBookReview,
            numberOfKhuddamThatParticipatedInICTTraining, numberOfKhuddamThatParticipatedInProficiencyExamsPreparation,
            totalNumberOfKhuddamThatParticipatedInTaleemForMonth, numberOfBooksReviewedInMonth,

    //TARBIYYA
    numberOfTarbiyyaProgrammesConductedInMonth, numberOfKhuddamThatObserveCongregationPrayer, numberOfKhuddamThatWriteLettersToHuzur,
            numberOfKhuddamThatlistenToTheFridaySermon, numberOfKhuddamThatwatchTheMTARegularly, numberOfKhuddamThatAreRegularInTahjjudPrayer,
            numberOfKhuddamThatThatAreRegularInSalat, numberOfKhuddamThatEngageInVoluntaryFast, numberOfKhuddamThatReadConditionsOfBiat,

    //TABLIGH SECTION 1
        numberOfMediaCassettesDistributedInMonth, numberOfQuestionsAndAnswerSessionsHeldInMonth, numberOfPublicLecturesConductedInMonth,
            numberOfHouseToHousePreachingEventsHeldInMonth, numberOfLiteratureBooksDistributedInMonth, numberOfTablighMeetingsHeldInMonth, numberOfLettersOnTablighSentInTheMonth,
            numberOfBooksStallsMaintained, numberOfTablighSMSandEMailSentInMonth, numberOfBiatsSignedInMonth,

    //TABLIGH SECTION 2
    numberOfTablighProgrammesOrganizedInMonth, numberOfKhuddamParticipatingInTablighActivitiesOrganized,
            numberOfHoursSpentOnTablighProgrammes, numberOfClassesConductedbyTheTabglighTeamInMonth,

    //TARBIYAT NOU-MUBAYEEN
    numberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth, numberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth,
            numberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon, numberOfTarviyyatiMubayeenKhaddamWhoWroteToHuzoorInMonth, numberOfTarviyyatiMubayeenKhaddamWhoObserveSalat,
            numberOfTarviyyatiMubayeenKhaddamWhoReciteQuran, numberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah;

    public MKANReport(ParseObject parseObject) {
    }

    public MKANReport() {
    }

    public String getNazimNauMubayeenPhoneNumber() {
        return nazimNauMubayeenPhoneNumber;
    }

    public void setNazimNauMubayeenPhoneNumber(String nazimNauMubayeenPhoneNumber) {
        this.nazimNauMubayeenPhoneNumber = nazimNauMubayeenPhoneNumber;
    }

    public int getNumberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth() {
        return numberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth;
    }

    public void setNumberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth(int numberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth) {
        this.numberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth = numberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth;
    }

    public int getNumberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth() {
        return numberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth;
    }

    public void setNumberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth(int numberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth) {
        this.numberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth = numberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth;
    }

    public int getNumberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon() {
        return numberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon;
    }

    public void setNumberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon(int numberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon) {
        this.numberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon = numberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon;
    }

    public int getNumberOfTarviyyatiMubayeenKhaddamWhoWroteToHuzoorInMonth() {
        return numberOfTarviyyatiMubayeenKhaddamWhoWroteToHuzoorInMonth;
    }

    public void setNumberOfTarviyyatiMubayeenKhaddamWhoWroteHuzoorInMonth(int numberOfTarviyyatiMubayeenKhaddamToHuzoorForPrayersInMonth) {
        this.numberOfTarviyyatiMubayeenKhaddamWhoWroteToHuzoorInMonth = numberOfTarviyyatiMubayeenKhaddamToHuzoorForPrayersInMonth;
    }

    public int getNumberOfTarviyyatiMubayeenKhaddamWhoObserveSalat() {
        return numberOfTarviyyatiMubayeenKhaddamWhoObserveSalat;
    }

    public void setNumberOfTarviyyatiMubayeenKhaddamWhoObserveSalat(int numberOfTarviyyatiMubayeenKhaddamWhoObserveSalat) {
        this.numberOfTarviyyatiMubayeenKhaddamWhoObserveSalat = numberOfTarviyyatiMubayeenKhaddamWhoObserveSalat;
    }

    public int getNumberOfTarviyyatiMubayeenKhaddamWhoReciteQuran() {
        return numberOfTarviyyatiMubayeenKhaddamWhoReciteQuran;
    }

    public void setNumberOfTarviyyatiMubayeenKhaddamWhoReciteQuran(int numberOfTarviyyatiMubayeenKhaddamWhoReciteQuran) {
        this.numberOfTarviyyatiMubayeenKhaddamWhoReciteQuran = numberOfTarviyyatiMubayeenKhaddamWhoReciteQuran;
    }

    public int getNumberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah() {
        return numberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah;
    }

    public void setNumberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah(int numberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah) {
        this.numberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah = numberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah;
    }

    public String getNazimTablighPhoneNumber() {
        return nazimTablighPhoneNumber;
    }

    public void setNazimTablighPhoneNumber(String nazimTablighPhoneNumber) {
        this.nazimTablighPhoneNumber = nazimTablighPhoneNumber;
    }

    public int getNumberOfTablighProgrammesOrganizedInMonth() {
        return numberOfTablighProgrammesOrganizedInMonth;
    }

    public void setNumberOfTablighProgrammesOrganizedInMonth(int numberOfTablighProgrammesOrganizedInMonth) {
        this.numberOfTablighProgrammesOrganizedInMonth = numberOfTablighProgrammesOrganizedInMonth;
    }

    public int getNumberOfKhuddamParticipatingInTablighActivitiesOrganized() {
        return numberOfKhuddamParticipatingInTablighActivitiesOrganized;
    }

    public void setNumberOfKhuddamParticipatingInTablighActivitiesOrganized(int numberOfKhuddamParticipatingInTablighActivitiesOrganized) {
        this.numberOfKhuddamParticipatingInTablighActivitiesOrganized = numberOfKhuddamParticipatingInTablighActivitiesOrganized;
    }

    public int getNumberOfHoursSpentOnTablighProgrammes() {
        return numberOfHoursSpentOnTablighProgrammes;
    }

    public void setNumberOfHoursSpentOnTablighProgrammes(int numberOfHoursSpentOnTablighProgrammes) {
        this.numberOfHoursSpentOnTablighProgrammes = numberOfHoursSpentOnTablighProgrammes;
    }

    public int getNumberOfClassesConductedbyTheTabglighTeamInMonth() {
        return numberOfClassesConductedbyTheTabglighTeamInMonth;
    }

    public void setNumberOfClassesConductedbyTheTabglighTeamInMonth(int numberOfClassesConductedbyTheTabglighTeamInMonth) {
        this.numberOfClassesConductedbyTheTabglighTeamInMonth = numberOfClassesConductedbyTheTabglighTeamInMonth;
    }

    public int getNumberOfMediaCassettesDistributedInMonth() {
        return numberOfMediaCassettesDistributedInMonth;
    }

    public void setNumberOfMediaCassettesDistributedInMonth(int numberOfMediaCassettesDistributedInMonth) {
        this.numberOfMediaCassettesDistributedInMonth = numberOfMediaCassettesDistributedInMonth;
    }

    public int getNumberOfQuestionsAndAnswerSessionsHeldInMonth() {
        return numberOfQuestionsAndAnswerSessionsHeldInMonth;
    }

    public void setNumberOfQuestionsAndAnswerSessionsHeldInMonth(int numberOfQuestionsAndAnswerSessionsHeldInMonth) {
        this.numberOfQuestionsAndAnswerSessionsHeldInMonth = numberOfQuestionsAndAnswerSessionsHeldInMonth;
    }

    public int getNumberOfPublicLecturesConductedInMonth() {
        return numberOfPublicLecturesConductedInMonth;
    }

    public void setNumberOfPublicLecturesConductedInMonth(int numberOfPublicLecturesConductedInMonth) {
        this.numberOfPublicLecturesConductedInMonth = numberOfPublicLecturesConductedInMonth;
    }

    public int getNumberOfHouseToHousePreachingEventsHeldInMonth() {
        return numberOfHouseToHousePreachingEventsHeldInMonth;
    }

    public void setNumberOfHouseToHousePreachingEventsHeldInMonth(int numberOfHouseToHousePreachingEventsHeldInMonth) {
        this.numberOfHouseToHousePreachingEventsHeldInMonth = numberOfHouseToHousePreachingEventsHeldInMonth;
    }

    public int getNumberOfLiteratureBooksDistributedInMonth() {
        return numberOfLiteratureBooksDistributedInMonth;
    }

    public void setNumberOfLiteratureBooksDistributedInMonth(int numberOfLiteratureBooksDistributedInMonth) {
        this.numberOfLiteratureBooksDistributedInMonth = numberOfLiteratureBooksDistributedInMonth;
    }

    public int getNumberOfTablighMeetingsHeldInMonth() {
        return numberOfTablighMeetingsHeldInMonth;
    }

    public void setNumberOfTablighMeetingsHeldInMonth(int numberOfTablighMeetingsHeldInMonth) {
        this.numberOfTablighMeetingsHeldInMonth = numberOfTablighMeetingsHeldInMonth;
    }

    public int getNumberOfLettersOnTablighSentInTheMonth() {
        return numberOfLettersOnTablighSentInTheMonth;
    }

    public void setNumberOfLettersOnTablighSentInTheMonth(int numberOfLettersOnTablighSentInTheMonth) {
        this.numberOfLettersOnTablighSentInTheMonth = numberOfLettersOnTablighSentInTheMonth;
    }

    public int getNumberOfBooksStallsMaintained() {
        return numberOfBooksStallsMaintained;
    }

    public void setNumberOfBooksStallsMaintained(int numberOfBooksStallsMaintained) {
        this.numberOfBooksStallsMaintained = numberOfBooksStallsMaintained;
    }

    public int getNumberOfTablighSMSandEMailSentInMonth() {
        return numberOfTablighSMSandEMailSentInMonth;
    }

    public void setNumberOfTablighSMSandEMailSentInMonth(int numberOfTablighSMSandEMailSentInMonth) {
        this.numberOfTablighSMSandEMailSentInMonth = numberOfTablighSMSandEMailSentInMonth;
    }

    public int getNumberOfBiatsSignedInMonth() {
        return numberOfBiatsSignedInMonth;
    }

    public void setNumberOfBiatsSignedInMonth(int numberOfBiatsSignedInMonth) {
        this.numberOfBiatsSignedInMonth = numberOfBiatsSignedInMonth;
    }

    public String getNazimTarbiyyahPhoneNumber() {
        return nazimTarbiyyahPhoneNumber;
    }

    public void setNazimTarbiyyahPhoneNumber(String nazimTarbiyyahPhoneNumber) {
        this.nazimTarbiyyahPhoneNumber = nazimTarbiyyahPhoneNumber;
    }

    public int getNumberOfTarbiyyaProgrammesConductedInMonth() {
        return numberOfTarbiyyaProgrammesConductedInMonth;
    }

    public void setNumberOfTarbiyyaProgrammesConductedInMonth(int numberOfTarbiyyaProgrammesConductedInMonth) {
        this.numberOfTarbiyyaProgrammesConductedInMonth = numberOfTarbiyyaProgrammesConductedInMonth;
    }

    public int getNumberOfKhuddamThatObserveCongregationPrayer() {
        return numberOfKhuddamThatObserveCongregationPrayer;
    }

    public void setNumberOfKhuddamThatObserveCongregationPrayer(int numberOfKhuddamThatObserveCongregationPrayer) {
        this.numberOfKhuddamThatObserveCongregationPrayer = numberOfKhuddamThatObserveCongregationPrayer;
    }

    public int getNumberOfKhuddamThatWriteLettersToHuzur() {
        return numberOfKhuddamThatWriteLettersToHuzur;
    }

    public void setNumberOfKhuddamThatWriteLettersToHuzur(int numberOfKhuddamThatWriteLettersToHuzur) {
        this.numberOfKhuddamThatWriteLettersToHuzur = numberOfKhuddamThatWriteLettersToHuzur;
    }

    public int getNumberOfKhuddamThatlistenToTheFridaySermon() {
        return numberOfKhuddamThatlistenToTheFridaySermon;
    }

    public void setNumberOfKhuddamThatlistenToTheFridaySermon(int numberOfKhuddamThatlistenToTheFridaySermon) {
        this.numberOfKhuddamThatlistenToTheFridaySermon = numberOfKhuddamThatlistenToTheFridaySermon;
    }

    public int getNumberOfKhuddamThatwatchTheMTARegularly() {
        return numberOfKhuddamThatwatchTheMTARegularly;
    }

    public void setNumberOfKhuddamThatwatchTheMTARegularly(int numberOfKhuddamThatwatchTheMTARegularly) {
        this.numberOfKhuddamThatwatchTheMTARegularly = numberOfKhuddamThatwatchTheMTARegularly;
    }

    public int getNumberOfKhuddamThatAreRegularInTahjjudPrayer() {
        return numberOfKhuddamThatAreRegularInTahjjudPrayer;
    }

    public void setNumberOfKhuddamThatAreRegularInTahjjudPrayer(int numberOfKhuddamThatAreRegularInTahjjudPrayer) {
        this.numberOfKhuddamThatAreRegularInTahjjudPrayer = numberOfKhuddamThatAreRegularInTahjjudPrayer;
    }

    public int getNumberOfKhuddamThatThatAreRegularInSalat() {
        return numberOfKhuddamThatThatAreRegularInSalat;
    }

    public void setNumberOfKhuddamThatThatAreRegularInSalat(int numberOfKhuddamThatThatAreRegularInSalat) {
        this.numberOfKhuddamThatThatAreRegularInSalat = numberOfKhuddamThatThatAreRegularInSalat;
    }

    public int getNumberOfKhuddamThatEngageInVoluntaryFast() {
        return numberOfKhuddamThatEngageInVoluntaryFast;
    }

    public void setNumberOfKhuddamThatEngageInVoluntaryFast(int numberOfKhuddamThatEngageInVoluntaryFast) {
        this.numberOfKhuddamThatEngageInVoluntaryFast = numberOfKhuddamThatEngageInVoluntaryFast;
    }

    public int getNumberOfKhuddamThatReadConditionsOfBiat() {
        return numberOfKhuddamThatReadConditionsOfBiat;
    }

    public void setNumberOfKhuddamThatReadConditionsOfBiat(int numberOfKhuddamThatReadConditionsOfBiat) {
        this.numberOfKhuddamThatReadConditionsOfBiat = numberOfKhuddamThatReadConditionsOfBiat;
    }

    public String getNazimTajnidPhoneNumber() {
        return nazimTajnidPhoneNumber;
    }

    public int getNumberOfBooksReviewedInMonth() {
        return numberOfBooksReviewedInMonth;
    }

    public void setNumberOfBooksReviewedInMonth(int numberOfBooksReviewedInMonth) {
        this.numberOfBooksReviewedInMonth = numberOfBooksReviewedInMonth;
    }

    public void setNazimTajnidPhoneNumber(String nazimTajnidPhoneNumber) {
        this.nazimTajnidPhoneNumber = nazimTajnidPhoneNumber;
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

    public boolean isExecutiveMeetingConducted() {
        return executiveMeetingConducted;
    }

    public void setExecutiveMeetingConducted(boolean executiveMeetingConducted) {
        this.executiveMeetingConducted = executiveMeetingConducted;
    }

    public boolean isHasQaidatSecretary() {
        return hasQaidatSecretary;
    }

    public boolean isHasSubmittedLastMonthsReport() {
        return hasSubmittedLastMonthsReport;
    }

    public String getMutammadPhoneNumber() {
        return mutammadPhoneNumber;
    }

    public int getTotalNumberNoOfKhuddam() {
        return totalNumberNoOfKhuddam;
    }

    public int getNumberOfExecutiveMeetings() {
        return numberOfExecutiveMeetings;
    }

    public int getNumberOfAttendeesAtExecutiveMeeting() {
        return numberOfAttendeesAtExecutiveMeeting;
    }

    public int getNumberPresentAtExecutiveMeetings() {
        return numberPresentAtExecutiveMeetings;
    }

    public int getNumberAbsentAtExecutiveMeeting() {
        return numberAbsentAtExecutiveMeeting;
    }

    public int getNumberOfMulkMembersinQaidat() {
        return numberOfMulkMembersinQaidat;
    }

    public void setHasQaidatSecretary(boolean hasQaidatSecretary) {
        this.hasQaidatSecretary = hasQaidatSecretary;
    }

    public void setHasSubmittedLastMonthsReport(boolean hasSubmittedLastMonthsReport) {
        this.hasSubmittedLastMonthsReport = hasSubmittedLastMonthsReport;
    }

    public void setMutammadPhoneNumber(String mutammadPhoneNumber) {
        this.mutammadPhoneNumber = mutammadPhoneNumber;
    }

    public void setTotalNumberNoOfKhuddam(int totalNumberNoOfKhuddam) {
        this.totalNumberNoOfKhuddam = totalNumberNoOfKhuddam;
    }

    public void setNumberOfExecutiveMeetings(int numberOfExecutiveMeetings) {
        this.numberOfExecutiveMeetings = numberOfExecutiveMeetings;
    }

    public void setNumberOfAttendeesAtExecutiveMeeting(int numberOfAttendeesAtExecutiveMeeting) {
        this.numberOfAttendeesAtExecutiveMeeting = numberOfAttendeesAtExecutiveMeeting;
    }

    public void setNumberPresentAtExecutiveMeetings(int numberPresentAtExecutiveMeetings) {
        this.numberPresentAtExecutiveMeetings = numberPresentAtExecutiveMeetings;
    }

    public void setNumberAbsentAtExecutiveMeeting(int numberAbsentAtExecutiveMeeting) {
        this.numberAbsentAtExecutiveMeeting = numberAbsentAtExecutiveMeeting;
    }

    public void setNumberOfMulkMembersinQaidat(int numberOfMulkMembersinQaidat) {
        this.numberOfMulkMembersinQaidat = numberOfMulkMembersinQaidat;
    }

    public String getNazimTaaleemPhoneNumber() {
        return nazimTaaleemPhoneNumber;
    }

    public void setNazimTaaleemPhoneNumber(String nazimTaaleemPhoneNumber) {
        this.nazimTaaleemPhoneNumber = nazimTaaleemPhoneNumber;
    }

    public int getTotalNumberOfTaleemClassesConductedInMonth() {
        return totalNumberOfTaleemClassesConductedInMonth;
    }

    public void setTotalNumberOfTaleemClassesConductedInMonth(int totalNumberOfTaleemClassesConductedInMonth) {
        this.totalNumberOfTaleemClassesConductedInMonth = totalNumberOfTaleemClassesConductedInMonth;
    }

    public int getTotalNoOfHoursSpentInTaaleemClasses() {
        return totalNoOfHoursSpentInTaaleemClasses;
    }

    public void setTotalNoOfHoursSpentInTaaleemClasses(int totalNoOfHoursSpentInTaaleemClasses) {
        this.totalNoOfHoursSpentInTaaleemClasses = totalNoOfHoursSpentInTaaleemClasses;
    }

    public int getNumberOfKhuddamThatParticipatedInTalimulQuranSession() {
        return numberOfKhuddamThatParticipatedInTalimulQuranSession;
    }

    public void setNumberOfKhuddamThatParticipatedInTalimulQuranSession(int numberOfKhuddamThatParticipatedInTalimulQuranSession) {
        this.numberOfKhuddamThatParticipatedInTalimulQuranSession = numberOfKhuddamThatParticipatedInTalimulQuranSession;
    }

    public int getNumberOfKhuddamThatParticipatedInAgeGroupBookReview() {
        return numberOfKhuddamThatParticipatedInAgeGroupBookReview;
    }

    public void setNumberOfKhuddamThatParticipatedInAgeGroupBookReview(int numberOfKhuddamThatParticipatedInAgeGroupBookReview) {
        this.numberOfKhuddamThatParticipatedInAgeGroupBookReview = numberOfKhuddamThatParticipatedInAgeGroupBookReview;
    }

    public int getNumberOfKhuddamThatParticipatedInICTTraining() {
        return numberOfKhuddamThatParticipatedInICTTraining;
    }

    public void setNumberOfKhuddamThatParticipatedInICTTraining(int numberOfKhuddamThatParticipatedInICTTraining) {
        this.numberOfKhuddamThatParticipatedInICTTraining = numberOfKhuddamThatParticipatedInICTTraining;
    }

    public int getNumberOfKhuddamThatParticipatedInProficiencyExamsPreparation() {
        return numberOfKhuddamThatParticipatedInProficiencyExamsPreparation;
    }

    public void setNumberOfKhuddamThatParticipatedInProficiencyExamsPreparation(int numberOfKhuddamThatParticipatedInProficiencyExamsPreparation) {
        this.numberOfKhuddamThatParticipatedInProficiencyExamsPreparation = numberOfKhuddamThatParticipatedInProficiencyExamsPreparation;
    }

    public int getTotalNumberOfKhuddamThatParticipatedInTaleemForMonth() {
        return totalNumberOfKhuddamThatParticipatedInTaleemForMonth;
    }

    public void setTotalNumberOfKhuddamThatParticipatedInTaleemForMonth(int totalNumberOfKhuddamThatParticipatedInTaleemForMonth) {
        this.totalNumberOfKhuddamThatParticipatedInTaleemForMonth = totalNumberOfKhuddamThatParticipatedInTaleemForMonth;
    }
}
