package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

import java.util.regex.Pattern;

public class RegexValidator extends AbstractValidator {

    private Pattern mRegexPattern;

    public RegexValidator(String regex) {
        mRegexPattern = Pattern.compile(regex);
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_field);
    }

    @Override
    public boolean isValid(String value) {
        return mRegexPattern.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
