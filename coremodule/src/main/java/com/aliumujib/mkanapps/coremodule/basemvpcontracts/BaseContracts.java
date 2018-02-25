package com.aliumujib.mkanapps.coremodule.basemvpcontracts;

/**
 * Created by aliumujib on 30/01/2018.
 */

public interface BaseContracts {

    interface BaseView<T> {

        void setPresenter(T presenter);

        void showError();

        void showEmpty();

        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showBadge(int position, int count);

    }


    interface  BasePresenter{

        void onCreate();

        void onResume();

        void onPause();

    }
}
