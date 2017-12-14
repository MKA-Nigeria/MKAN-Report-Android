package com.aliumujib.majlis.mkan_report_app.addnew.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aditya.filebrowser.Constants;
import com.alium.mkan_report_data.models.Attachment;
import com.alium.mkan_report_data.services.ReportRepository;
import com.aliumujib.majlis.mkan_report_app.addnew.adapters.ReportEditorStepAdapter;
import com.aliumujib.majlis.mkan_report_app.addnew.interfaces.EditReportActivityInteractor;
import com.aliumujib.majlis.mkan_report_app.addnew.interfaces.EditReportMVPContracts;
import com.alium.mkan_report_data.models.MKANReport;
import com.aliumujib.majlis.mkan_report_app.addnew.model.AttachmentHolder;
import com.aliumujib.majlis.mkan_report_app.addnew.presenter.EditReportPresenter;
import com.aliumujib.mkanapps.coremodule.utils.UtilConstants;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;

public class EditReportActivity extends BaseReportEditorActivity implements EditReportActivityInteractor,
        EditReportMVPContracts.IEditReportView {

    EditReportMVPContracts.IEditReportPresenter mEditReportPresenter;
    public MKANReport mSharedMkanReport = new MKANReport();
    private ReplaySubject<AttachmentHolder> mSharedAttachmentHolderReplaySubject = ReplaySubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStepperAdapter = new ReportEditorStepAdapter(getSupportFragmentManager(), this);
        mStepperLayout.setAdapter(mStepperAdapter, 0);
        mStepperLayout.setListener(this);
        mStepperAdapter.notifyDataSetChanged();

        mEditReportPresenter = new EditReportPresenter(this);

        ReportRepository.sharedReportRepository.getSaveReportObservable().subscribe(mkanReport -> {
            cancelNetWorkOpNotifcation(50);
        }, Throwable::printStackTrace);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) { //
            if (resultCode == RESULT_OK) {
                ArrayList<Uri> selectedFiles = data.getParcelableArrayListExtra(Constants.SELECTED_ITEMS);
                List<Attachment> attachmentArrayList = new ArrayList<>();
                for (Uri uri : selectedFiles) {
                    Attachment attachment = new Attachment();
                    attachment.setmFileURI(uri);
                    attachment.setmAttachmentType(getFileTypeEnumBasedOnExtension(uri));
                    attachmentArrayList.add(attachment);
                }

                AttachmentHolder attachmentHolder = new AttachmentHolder(attachmentArrayList, requestCode);
                mSharedAttachmentHolderReplaySubject.onNext(attachmentHolder);
                Log.d(TAG, "SENT SOME ITEMS: " + selectedFiles.size());
            }
        }

    }

    public Attachment.AttachmentType getFileTypeEnumBasedOnExtension(Uri uri) {
        if (uri.getPath().endsWith(UtilConstants.JPG_FILE_EXTENTION) || uri.getPath().endsWith(UtilConstants.PNG_FILE_EXTENTION)) {
            return Attachment.AttachmentType.PHOTO;
        } else if (uri.getPath().endsWith(UtilConstants.PDF_FILE_EXTENTION)) {
            return Attachment.AttachmentType.PDF;
        } else if (uri.getPath().endsWith(UtilConstants.M4V_FILE_EXTENTION) || uri.getPath().endsWith(UtilConstants.MP4_FILE_EXTENTION) || uri.getPath().endsWith(UtilConstants.MP3_FILE_EXTENTION)) {
            return Attachment.AttachmentType.VIDEO;
        } else if (uri.getPath().endsWith(UtilConstants.EXCEL_FILE_EXTENTION)) {
            return Attachment.AttachmentType.EXCEL;
        } else if (uri.getPath().endsWith(UtilConstants.WORD_2_FILE_EXTENTION) || uri.getPath().endsWith(UtilConstants.WORD_FILE_EXTENTION)) {
            return Attachment.AttachmentType.WORD;
        } else {
            return Attachment.AttachmentType.FILE;
        }
    }


    @Override
    public void onCompleted(View completeButton) {
        super.onCompleted(completeButton);
        ReportRepository.sharedReportRepository.saveReport(mSharedMkanReport);
        showUploadNotification("Saving Report", 50);
        finish();
    }

    @Override
    protected void init() {
        String username, email, phoneNumber = "N/A";

    }


    @Override
    protected void populateWithExitingData(ParseUser ownerObj, ParseObject userExtParseObject) {

    }


    public static void start(Context context) {
        Intent intent = new Intent(context, EditReportActivity.class);
        context.startActivity(intent);
    }


    @Override
    public EditReportMVPContracts.IEditReportPresenter getPresenter() {
        return mEditReportPresenter;
    }

    @Override
    public MKANReport getSharedMKanReport() {
        return mSharedMkanReport;
    }

    @Override
    public Observable<AttachmentHolder> getAttachmentHolderObservable() {
        return mSharedAttachmentHolderReplaySubject;
    }

    @Override
    public void showData() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showEmpty() {

    }
}
