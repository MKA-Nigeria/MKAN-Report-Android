package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import android.util.Patterns;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;


public class PhoneNumberValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

    public PhoneNumberValidator() {
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_phone_number);
    }

    @Override
    public boolean isValid(String value) {
        return Patterns.PHONE.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
