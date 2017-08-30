package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alium.mkan_report_data.models.form_models.Taaleem;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TaleemFragment extends BaseReportFragment implements Step {

    @Bind(R.id.number_of_taleem_classes_conducted_for_month)
    VerifiableEditText numberOfTaleemClassesConductedForMonth;
    @Bind(R.id.total_number_of_hours_spent)
    VerifiableEditText totalNumberOfHoursSpent;
    @Bind(R.id.number_of_khuddam_in_talimul_quran_session)
    VerifiableEditText numberOfKhuddamInTalimulQuranSession;
    @Bind(R.id.number_of_khuddam_in_age_group_book_review)
    VerifiableEditText numberOfKhuddamInAgeGroupBookReview;
    @Bind(R.id.number_of_khuddam_in_ICT_training)
    VerifiableEditText numberOfKhuddamInICTTraining;
    @Bind(R.id.number_of_khuddam_in_proficiency_exams)
    VerifiableEditText numberOfKhuddamInProficiencyExams;
    @Bind(R.id.total_number_of_khuddam_participating_in_taleem_activities)
    VerifiableEditText totalNumberOfKhuddamParticipatingInTaleemActivities;
    @Bind(R.id.total_number_of_books_reviewed_in_month)
    VerifiableEditText totalNumberOfBooksReviewedInMonth;
    @Bind(R.id.nazim_taleem_phone_number)
    VerifiableEditText nazimTaleemPhoneNumber;

    public TaleemFragment() {
        // Required empty public constructor
    }

    public static TaleemFragment newInstance() {
        TaleemFragment fragment = new TaleemFragment();
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
        View view = inflater.inflate(R.layout.fragment_taleem, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public VerificationError verifyStep() {
        if (mForm.isValid()) {
            Taaleem taaleem = new Taaleem();
            taaleem.setTotalNumberOfTaleemClassesConductedInMonth(Integer.parseInt(numberOfTaleemClassesConductedForMonth.getText().toString()));
            taaleem.setTotalNoOfHoursSpentInTaaleemClasses(Integer.parseInt(totalNumberOfHoursSpent.getText().toString()));
            taaleem.setNumberOfKhuddamThatParticipatedInTalimulQuranSession(Integer.parseInt(numberOfKhuddamInTalimulQuranSession.getText().toString()));
            taaleem.setNumberOfKhuddamThatParticipatedInAgeGroupBookReview(Integer.parseInt(numberOfKhuddamInAgeGroupBookReview.getText().toString()));
            taaleem.setNumberOfKhuddamThatParticipatedInICTTraining(Integer.parseInt(numberOfKhuddamInICTTraining.getText().toString()));
            taaleem.setNumberOfKhuddamThatParticipatedInProficiencyExamsPreparation(Integer.parseInt(numberOfKhuddamInProficiencyExams.getText().toString()));
            taaleem.setNumberOfBooksReviewedInMonth(Integer.parseInt(totalNumberOfBooksReviewedInMonth.getText().toString()));
            taaleem.setNazimTaaleemPhoneNumber(nazimTaleemPhoneNumber.getText().toString());
            mListener.getSharedMKanReport().setTaaleemDaTa(taaleem);
            return null;
        } else {
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
