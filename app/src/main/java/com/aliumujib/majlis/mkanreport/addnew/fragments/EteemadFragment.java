package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alium.mkan_report_data.models.form_models.Etimad;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.ToastUtils;
import com.aliumujib.majlis.mkanreport.utils.Utils;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EteemadFragment extends BaseReportFragment implements Step {

    @Bind(R.id.number_of_executive_meetings)
    EditText numberOfExecutiveMeetings;
    @Bind(R.id.number_of_attendees)
    EditText numberOfAttendees;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.number_of_mulk_members)
    EditText numberOfMulkMembers;
    @Bind(R.id.number_of_mulk_members_present_at_meeting)
    EditText numberOfMulkMembersPresentAtMeeting;
    @Bind(R.id.number_of_mulk_members_absent_at_meeting)
    EditText numberOfMulkMembersAbsentAtMeeting;
    @Bind(R.id.motammads_phone_number)
    EditText motammadsPhoneNumber;

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
        if (mForm.isValid()) {
            Etimad etimad = new Etimad();
            etimad.setNumberOfExecutiveMeetings(editTextContentToInt(numberOfExecutiveMeetings));
            etimad.setNumberOfAttendeesAtExecutiveMeeting(editTextContentToInt(numberOfAttendees));
            etimad.setNumberOfMulkMembersinQaidat(editTextContentToInt(numberOfMulkMembers));
            etimad.setNumberPresentAtExecutiveMeetings(editTextContentToInt(numberOfMulkMembersPresentAtMeeting));
            etimad.setNumberAbsentAtExecutiveMeeting(editTextContentToInt(numberOfMulkMembersPresentAtMeeting));
            etimad.setMutammadPhoneNumber(motammadsPhoneNumber.getText().toString());
            etimad.setExecutiveMeetingConducted(false);
            etimad.setHasQaidatSecretary(false);
            etimad.setHasSubmittedLastMonthsReport(false);
            mListener.getSharedMKanReport().setEtimadData(etimad);
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
