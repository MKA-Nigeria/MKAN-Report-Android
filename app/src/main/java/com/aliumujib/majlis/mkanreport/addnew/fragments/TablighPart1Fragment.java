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


public class TablighPart1Fragment extends BaseReportFragment implements Step {


    @Bind(R.id.number_of_media_cassete_distributed)
    EditText numberOfMediaCasseteDistributed;
    @Bind(R.id.number_of_question_and_answe_sessions_conducted)
    EditText numberOfQuestionAndAnsweSessionsConducted;
    @Bind(R.id.number_of_public_lecture_held)
    EditText numberOfPublicLectureHeld;
    @Bind(R.id.number_of_house_to_house_preaching_events_held)
    EditText numberOfHouseToHousePreachingEventsHeld;
    @Bind(R.id.number_of_literature_books_distributed)
    EditText numberOfLiteratureBooksDistributed;
    @Bind(R.id.number_of_tabligh_meetings_held)
    EditText numberOfTablighMeetingsHeld;
    @Bind(R.id.number_of_letters_on_tabligh_in_the_month)
    EditText numberOfLettersOnTablighInTheMonth;
    @Bind(R.id.number_of_bookstalls_maintained)
    EditText numberOfBookstallsMaintained;
    @Bind(R.id.number_of_tabligh_sms_and_emails_sent)
    EditText numberOfTablighSmsAndEmailsSent;
    @Bind(R.id.number_of_biats_signed_in_month)
    EditText numberOfBiatsSignedInMonth;

    public TablighPart1Fragment() {
        // Required empty public constructor
    }


    public static TablighPart1Fragment newInstance() {
        TablighPart1Fragment fragment = new TablighPart1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_tabligh_part1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public VerificationError verifyStep() {
        if (mForm.isValid()) {
            mListener.getSharedMKanReport().setNumberOfMediaCassettesDistributedInMonth(Integer.parseInt(numberOfMediaCasseteDistributed.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfQuestionsAndAnswerSessionsHeldInMonth(Integer.parseInt(numberOfQuestionAndAnsweSessionsConducted.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfPublicLecturesConductedInMonth(Integer.parseInt(numberOfPublicLectureHeld.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfHouseToHousePreachingEventsHeldInMonth(Integer.parseInt(numberOfHouseToHousePreachingEventsHeld.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfLiteratureBooksDistributedInMonth(Integer.parseInt(numberOfLiteratureBooksDistributed.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTablighMeetingsHeldInMonth(Integer.parseInt(numberOfTablighMeetingsHeld.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfLettersOnTablighSentInTheMonth(Integer.parseInt(numberOfLettersOnTablighInTheMonth.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfBooksStallsMaintained(Integer.parseInt(numberOfBookstallsMaintained.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfTablighSMSandEMailSentInMonth(Integer.parseInt(numberOfTablighSmsAndEmailsSent.getText().toString()));
            mListener.getSharedMKanReport().setNumberOfBiatsSignedInMonth(Integer.parseInt(numberOfBiatsSignedInMonth.getText().toString()));
            return null;

        } else {
            return new VerificationError("Please input all fields");
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
