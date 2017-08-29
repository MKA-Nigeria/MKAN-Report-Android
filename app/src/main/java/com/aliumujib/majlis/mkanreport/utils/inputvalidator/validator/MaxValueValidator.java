package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

public class MaxValueValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

    private int mMaxValue;

    public MaxValueValidator(int value) {
        mMaxValue = value;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_max_value, mMaxValue);
    }

    @Override
    public boolean isValid(String value) {
        try {
            double d = Double.parseDouble(value);
            mErrorMessage = BaseApplication.getContext().getString(R.string.error_max_value, mMaxValue);
            return d <= mMaxValue;
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
