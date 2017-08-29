package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import android.text.TextUtils;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;


public class RequiredValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

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
