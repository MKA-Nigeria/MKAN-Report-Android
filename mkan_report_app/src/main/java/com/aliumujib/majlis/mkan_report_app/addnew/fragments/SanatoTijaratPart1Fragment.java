package com.aliumujib.majlis.mkan_report_app.addnew.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkan_report_app.R;
import com.stepstone.stepper.VerificationError;

public class SanatoTijaratPart1Fragment extends BaseReportFragment{

    public SanatoTijaratPart1Fragment() {
        // Required empty public constructor
    }


    public static SanatoTijaratPart1Fragment newInstance() {
        SanatoTijaratPart1Fragment fragment = new SanatoTijaratPart1Fragment();
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
        return inflater.inflate(R.layout.fragment_sanato_tijarat_part1, container, false);
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

}
