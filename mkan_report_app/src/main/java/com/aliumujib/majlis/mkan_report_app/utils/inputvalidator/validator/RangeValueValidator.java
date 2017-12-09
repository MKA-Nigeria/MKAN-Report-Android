package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;

public class RangeValueValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

    private int mMinValue, mMaxValue;

    public RangeValueValidator(int minValue, int maxValue) {
        if(minValue > maxValue)
            throw new IllegalArgumentException("The max value has to be superior or equal to the min value");

        mMinValue = minValue;
        mMaxValue = maxValue;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_range_value, mMinValue, mMaxValue);
    }

    @Override
    public boolean isValid(String value) {
        try {
            double d = Double.parseDouble(value);
            mErrorMessage = BaseApplication.getContext().getString(R.string.error_range_value, mMinValue, mMaxValue);
            return d >= mMinValue && d <= mMaxValue;
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
