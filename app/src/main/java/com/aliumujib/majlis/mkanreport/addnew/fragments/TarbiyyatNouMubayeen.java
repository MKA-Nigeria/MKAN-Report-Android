package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alium.mkan_report_data.models.form_models.TarbiyyatiNauMubayeen;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TarbiyyatNouMubayeen extends BaseReportFragment implements Step {


    @BindView(R.id.number_of_nau_mubayeen_khuddam_participating_in_tarbiyya_class_in_month)
    VerifiableEditText numberOfNauMubayeenKhuddamParticipatingInTarbiyyaClassInMonth;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_participating_tarbiyya_camp_in_month)
    VerifiableEditText numberOfNauMubayeenKhuddamParticipatingTarbiyyaCampInMonth;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_who_listened_to_live_huzur_sermon_in_month)
    VerifiableEditText numberOfNauMubayeenKhuddamWhoListenedToLiveHuzurSermonInMonth;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_who_wrote_to_huzur_in_month)
    VerifiableEditText numberOfNauMubayeenKhuddamWhoWroteToHuzurInMonth;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_who_observe_five_daily_prayers)
    VerifiableEditText numberOfNauMubayeenKhuddamWhoObserveFiveDailyPrayers;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_who_recite_holy_quran)
    VerifiableEditText numberOfNauMubayeenKhuddamWhoReciteHolyQuran;
    @BindView(R.id.number_of_nau_mubayeen_khuddam_daiee_illallah_in_month)
    VerifiableEditText numberOfNauMubayeenKhuddamDaieeIllallahInMonth;
    @BindView(R.id.nazim_nau_mubaiyeen_phone_number)
    VerifiableEditText nazimNauMubaiyeenPhoneNumber;

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
//        if(mForm.isValid()){
//            TarbiyyatiNauMubayeen tarbiyyatiNauMubayeen = new TarbiyyatiNauMubayeen();
//            tarbiyyatiNauMubayeen.setNumberOfKhaddamParticipatingInTarbiyaatiMubayeenClassInMonth(editTextContentToInt(numberOfNauMubayeenKhuddamParticipatingInTarbiyyaClassInMonth));
//            tarbiyyatiNauMubayeen
//                    .setNumberOfKhaddamParticipatingInPlacesWhereTarviyyatiMubayeenCampWasOrganizedInMonth(editTextContentToInt(numberOfNauMubayeenKhuddamParticipatingTarbiyyaCampInMonth));
//            tarbiyyatiNauMubayeen.setNumberOfTarviyyatiMubayeenKhaddamWhoListenedToHuzurSermon(editTextContentToInt(numberOfNauMubayeenKhuddamWhoListenedToLiveHuzurSermonInMonth));
//            tarbiyyatiNauMubayeen.setNumberOfTarviyyatiMubayeenKhaddamWhoWroteToHuzoorInMonth(editTextContentToInt(numberOfNauMubayeenKhuddamWhoWroteToHuzurInMonth));
//            tarbiyyatiNauMubayeen.setNumberOfTarviyyatiMubayeenKhaddamWhoObserveSalat(editTextContentToInt(numberOfNauMubayeenKhuddamWhoObserveFiveDailyPrayers));
//            tarbiyyatiNauMubayeen.setNumberOfTarviyyatiMubayeenKhaddamWhoReciteQuran(editTextContentToInt(numberOfNauMubayeenKhuddamWhoReciteHolyQuran));
//            tarbiyyatiNauMubayeen.setNumberOfTarviyyatiMubayeenKhaddamWhoBecameDaillalah(editTextContentToInt(numberOfNauMubayeenKhuddamDaieeIllallahInMonth));
//            tarbiyyatiNauMubayeen.setNazimNauMubayeenPhoneNumber(nazimNauMubaiyeenPhoneNumber.getText().toString());
//            mListener.getSharedMKanReport().setTarbiyyatiNauMubayeenData(tarbiyyatiNauMubayeen);
//            return null;
//        }else {
//            return new VerificationError("Please fill fields");
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
