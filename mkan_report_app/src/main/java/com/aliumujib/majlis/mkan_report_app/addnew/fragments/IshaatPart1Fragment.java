package com.aliumujib.majlis.mkan_report_app.addnew.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkan_report_app.R;
import com.stepstone.stepper.VerificationError;

public class IshaatPart1Fragment extends BaseReportFragment {


    public IshaatPart1Fragment() {
        // Required empty public constructor
    }

    public static IshaatPart1Fragment newInstance() {
        IshaatPart1Fragment fragment = new IshaatPart1Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ishaat, container, false);
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

}
