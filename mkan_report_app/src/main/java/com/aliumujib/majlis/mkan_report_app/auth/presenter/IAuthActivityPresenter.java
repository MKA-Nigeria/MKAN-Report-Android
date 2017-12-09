package com.aliumujib.majlis.mkan_report_app.auth.presenter;



import com.alium.mkan_report_data.models.Profile;
import com.alium.mkan_report_data.services.contracts.IDenominationsRepository;
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.IBasePresenter;

import io.reactivex.Observable;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IAuthActivityPresenter extends IBasePresenter {

    Observable<Profile> getLoginService();

    Observable<Profile> getSignUpService();

    IDenominationsRepository getDenimationsService();

    void signUp(Profile profile);

    void login(Profile profile);

    void resetPassword(Profile profile);



}
