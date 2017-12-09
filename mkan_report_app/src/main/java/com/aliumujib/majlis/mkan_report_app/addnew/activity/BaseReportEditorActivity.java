package com.aliumujib.majlis.mkan_report_app.addnew.activity;

import android.content.Intent;
import android.os.Bundle;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.mkanapps.coremodule.utils.ToastUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.stepstone.stepper.VerificationError;

import static com.alium.mkan_report_data.constants.Constants.CAPTURE_MEDIA;


public abstract class BaseReportEditorActivity extends AbstractStepperActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBackNavigationButton(R.id.toolbar);
        setActionBarTitle("Edit profile");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAPTURE_MEDIA && resultCode == RESULT_OK) {
            getSupportFragmentManager().getFragments().get(0).onActivityResult(requestCode, resultCode, data);
        }
    }


    protected abstract void init();

    protected abstract void populateWithExitingData(ParseUser ownerObj, ParseObject userExtParseObject);

    @Override
    protected int getLayoutResId() {
        return R.layout.base_activity_edit_report;
    }

    @Override
    public void onError(VerificationError verificationError) {
        ToastUtils.shortToast(verificationError.getErrorMessage());
    }
}
