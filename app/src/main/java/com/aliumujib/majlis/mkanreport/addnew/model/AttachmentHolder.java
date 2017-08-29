package com.aliumujib.majlis.mkanreport.addnew.model;

import com.alium.mkan_report_data.models.Attachment;

import java.util.List;

/**
 * Created by abdulmujibaliu on 8/29/17.
 * <p>
 * Holds attachments and the request code so observers know who gets what
 */

public class AttachmentHolder {

    List<Attachment> mAttachmentList;
    int mRequestCode;


    public AttachmentHolder(List<Attachment> mAttachmentList, int mRequestCode) {
        this.mAttachmentList = mAttachmentList;
        this.mRequestCode = mRequestCode;
    }


    public List<Attachment> getmAttachmentList() {
        return mAttachmentList;
    }

    public int getmRequestCode() {
        return mRequestCode;
    }
}
