package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import android.util.Patterns;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;


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
