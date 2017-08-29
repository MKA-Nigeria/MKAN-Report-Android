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

public class TarbiyyatNouMubayeen extends BaseReportFragment implements Step {


    @Bind(R.id.number_of_nau_mubayeen_khuddam_participating_in_tarbiyya_class_in_month)
    EditText numberOfNauMubayeenKhuddamParticipatingInTarbiyyaClassInMonth;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_participating_tarbiyya_camp_in_month)
    EditText numberOfNauMubayeenKhuddamParticipatingTarbiyyaCampInMonth;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_who_listened_to_live_huzur_sermon_in_month)
    EditText numberOfNauMubayeenKhuddamWhoListenedToLiveHuzurSermonInMonth;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_who_wrote_to_huzur_in_month)
    EditText numberOfNauMubayeenKhuddamWhoWroteToHuzurInMonth;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_who_observe_five_daily_prayers)
    EditText numberOfNauMubayeenKhuddamWhoObserveFiveDailyPrayers;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_who_recite_holy_quran)
    EditText numberOfNauMubayeenKhuddamWhoReciteHolyQuran;
    @Bind(R.id.number_of_nau_mubayeen_khuddam_daiee_illallah_in_month)
    EditText numberOfNauMubayeenKhuddamDaieeIllallahInMonth;
    @Bind(R.id.nazim_nau_mubaiyeen_phone_number)
    EditText nazimNauMubaiyeenPhoneNumber;

    public TarbiyyatNouMubayeen() {
        // Required empty public constructor
    }

    public static TarbiyyatNouMubayeen newInstance() {
        TarbiyyatNouMubayeen fragment = new TarbiyyatNouMubayeen();
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
        View view = inflater.inflate(R.layout.fragment_tarbiyyat_nou_mubayeen, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public VerificationError verifyStep() {
        if(mForm.isValid()){
            mListener.getSharedMKanReport().setNumberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth(Integer.parseInt(numberOfNauMubayeenKhuddamParticipatingInTarbiyyaClassInMonth.getText().toString()));
            mListener.getSharedMKanReport()
                    .setNumberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth(Integer.parseInt(numberOfNauMubayeenKhuddamParticipatingTarbiyyaCampInMonth.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon(Integer.parseInt(numberOfNauMubayeenKhuddamWhoListenedToLiveHuzurSermonInMonth.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTarviyyatiMubayeenKhaddamWhoWroteHuzoorInMonth(Integer.parseInt(numberOfNauMubayeenKhuddamWhoWroteToHuzurInMonth.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTarviyyatiMubayeenKhaddamWhoObserveSalat(Integer.parseInt(numberOfNauMubayeenKhuddamWhoObserveFiveDailyPrayers.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTarviyyatiMubayeenKhaddamWhoReciteQuran(Integer.parseInt(numberOfNauMubayeenKhuddamWhoReciteHolyQuran.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah(Integer.parseInt(numberOfNauMubayeenKhuddamDaieeIllallahInMonth.getText().toString()));
            mListener.getSharedMKanReport().setNazimNauMubayeenPhoneNumber(nazimNauMubaiyeenPhoneNumber.getText().toString());

            return null;
        }else {
            return new VerificationError("Please fill fields");
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
