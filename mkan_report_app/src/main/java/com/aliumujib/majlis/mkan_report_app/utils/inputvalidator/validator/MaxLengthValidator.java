package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;

public class MaxLengthValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

    private int mLength;

    public MaxLengthValidator(int length) {
        if(length < 0)
            throw new IllegalArgumentException("You put a negative max length (" + length +")");
        if(length == 0)
            throw new IllegalArgumentException("Max length cannot be equal to zero");
        mLength = length;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_max_length, mLength);
    }

    @Override
    public boolean isValid(String value) {
        return value.length() <= mLength;
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
