package com.aliumujib.majlis.mkanreport.addnew.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.aditya.filebrowser.Constants;
import com.aditya.filebrowser.FileChooser;
import com.alium.mkan_report_data.models.Attachment;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.addnew.adapters.AttachmentsGridRecyclerAdapter;
import com.aliumujib.majlis.mkanreport.addnew.interfaces.EditReportActivityInteractor;
import com.aliumujib.majlis.mkanreport.utils.inputvalidator.Form;
import com.aliumujib.majlis.mkanreport.utils.views.VerifiableEditText;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

import xyz.cybersapien.recyclerele.RecyclerELEAdapter;

/**
 * Created by abdulmujibaliu on 8/11/17.
 */

public abstract class BaseReportFragment extends Fragment implements Step {

    protected EditReportActivityInteractor mListener;
    protected Form mForm;
    protected AttachmentsGridRecyclerAdapter mAttachmentsAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerELEAdapter mRecyclerELEAdapter;


    @Override
    public void onError(@NonNull VerificationError error) {

    }

    public RecyclerELEAdapter wrapInELEAdapter(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        View loadingViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.loading_layout, recyclerView, false);
        View emptyViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.empty_layout, recyclerView, false);
        View errorViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.error_layout, recyclerView, false);
        return new RecyclerELEAdapter(adapter, emptyViewDrugs, loadingViewDrugs, errorViewDrugs);
    }

    protected void pickAttachments(int reqestCode) {
        Intent i2 = new Intent(getActivity(), FileChooser.class);
        i2.putExtra(Constants.SELECTION_MODE, Constants.SELECTION_MODES.MULTIPLE_SELECTION.ordinal());
        getActivity().startActivityForResult(i2, reqestCode);
    }

    protected void initAttachmentRV(RecyclerView recyclerView, List<Attachment> dataSource){
        mLayoutManager = new GridLayoutManager(getContext(), 3); //Kind of opimal for all screen sizes
        recyclerView.setLayoutManager(mLayoutManager);
        mAttachmentsAdapter = new AttachmentsGridRecyclerAdapter(dataSource, getContext());
        mRecyclerELEAdapter = wrapInELEAdapter(mAttachmentsAdapter, recyclerView);
        recyclerView.setAdapter(mRecyclerELEAdapter);
        mRecyclerELEAdapter.setCurrentView(RecyclerELEAdapter.VIEW_EMPTY);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mAttachmentsAdapter!=null){
            if(mAttachmentsAdapter.getItemCount()!=0){
                mRecyclerELEAdapter.setCurrentView(RecyclerELEAdapter.VIEW_NORMAL);
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mForm = new Form.Builder(getContext(), view)
                .showErrors(true)
                .build();

    }


    //AT SOME POINT YOU GET TIRED OF TYPYING Integer.parseInt(blablablaeditText.getText().toString());

    public int editTextContentToInt(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }


    public int editTextContentToInt(VerifiableEditText editText){
        return Integer.parseInt(editText.getText().toString());
    }

    public int getAttachmentsRequestCode(){
        return 0;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EditReportActivityInteractor) {
            mListener = (EditReportActivityInteractor) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement EditReportActivityInteractor");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
