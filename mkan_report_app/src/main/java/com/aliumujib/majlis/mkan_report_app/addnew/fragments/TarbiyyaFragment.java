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

public class TarbiyyaFragment extends BaseReportFragment implements Step {

    @BindView(R.id.number_of_tarbiyya_programmes)
    VerifiableEditText numberOfTarbiyyaProgrammes;
    @BindView(R.id.nazim_tarbiyya_phone_number)
    VerifiableEditText nazimTarbiyyaPhoneNumber;
    @BindView(R.id.number_of_khuddam_who_observe_congregation_prayers)
    VerifiableEditText numberOfKhuddamWhoObserveCongregationPrayers;
    @BindView(R.id.number_of_khuddam_who_write_to_huzur)
    VerifiableEditText numberOfKhuddamWhoWriteToHuzur;
    @BindView(R.id.number_of_khuddam_who_listen_to_sermon)
    VerifiableEditText numberOfKhuddamWhoListenToSermon;
    @BindView(R.id.number_of_khuddam_who_watch_mta_regularly)
    VerifiableEditText numberOfKhuddamWhoWatchMtaRegularly;
    @BindView(R.id.number_of_khuddam_regular_in_tahjudd)
    VerifiableEditText numberOfKhuddamRegularInTahjudd;
    @BindView(R.id.number_of_khuddam_regulat_in_daily_salat)
    VerifiableEditText numberOfKhuddamRegulatInDailySalat;
    @BindView(R.id.number_of_khuddam_in_voluntary_fast)
    VerifiableEditText numberOfKhuddamInVoluntaryFast;
    @BindView(R.id.number_of_khuddam_who_read_conditions_of_biat)
    VerifiableEditText numberOfKhuddamWhoReadConditionsOfBiat;

    public TarbiyyaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TarbiyyaFragment newInstance() {
        TarbiyyaFragment fragment = new TarbiyyaFragment();
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
        View view = inflater.inflate(R.layout.fragment_tarbiyya, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public VerificationError verifyStep() {
//        if(mForm.isValid()){
//            Tarbiyya tarbiyya = new Tarbiyya();
//            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));
//            tarbiyya.setNumberOfKhuddamThatObserveCongregationPrayer(editTextContentToInt(numberOfKhuddamWhoObserveCongregationPrayers));
//            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));
//            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));
//
//            //TODO COLLECT ALL FIELDS
//            mListener.getSharedMKanReport().setTarbiyyaData(tarbiyya);
//            return null;
//        } else {
//            return new  VerificationError("Please fill all fields");
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
