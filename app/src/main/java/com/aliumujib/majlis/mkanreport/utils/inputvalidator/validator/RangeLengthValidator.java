package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

public class RangeLengthValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

    private int mMaxLength, mMinLength;

    public RangeLengthValidator(int minLength, int maxLength) {
        if(minLength < 0)
            throw new IllegalArgumentException("You put a negative min length (" + minLength +")");
        if(maxLength < 0)
            throw new IllegalArgumentException("You put a negative max length (" + maxLength +")");
        if(minLength > maxLength)
            throw new IllegalArgumentException("The max length has to be superior or equal to the min length");

        mMaxLength = maxLength;
        mMinLength = minLength;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_range_length, mMinLength, mMaxLength);
    }

    @Override
    public boolean isValid(String value) {
        return value.length() >= mMinLength && value.length() <= mMaxLength;
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
