package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.aliumujib.majlis.mkanreport.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TajneedFragment extends BaseReportFragment implements Step {

    @Bind(R.id.total_number_of_khuddam)
    EditText totalNumberOfKhuddam;
    @Bind(R.id.number_of_khuddam_at_fourty_years_of_age_by_dec)
    EditText numberOfKhuddamAtFourtyYearsOfAgeByDec;
    @Bind(R.id.total_number_of_khuddam_with_uniform)
    EditText totalNumberOfKhuddamWithUniform;
    @Bind(R.id.total_number_of_atfal)
    EditText totalNumberOfAtfal;
    @Bind(R.id.nazim_tajnid_phone_number)
    EditText nazimTajnidPhoneNumber;

    public TajneedFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TajneedFragment newInstance() {
        TajneedFragment fragment = new TajneedFragment();
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
        View view = inflater.inflate(R.layout.fragment_tajneed, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public VerificationError verifyStep() {
        if (mForm.isValid()) {
            mListener.getSharedMKanReport().setTotalNumberNoOfKhuddam(Integer.parseInt(totalNumberOfKhuddam.getText().toString()));
            mListener.getSharedMKanReport().setTotalNumberOfKhuddamWithUniform(Integer.parseInt(totalNumberOfKhuddamWithUniform.getText().toString()));
            mListener.getSharedMKanReport().setTotalNumberOfAtfal(Integer.parseInt(totalNumberOfAtfal.getText().toString()));
            mListener.getSharedMKanReport().setTotalNumberOfKhuddamAtAge40ByDec(Integer.parseInt(numberOfKhuddamAtFourtyYearsOfAgeByDec.getText().toString()));
            mListener.getSharedMKanReport().setNazimTajnidPhoneNumber(nazimTajnidPhoneNumber.getText().toString());
            return null;
        } else {
            return new  VerificationError("Please fill all fields");
        }
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
        ButterKnife.unbind(this);
    }
}
