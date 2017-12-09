package com.aliumujib.majlis.mkan_report_app.auth.view;

import com.aliumujib.majlis.mkan_report_app.auth.presenter.IAuthActivityPresenter;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.IBaseView;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IAuthActivityView extends IBaseView {

    IAuthActivityPresenter getPresenter();


}
