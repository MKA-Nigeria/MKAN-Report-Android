package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


public class ValidateValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

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
