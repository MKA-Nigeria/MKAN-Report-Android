package com.alium.mkan_report_data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.alium.mkan_report_data.constants.Constants;
import com.parse.ParseUser;

import in.galaxyofandroid.spinerdialog.IdentifiableObject;

/**
 * Created by Abdul-Mujeeb Aliu on 2/3/2016.
 */
public class Profile implements Parcelable {
    // The fields associated to the person
    private String mUserName, mEmail, mImageURL, mFullName, mOUserObjID, mUserPassword;
    private IdentifiableObject mDila, mIlaqa, mMuqami;

    public Profile(String mUserName, String mUserPassword) {
        this.mUserName = mUserName;
        this.mUserPassword = mUserPassword;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public String getmOUserObjID() {
        return mOUserObjID;
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }

    public IdentifiableObject getmDila() {
        return mDila;
    }

    public void setmDila(IdentifiableObject mDila) {
        this.mDila = mDila;
    }

    public IdentifiableObject getmIlaqa() {
        return mIlaqa;
    }

    public void setmIlaqa(IdentifiableObject mIlaqa) {
        this.mIlaqa = mIlaqa;
    }

    public IdentifiableObject getmMuqami() {
        return mMuqami;
    }

    public void setmMuqami(IdentifiableObject mMuqami) {
        this.mMuqami = mMuqami;
    }

    public static Creator<Profile> getCREATOR() {
        return CREATOR;
    }

    public Profile(ParseUser user) {
        mUserName = user.getUsername();

        mOUserObjID = user.getObjectId();

        mFullName =  user.getString(Constants.USER_FULL_NAME) != null
                ? user.getString(Constants.USER_FULL_NAME) : "N/A";

        mEmail = user.getEmail() != null
                ? user.getEmail() : "N/A";

        mImageURL = user.getParseFile(Constants.USER_CLASS_PROFILE_PIC) != null
                ? (user.getParseFile(Constants.USER_CLASS_PROFILE_PIC).getUrl()) : "N/A";
    }

    protected Profile(Parcel in) {
        mUserName = in.readString();
        mEmail = in.readString();
        mImageURL = in.readString();
        mFullName = in.readString();
        mOUserObjID = in.readString();
        mUserPassword = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object != null && object instanceof Profile) {
            isEqual = (this.mOUserObjID.equals(((Profile) object).getmObjID()));
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getmObjID() {
        return mOUserObjID;
    }

    public void setmObjID(String mObjID) {
        this.mOUserObjID = mObjID;
    }



    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public void setmOUserObjID(String mOUserObjID) {
        this.mOUserObjID = mOUserObjID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mUserName);
        dest.writeString(mEmail);
        dest.writeString(mImageURL);
        dest.writeString(mFullName);
        dest.writeString(mOUserObjID);
        dest.writeString(mUserPassword);
    }

    public static enum Field {
        USERNAME, DILA_NAME, EMAIL, ILAQA_NAME, MUQAMI_NAME, IMAGE_URL, SHORT_DESCRIPTION, FULL_NAME, OBJ_ID, PASSWORD
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }


    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }



    public Profile() {
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String get(Field f) {
        switch (f) {

            case EMAIL:
                return mEmail;
            case IMAGE_URL:
                return mImageURL;
            case USERNAME:
                return mUserName;
            case FULL_NAME:
                return mFullName;
            case OBJ_ID:
                return mOUserObjID;
            case PASSWORD:
                return mUserPassword;
            default:
                return "N/A";
        }
    }

}
