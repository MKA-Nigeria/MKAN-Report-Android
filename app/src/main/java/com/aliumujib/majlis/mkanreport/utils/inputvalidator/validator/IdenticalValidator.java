package com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator;

import android.widget.EditText;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;

public class IdenticalValidator extends com.aliumujib.majlis.mkanreport.utils.inputvalidator.validator.AbstractValidator {

    private EditText mOtherEditText;

    public IdenticalValidator(EditText view) {
        mOtherEditText = view;
        mErrorMessage = BaseApplication.getContext().getString(R.string.error_fields_mismatch);
    }

    @Override
    public boolean isValid(String value) {
        return value.equals(mOtherEditText.getText().toString());
    }

    @Override
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
