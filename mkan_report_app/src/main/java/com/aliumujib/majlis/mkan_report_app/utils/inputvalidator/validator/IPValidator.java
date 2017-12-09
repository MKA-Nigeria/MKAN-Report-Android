package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import android.util.Patterns;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;


public class IPValidator extends AbstractValidator {

    public IPValidator() {
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_ip);
    }

    @Override
    public boolean isValid(String value) {
        return Patterns.IP_ADDRESS.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
