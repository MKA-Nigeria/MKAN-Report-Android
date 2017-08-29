package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;


public class NumericValidator extends AbstractValidator {

    public NumericValidator() {
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_number);
    }

    @Override
    public boolean isValid(String value) {
        return isNumeric(value);
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }

    protected boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
