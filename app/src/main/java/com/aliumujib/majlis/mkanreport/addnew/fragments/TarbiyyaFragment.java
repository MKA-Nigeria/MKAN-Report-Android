package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alium.mkan_report_data.models.form_models.Tarbiyya;
import com.aliumujib.majlis.mkanreport.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TarbiyyaFragment extends BaseReportFragment implements Step {


    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.number_of_tarbiyya_programmes)
    EditText numberOfTarbiyyaProgrammes;
    @Bind(R.id.nazim_tarbiyya_phone_number)
    EditText nazimTarbiyyaPhoneNumber;
    @Bind(R.id.number_of_khuddam_who_observe_congregation_prayers)
    EditText numberOfKhuddamWhoObserveCongregationPrayers;
    @Bind(R.id.number_of_khuddam_who_write_to_huzur)
    EditText numberOfKhuddamWhoWriteToHuzur;
    @Bind(R.id.number_of_khuddam_who_listen_to_sermon)
    EditText numberOfKhuddamWhoListenToSermon;
    @Bind(R.id.number_of_khuddam_who_watch_mta_regularly)
    EditText numberOfKhuddamWhoWatchMtaRegularly;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.number_of_khuddam_regular_in_tahjudd)
    EditText numberOfKhuddamRegularInTahjudd;
    @Bind(R.id.number_of_khuddam_regulat_in_daily_salat)
    EditText numberOfKhuddamRegulatInDailySalat;
    @Bind(R.id.number_of_khuddam_in_voluntary_fast)
    EditText numberOfKhuddamInVoluntaryFast;
    @Bind(R.id.number_of_khuddam_who_read_conditions_of_biat)
    EditText numberOfKhuddamWhoReadConditionsOfBiat;

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
        if(mForm.isValid()){
            Tarbiyya tarbiyya = new Tarbiyya();
            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));
            tarbiyya.setNumberOfKhuddamThatObserveCongregationPrayer(editTextContentToInt(numberOfKhuddamWhoObserveCongregationPrayers));
            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));
            tarbiyya.setNumberOfTarbiyyaProgrammesConductedInMonth(editTextContentToInt(numberOfTarbiyyaProgrammes));

            //TODO COLLECT ALL FIELDS
            mListener.getSharedMKanReport().setTarbiyyaData(tarbiyya);
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
