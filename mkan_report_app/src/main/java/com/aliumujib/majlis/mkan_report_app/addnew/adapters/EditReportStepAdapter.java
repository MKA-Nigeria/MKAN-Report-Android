package com.aliumujib.majlis.mkan_report_app.addnew.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.aliumujib.majlis.mkan_report_app.addnew.activity.AbstractStepperActivity;
import com.aliumujib.majlis.mkan_report_app.addnew.activity.BaseReportEditorActivity;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public abstract class EditReportStepAdapter extends AbstractFragmentStepAdapter {
    BaseReportEditorActivity context;

    public EditReportStepAdapter(@NonNull FragmentManager fm, @NonNull AbstractStepperActivity context) {
        super(fm, context);
        this.context = (BaseReportEditorActivity) context;
    }


}