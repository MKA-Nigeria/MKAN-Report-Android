package com.aliumujib.majlis.mkanreport.auth.view;

import com.aliumujib.majlis.mkanreport.auth.presenter.IAuthActivityPresenter;
import com.aliumujib.majlis.mkanreport.basemvpcontracts.IBaseView;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IAuthActivityView extends IBaseView {

    IAuthActivityPresenter getPresenter();


}
