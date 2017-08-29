package com.aliumujib.majlis.mkanreport.addnew.interfaces;

import com.alium.mkan_report_data.models.MKANReport;
import com.aliumujib.majlis.mkanreport.addnew.model.AttachmentHolder;

import io.reactivex.Observable;

/**
 * Created by abdulmujibaliu on 7/5/17.
 */

public interface EditReportActivityInteractor {

    EditReportMVPContracts.IEditReportPresenter getPresenter();

    MKANReport getSharedMKanReport();

    Observable<AttachmentHolder> getAttachmentHolderObservable();

}
