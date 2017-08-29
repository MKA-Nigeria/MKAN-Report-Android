package com.alium.mkan_report_data.services;

import android.util.Log;

import com.alium.mkan_report_data.constants.Constants;
import com.alium.mkan_report_data.models.Dila;
import com.alium.mkan_report_data.models.Ilaqa;
import com.alium.mkan_report_data.models.Muqami;
import com.alium.mkan_report_data.services.contracts.IDenominationsRepository;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.IdentifiableObject;
import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by abdulmujibaliu on 8/26/17.
 */

public class DemoninationsRepository implements IDenominationsRepository {

    public String TAG = getClass().getSimpleName();

    public static IDenominationsRepository sharedDenominationRepoInstance = new DemoninationsRepository();

    private ReplaySubject<List<IdentifiableObject>> muqamiListReplaySubject = ReplaySubject.create();

    private ReplaySubject<List<IdentifiableObject>> ilaqaListReplaySubject = ReplaySubject.create();

    private ReplaySubject<List<IdentifiableObject>> dilaListReplaySubject = ReplaySubject.create();


    public DemoninationsRepository() {
        getMuqamis();
        getDilas();
        getIlaqas();
    }

    void getMuqamis() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.MUQAMI_CLASS_NAME);
        query.setLimit(300);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    List<IdentifiableObject> muqamis = new ArrayList<>();
                    for (ParseObject object: scoreList){
                        Muqami muqami = new Muqami(object);
                        muqamis.add(muqami);
                    }
                    Log.d(TAG, "SIZE: "+scoreList.size());
                    muqamiListReplaySubject.onNext(muqamis);
                } else {
                    muqamiListReplaySubject.onError(e);
                    e.printStackTrace();
                }
            }
        });
    }


    void getIlaqas() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.ILAQA_CLASS_NAME);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    List<IdentifiableObject> ilaqas = new ArrayList<>();
                    for (ParseObject object: scoreList){
                        Ilaqa ilaqa = new Ilaqa(object);
                        ilaqas.add(ilaqa);
                    }
                    Log.d(TAG, "SIZE: "+scoreList.size());
                    ilaqaListReplaySubject.onNext(ilaqas);
                } else {
                    ilaqaListReplaySubject.onError(e);
                    e.printStackTrace();
                }
            }
        });
    }


    void getDilas() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.DILA_CLASS_NAME);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    List<IdentifiableObject> dilas = new ArrayList<>();
                    for (ParseObject object: scoreList){
                        Dila dila = new Dila(object);
                        dilas.add(dila);
                    }
                    Log.d(TAG, "SIZE: "+scoreList.size());
                    dilaListReplaySubject.onNext(dilas);
                } else {
                    dilaListReplaySubject.onError(e);
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public ReplaySubject<List<IdentifiableObject>> getMuqamiList() {
        return muqamiListReplaySubject;
    }

    @Override
    public ReplaySubject<List<IdentifiableObject>> getDilaList() {
        return dilaListReplaySubject;
    }

    @Override
    public ReplaySubject<List<IdentifiableObject>> getIlaqaList() {
        return ilaqaListReplaySubject;
    }
}
