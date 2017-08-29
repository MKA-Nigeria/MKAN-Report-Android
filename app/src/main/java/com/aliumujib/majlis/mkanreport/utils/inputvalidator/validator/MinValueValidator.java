package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

public class MinValueValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

    private int mMinValue;

    public MinValueValidator(int value) {
        mMinValue = value;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_min_value, mMinValue);
    }

    @Override
    public boolean isValid(String value) {
        try {
            double d = Double.parseDouble(value);
            mErrorMessage = BaseApplication.getContext().getString(R.string.error_min_value, mMinValue);
            return d >= mMinValue;
        }
        catch(NumberFormatException nfe) {
            mErrorMessage = BaseApplication.getContext().getString(R.string.error_invalid_number);
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
