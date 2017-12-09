package com.aliumujib.majlis.mkan_report_app.addnew.presenter;

import com.aliumujib.majlis.mkan_report_app.addnew.interfaces.EditReportMVPContracts;

/**
 * Created by abdulmujibaliu on 8/11/17.
 */

public class EditReportPresenter implements EditReportMVPContracts.IEditReportPresenter {

    private EditReportMVPContracts.IEditReportView view;

    public EditReportPresenter(EditReportMVPContracts.IEditReportView view) {
        this.view = view;
    }


}
