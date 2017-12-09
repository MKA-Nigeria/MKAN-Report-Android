package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import android.text.TextUtils;


public class RequiredValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

    private boolean mRequired;

    public RequiredValidator(boolean required) {
        mRequired = required;
        mErrorMessage = "This field is required";
    }

    @Override
    public boolean isValid(String value) {
        if(mRequired)
            return !TextUtils.isEmpty(value);
        return true;
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String message) {
        mRequired = true;
        mErrorMessage = message;
    }
}
