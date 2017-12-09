package com.aliumujib.majlis.mkan_report_app.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alium.mkan_report_data.models.Attachment;
import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaqarAmalFragment extends BaseReportFragment implements Step {


    @BindView(R.id.number_of_waqar_e_amal_organized_in_month)
    VerifiableEditText numberOfWaqarEAmalOrganizedInMonth;
    @BindView(R.id.nazim_nau_waqar_e_amal_phone_number)
    VerifiableEditText nazimNauWaqarEAmalPhoneNumber;

    List<Attachment> mAttachmentList = new ArrayList<>();

    public WaqarAmalFragment() {
        // Required empty public constructor
    }


    public static WaqarAmalFragment newInstance() {
        WaqarAmalFragment fragment = new WaqarAmalFragment();
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
        View view = inflater.inflate(R.layout.fragment_waqar_amal, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
