package com.aliumujib.majlis.mkanreport.addnew.adapters;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.aliumujib.majlis.mkanreport.addnew.activity.AbstractStepperActivity;
import com.aliumujib.majlis.mkanreport.addnew.activity.BaseReportEditorActivity;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public abstract class EditReportStepAdapter extends AbstractFragmentStepAdapter {
    BaseReportEditorActivity context;

    public EditReportStepAdapter(@NonNull FragmentManager fm, @NonNull AbstractStepperActivity context) {
        super(fm, context);
        this.context = (BaseReportEditorActivity) context;
    }


}