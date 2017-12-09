package com.aliumujib.majlis.mkan_report_app.addnew.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EteemadFragment extends BaseReportFragment implements Step {

    @BindView(R.id.number_of_executive_meetings)
    VerifiableEditText numberOfExecutiveMeetings;
    @BindView(R.id.number_of_attendees)
    VerifiableEditText numberOfAttendees;
    @BindView(R.id.number_of_mulk_members)
    VerifiableEditText numberOfMulkMembers;
    @BindView(R.id.number_of_mulk_members_present_at_meeting)
    VerifiableEditText numberOfMulkMembersPresentAtMeeting;
    @BindView(R.id.number_of_mulk_members_absent_at_meeting)
    VerifiableEditText numberOfMulkMembersAbsentAtMeeting;
    @BindView(R.id.motammads_phone_number)
    VerifiableEditText motammadsPhoneNumber;

    public EteemadFragment() {
        // Required empty public constructor
    }


    public static EteemadFragment newInstance() {
        EteemadFragment fragment = new EteemadFragment();
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
        View view = inflater.inflate(R.layout.fragment_eteemad, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public VerificationError verifyStep() {
//        if (mForm.isValid()) {
//            Etimad etimad = new Etimad();
//            etimad.setNumberOfExecutiveMeetings(editTextContentToInt(numberOfExecutiveMeetings));
//            etimad.setNumberOfAttendeesAtExecutiveMeeting(editTextContentToInt(numberOfAttendees));
//            etimad.setNumberOfMulkMembersinQaidat(editTextContentToInt(numberOfMulkMembers));
//            etimad.setNumberPresentAtExecutiveMeetings(editTextContentToInt(numberOfMulkMembersPresentAtMeeting));
//            etimad.setNumberAbsentAtExecutiveMeeting(editTextContentToInt(numberOfMulkMembersPresentAtMeeting));
//            etimad.setMutammadPhoneNumber(motammadsPhoneNumber.getText().toString());
//            etimad.setExecutiveMeetingConducted(false);
//            etimad.setHasQaidatSecretary(false);
//            etimad.setHasSubmittedLastMonthsReport(false);
//            mListener.getSharedMKanReport().setEtimadData(etimad);
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
    public void onDestroyView() {
        super.onDestroyView();
    }
}
