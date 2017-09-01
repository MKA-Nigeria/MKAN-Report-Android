package com.alium.mkan_report_data.models;

import android.net.Uri;

import com.alium.mkan_report_data.constants.Constants;

import java.net.URI;

/**
 * Created by abdulmujibaliu on 8/21/17.
 */


public class Attachment {

    public enum AttachmentType {
        PDF(1), EXCEL(2), WORD(3), PHOTO(4), VIDEO(5), FILE(6), INVALID(0);

        private final int value;

        AttachmentType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public Attachment() {

    }

    private AttachmentType mAttachmentType;
    private Uri mFileURI;
    private String mFileName = "NO NAME";

    public String getmFileName() {
        if (!mFileURI.getPath().matches("")) {
            String[] strings = mFileURI.getPath().split("/");
            if (strings.length > 0) {
                mFileName = strings[strings.length - 1];
            }
        }
        return mFileName;
    }

    public Uri getmFileURI() {
        return mFileURI;
    }

    public void setmFileURI(Uri mFileURI) {
        this.mFileURI = mFileURI;
    }

    public AttachmentType getmAttachmentType() {
        return mAttachmentType;
    }

    public void setmAttachmentType(AttachmentType mAttachmentType) {
        this.mAttachmentType = mAttachmentType;
    }

    public Attachment(AttachmentType mAttachmentType, Uri mFileURI) {
        this.mAttachmentType = mAttachmentType;
        this.mFileURI = mFileURI;
    }
}
