package com.aliumujib.majlis.mkanreport.utils.views.attachmentpickerview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya.filebrowser.Constants;
import com.aditya.filebrowser.FileChooser;
import com.alium.mkan_report_data.models.Attachment;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.addnew.interfaces.EditReportActivityInteractor;
import com.aliumujib.majlis.mkanreport.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import xyz.cybersapien.recyclerele.RecyclerELEAdapter;

import static com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout.TAG;


/**
 * Created by abdulmujibaliu on 8/31/17.
 */

public class AttachmentPickerView extends LinearLayout {

    private final View mView;
    private final TextView mAttachmentPickerTitleView, mAttachmentPickerButtonView;
    private RecyclerView mAttachmentsRV;
    public static int INVALID_REQUEST_CODE_NUMBER = -2;


    protected AttachmentsGridRecyclerAdapter mAttachmentsAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerELEAdapter mRecyclerELEAdapter;
    protected List<Attachment> mDataSource = new ArrayList<>();

    public AttachmentPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.AttachmentPickerView, 0, 0);
        String titleText = a.getString(R.styleable.AttachmentPickerView_picker_view_title);
        String buttonText = a.getString(R.styleable.AttachmentPickerView_picker_button_text);
        int requestCode = a.getInt(R.styleable.AttachmentPickerView_request_code, INVALID_REQUEST_CODE_NUMBER);


        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mView = inflater.inflate(R.layout.attachments_view_layout, this, true);

        mAttachmentPickerTitleView = (TextView) mView.findViewById(R.id.attachment_title);
        mAttachmentPickerButtonView = (TextView) mView.findViewById(R.id.add_attachments_button);
        mAttachmentsRV = (RecyclerView) mView.findViewById(R.id.attachments_rv);

        initAttachmentRV(mAttachmentsRV, mDataSource);

        if (requestCode == INVALID_REQUEST_CODE_NUMBER) {
            throw new IllegalStateException("Please be a sport and supply a request code");
        }

        if (titleText != null && !titleText.matches(""))
            mAttachmentPickerTitleView.setText(titleText);

        if (buttonText != null && !buttonText.matches(""))
            mAttachmentPickerButtonView.setText(buttonText);

        mAttachmentPickerButtonView.setOnClickListener(v -> pickAttachments(requestCode));

        if (getActivity() instanceof EditReportActivityInteractor) {
            EditReportActivityInteractor mListener = (EditReportActivityInteractor) getActivity();
            mListener.getAttachmentHolderObservable().subscribe(attachmentHolder -> {
                Log.d(TAG, "RECIEVED SOME ITEMS: " + attachmentHolder.getmAttachmentList().size() + " for code " + attachmentHolder.getmRequestCode());
                if (attachmentHolder.getmRequestCode() == requestCode) {
                    mDataSource.addAll(attachmentHolder.getmAttachmentList());
                    mRecyclerELEAdapter.setCurrentView(RecyclerELEAdapter.VIEW_NORMAL);
                    mRecyclerELEAdapter.notifyDataSetChanged();
                }
            }, Throwable::printStackTrace);
        } else {
            ToastUtils.shortToast("OMO YAWA DEY FOR HERE O: CHECK ATTACHMENT PICKER VIEW");
        }

    }


    public Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    protected void pickAttachments(int reqestCode) {
        Intent i2 = new Intent(getActivity(), FileChooser.class);
        i2.putExtra(Constants.SELECTION_MODE, Constants.SELECTION_MODES.MULTIPLE_SELECTION.ordinal());
        getActivity().startActivityForResult(i2, reqestCode);
    }

    public RecyclerELEAdapter wrapInELEAdapter(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        View loadingViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.loading_layout, recyclerView, false);
        View emptyViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.empty_layout, recyclerView, false);
        View errorViewDrugs = getActivity().getLayoutInflater().inflate(R.layout.error_layout, recyclerView, false);
        return new RecyclerELEAdapter(adapter, emptyViewDrugs, loadingViewDrugs, errorViewDrugs);
    }

    protected void initAttachmentRV(RecyclerView recyclerView, List<Attachment> dataSource) {
        mLayoutManager = new GridLayoutManager(getContext(), 3); //Kind of opimal for all screen sizes
        recyclerView.setLayoutManager(mLayoutManager);
        mAttachmentsAdapter = new AttachmentsGridRecyclerAdapter(dataSource, getContext());
        mRecyclerELEAdapter = wrapInELEAdapter(mAttachmentsAdapter, recyclerView);
        recyclerView.setAdapter(mRecyclerELEAdapter);
        mRecyclerELEAdapter.setCurrentView(RecyclerELEAdapter.VIEW_EMPTY);
    }

}
