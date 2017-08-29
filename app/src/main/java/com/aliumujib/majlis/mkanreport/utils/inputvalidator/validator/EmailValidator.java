package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

public class EmailValidator extends AbstractValidator {

    public EmailValidator() {
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_email);
    }

    @Override
    public boolean isValid(String value) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
