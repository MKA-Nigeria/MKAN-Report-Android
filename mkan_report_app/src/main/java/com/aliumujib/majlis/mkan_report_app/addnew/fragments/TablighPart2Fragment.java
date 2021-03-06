package com.aliumujib.majlis.mkan_report_app.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TablighPart2Fragment extends BaseReportFragment implements Step {


    @BindView(R.id.number_of_tabligh_programmes_held)
    VerifiableEditText numberOfTablighProgrammesHeld;
    @BindView(R.id.total_number_of_khuddam_participating_in_tabligh_activities)
    VerifiableEditText totalNumberOfKhuddamParticipatingInTablighActivities;
    @BindView(R.id.duration_of_tabligh_programmes_held)
    VerifiableEditText durationOfTablighProgrammesHeld;
    @BindView(R.id.total_number_of_tabligh_classes_held_in_month)
    VerifiableEditText totalNumberOfTablighClassesHeldInMonth;
    @BindView(R.id.nazim_tabligh_phone_number)
    VerifiableEditText nazimTablighPhoneNumber;

    public TablighPart2Fragment() {
        // Required empty public constructor
    }

    public static TablighPart2Fragment newInstance() {
        TablighPart2Fragment fragment = new TablighPart2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_tabligh_part2, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public VerificationError verifyStep() {
//        if(mForm.isValid()){
//            //TODO APPEND THEM FIELDS
//
//        }else {
//            return new VerificationError("Please input all fields");
//        }
//        return null;
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
