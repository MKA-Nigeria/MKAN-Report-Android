package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


public abstract class AbstractValidator {

    String mErrorMessage = "This field is not valid";

    public abstract boolean isValid(String value);

    public abstract String getErrorMessage();

    public void setErrorMessage(String message) {
        mErrorMessage = message;
    }
}
