package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alium.mkan_report_data.models.form_models.Tajneed;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TajneedFragment extends BaseReportFragment implements Step {

    @BindView(R.id.total_number_of_khuddam)
    VerifiableEditText totalNumberOfKhuddam;
    @BindView(R.id.number_of_khuddam_at_fourty_years_of_age_by_dec)
    VerifiableEditText numberOfKhuddamAtFourtyYearsOfAgeByDec;
    @BindView(R.id.total_number_of_khuddam_with_uniform)
    VerifiableEditText totalNumberOfKhuddamWithUniform;
    @BindView(R.id.total_number_of_atfal)
    VerifiableEditText totalNumberOfAtfal;
    @BindView(R.id.nazim_tajnid_phone_number)
    VerifiableEditText nazimTajnidPhoneNumber;

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
//        if (mForm.isValid()) {
//            Tajneed tajneed = new Tajneed();
//            tajneed.setTotalNumberNoOfKhuddam(Integer.parseInt(totalNumberOfKhuddam.getText().toString()));
//            tajneed.setTotalNumberOfKhuddamWithUniform(Integer.parseInt(totalNumberOfKhuddamWithUniform.getText().toString()));
//            tajneed.setTotalNumberOfAtfal(Integer.parseInt(totalNumberOfAtfal.getText().toString()));
//            tajneed.setTotalNumberOfKhuddamAtAge40ByDec(Integer.parseInt(numberOfKhuddamAtFourtyYearsOfAgeByDec.getText().toString()));
//            tajneed.setNazimTajnidPhoneNumber(nazimTajnidPhoneNumber.getText().toString());
//            mListener.getSharedMKanReport().setTajneedData(tajneed);
//            return null;
//        } else {
//            return new VerificationError("Please fill all fields");
//        }
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
