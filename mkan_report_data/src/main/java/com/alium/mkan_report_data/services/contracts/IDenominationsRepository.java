package com.alium.mkan_report_data.services.contracts;

import com.alium.mkan_report_data.models.Dila;
import com.alium.mkan_report_data.models.Ilaqa;
import com.alium.mkan_report_data.models.Muqami;

import java.util.List;

import in.galaxyofandroid.spinerdialog.IdentifiableObject;
import io.reactivex.Observable;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IDenominationsRepository {

    Observable<List<IdentifiableObject>> getMuqamiList();

    Observable<List<IdentifiableObject>> getDilaList();

    Observable<List<IdentifiableObject>> getIlaqaList();


}
