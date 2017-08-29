package com.alium.mkan_report_data.services.contracts;

import com.alium.mkan_report_data.models.MKANReport;

import io.reactivex.subjects.ReplaySubject;

/**
 * Created by abdulmujibaliu on 8/26/17.
 */

public interface IReportRepository {

    void saveReport(MKANReport mkanReport);

    ReplaySubject<MKANReport> getSaveReportObservable();

}
