package com.aliumujib.mkanapps.coremodule.basemvpcontracts;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IBasePresenter {

    void showLoading();

    void hideLoading();


    void showData();

    void showError(String errorMessage);

    void showEmpty();

}
