package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import android.util.Patterns;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;


public class UrlValidator extends AbstractValidator {

    public UrlValidator() {
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_url);
    }

    @Override
    public boolean isValid(String value) {
        return Patterns.WEB_URL.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
