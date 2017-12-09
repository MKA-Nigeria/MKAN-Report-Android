package com.aliumujib.mkanapps.coremodule.basemvpcontracts;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();


    void showData();

    void showError(String error);

    void showEmpty();

}



