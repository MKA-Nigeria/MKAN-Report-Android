package com.alium.mkan_report_data.services;

import com.alium.mkan_report_data.constants.Constants;
import com.alium.mkan_report_data.models.MKANReport;
import com.alium.mkan_report_data.services.contracts.IReportRepository;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import io.reactivex.subjects.ReplaySubject;

/**
 * Created by abdulmujibaliu on 2/26/17.
 */

public class ReportRepository implements IReportRepository {

    private ReplaySubject<MKANReport> mkanReportSavingSubject = ReplaySubject.create();

    public static ReportRepository sharedReportRepository = new ReportRepository();

    public ReportRepository() {

    }

    @Override
    public void saveReport(final MKANReport mkanReport) {
        final ParseObject parseObject = new ParseObject(Constants.MKAN_REPORT_CLASS_NAME);
        //BAD IDEA
        parseObject.put(Constants.MKAN_REPORT_CLASS_ETEEMAD_EXECUTIVE_MEETINGS_CONDUCTED_COUNT, mkanReport.getNumberOfExecutiveMeetings());
        parseObject.put(Constants.MKAN_REPORT_CLASS_ETEEMAD_EXECUTIVE_MEETINGS_ATEENDEE_COUNT, mkanReport.getNumberOfAttendeesAtExecutiveMeeting());
        parseObject.put(Constants.MKAN_REPORT_CLASS_ETEEMAD_QAIDAT_MULK_MEMBER_COUNT, mkanReport.getNumberOfMulkMembersinQaidat());
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    MKANReport mkanReport1 = new MKANReport(parseObject);
                    mkanReportSavingSubject.onNext(mkanReport1);
                }else {
                    e.printStackTrace();
                    mkanReportSavingSubject.onError(e);
                }
            }
        });
    }



    @Override
    public ReplaySubject<MKANReport> getSaveReportObservable() {
        return mkanReportSavingSubject;
    }
}
