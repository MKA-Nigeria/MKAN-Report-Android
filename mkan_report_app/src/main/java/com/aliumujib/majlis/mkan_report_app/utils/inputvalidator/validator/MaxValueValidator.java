package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;

public class MaxValueValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

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
