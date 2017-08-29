package com.alium.mkan_report_data.models;

import com.alium.mkan_report_data.constants.Constants;
import com.parse.ParseObject;

import in.galaxyofandroid.spinerdialog.IdentifiableObject;

/**
 * Created by abdulmujibaliu on 8/26/17.
 */

public class Dila implements IdentifiableObject {
    String objectID, name;

    public Dila(ParseObject parseObject) {
        objectID = parseObject.getObjectId();
        name = parseObject.getString(Constants.DILA_CLASS_DILA_NAME);
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
