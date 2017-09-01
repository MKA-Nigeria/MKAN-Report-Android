package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkanreport.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class SihateJismaniPart1 extends BaseReportFragment implements Step {

    public SihateJismaniPart1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SihateJismaniPart1 newInstance() {
        SihateJismaniPart1 fragment = new SihateJismaniPart1();
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
        return inflater.inflate(R.layout.fragment_sihate_jismani, container, false);
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

}
