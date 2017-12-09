package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


public class ValidateValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

    public ValidateValidator() {
    }

    @Override
    public boolean isValid(String value) {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
