/*
Copyright 2016 StepStone Services

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.aliumujib.majlis.mkanreport.addnew.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.addnew.adapters.EditReportStepAdapter;
import com.aliumujib.majlis.mkanreport.base.BaseActivity;
import com.stepstone.stepper.StepperLayout;


public abstract class AbstractStepperActivity extends BaseActivity implements StepperLayout.StepperListener{

    private static final String CURRENT_STEP_POSITION_KEY = "position";
    int mStartingStepPosition;
    protected StepperLayout mStepperLayout;
    protected EditReportStepAdapter mStepperAdapter;
    public boolean mEditingMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());
        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStartingStepPosition = /*savedInstanceState != null ? savedInstanceState.getInt(CURRENT_STEP_POSITION_KEY) :*/ 0;
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_STEP_POSITION_KEY, mStepperLayout.getCurrentStepPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        final int currentStepPosition = mStepperLayout.getCurrentStepPosition();
        if (currentStepPosition > 0) {
            mStepperLayout.setCurrentStepPosition(currentStepPosition - 1);
        } else {
            finish();
        }
    }

    @Override
    public void onCompleted(View completeButton) {
       // Toast.makeText(this, "onCompleted!", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onStepSelected(int newStepPosition) {
        //Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReturn() {
        finish();
    }


}
