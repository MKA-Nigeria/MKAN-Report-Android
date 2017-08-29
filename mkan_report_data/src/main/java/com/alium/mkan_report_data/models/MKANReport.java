package com.alium.mkan_report_data.models;

import com.alium.mkan_report_data.models.form_models.Etimad;
import com.alium.mkan_report_data.models.form_models.Taaleem;
import com.alium.mkan_report_data.models.form_models.Tabligh;
import com.alium.mkan_report_data.models.form_models.Tajneed;
import com.alium.mkan_report_data.models.form_models.Tarbiyya;
import com.alium.mkan_report_data.models.form_models.TarbiyyatiNauMubayeen;
import com.parse.ParseObject;

/**
 * Created by abdulmujibaliu on 8/11/17.
 */

public class MKANReport {

    private String  nazimNauMubayeenPhoneNumber;


    private Etimad etimadData;
    private Tajneed tajneedData;
    private Taaleem taaleemDaTa;
    private Tabligh tablighData;
    private Tarbiyya tarbiyyaData;
    private TarbiyyatiNauMubayeen tarbiyyatiNauMubayeenData;


    public TarbiyyatiNauMubayeen getTarbiyyatiNauMubayeenData() {
        return tarbiyyatiNauMubayeenData;
    }

    public void setTarbiyyatiNauMubayeenData(TarbiyyatiNauMubayeen tarbiyyatiNauMubayeenData) {
        this.tarbiyyatiNauMubayeenData = tarbiyyatiNauMubayeenData;
    }

    public Tarbiyya getTarbiyyaData() {
        return tarbiyyaData;
    }

    public void setTarbiyyaData(Tarbiyya tarbiyyaData) {
        this.tarbiyyaData = tarbiyyaData;
    }

    public Tabligh getTablighData() {
        return tablighData;
    }

    public void setTablighData(Tabligh tablighData) {
        this.tablighData = tablighData;
    }

    public Taaleem getTaaleemDaTa() {
        return taaleemDaTa;
    }

    public void setTaaleemDaTa(Taaleem taaleemDaTa) {
        this.taaleemDaTa = taaleemDaTa;
    }

    public Etimad getEtimadData() {
        return etimadData;
    }

    public void setEtimadData(Etimad etimadData) {
        this.etimadData = etimadData;
    }

    public Tajneed getTajneedData() {
        return tajneedData;
    }

    public void setTajneedData(Tajneed tajneedData) {
        this.tajneedData = tajneedData;
    }

    public Etimad getmEtimadData() {
        return etimadData;
    }

    public void setmEtimadData(Etimad etimad) {
        this.etimadData = etimad;
    }

    public MKANReport(ParseObject parseObject) {
    }

    public MKANReport() {
    }

}
