package com.alium.mkan_report_data.models;

import com.alium.mkan_report_data.constants.Constants;
import com.parse.ParseObject;

import in.galaxyofandroid.spinerdialog.IdentifiableObject;

/**
 * Created by abdulmujibaliu on 8/26/17.
 */

public class Ilaqa implements IdentifiableObject {

    String objectID, name;

    public Ilaqa(ParseObject parseObject) {
        objectID = parseObject.getObjectId();
        name = parseObject.getString(Constants.ILAQA_CLASS_ILAQA_NAME);
    }

    @Override
    public String getSubtitle() {
        return objectID;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public int getIdentifier() {
        return 0;
    }

    @Override
    public int getRecourseId() {
        return 0;
    }

}
