package com.aliumujib.majlis.mkanreport.addnew.presenter;

import com.aliumujib.majlis.mkanreport.addnew.interfaces.EditReportMVPContracts;

/**
 * Created by abdulmujibaliu on 8/11/17.
 */

public class EditReportPresenter implements EditReportMVPContracts.IEditReportPresenter {

    private EditReportMVPContracts.IEditReportView view;

    public EditReportPresenter(EditReportMVPContracts.IEditReportView view) {
        this.view = view;
    }


}
