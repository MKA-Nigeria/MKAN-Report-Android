package com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator;


import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.app.BaseApplication;

public class MinLengthValidator extends com.aliumujib.majlis.mkan_report_app.utils.inputvalidator.validator.AbstractValidator {

    private int mLength;

    public MinLengthValidator(int length) {
        if(length < 0)
            throw new IllegalArgumentException("You put a negative min length (" + length +")");
        mLength = length;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_min_length, mLength);
    }

    @Override
    public boolean isValid(String value) {
        return value.length() >= mLength;
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
