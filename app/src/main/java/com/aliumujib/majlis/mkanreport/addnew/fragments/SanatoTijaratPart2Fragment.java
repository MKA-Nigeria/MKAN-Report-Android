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

public class SanatoTijaratPart2Fragment extends BaseReportFragment {

   // private OnFragmentInteractionListener mListener;

    public SanatoTijaratPart2Fragment() {
        // Required empty public constructor
    }

    public static SanatoTijaratPart2Fragment newInstance() {
        SanatoTijaratPart2Fragment fragment = new SanatoTijaratPart2Fragment();
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
        return inflater.inflate(R.layout.fragment_sanato_tijarat_part2, container, false);
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

}
