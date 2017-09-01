package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkanreport.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class UmmomiPart1Fragment extends BaseReportFragment{

    public UmmomiPart1Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static UmmomiPart1Fragment newInstance() {
        UmmomiPart1Fragment fragment = new UmmomiPart1Fragment();
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
        return inflater.inflate(R.layout.fragment_ummomi_part1, container, false);
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

}
