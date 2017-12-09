package com.aliumujib.majlis.mkan_report_app.auth.presenter;


import com.alium.mkan_report_data.models.Profile;
import com.alium.mkan_report_data.services.AuthorizationService;
import com.alium.mkan_report_data.services.DemoninationsRepository;
import com.alium.mkan_report_data.services.contracts.IAuthServiceContract;
import com.alium.mkan_report_data.services.contracts.IDenominationsRepository;
import com.aliumujib.majlis.mkan_report_app.auth.view.IAuthActivityView;

import io.reactivex.Observable;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public class AuthActivityPresenter implements IAuthActivityPresenter {


    private IAuthActivityView authActivityView;
    private IAuthServiceContract.ILoginServiceContract mLoginServiceContract;
    private IAuthServiceContract.ISignUpServiceContract mSignUpServiceContract;
    private IDenominationsRepository mDenominationsRepository;

    public AuthActivityPresenter(IAuthActivityView authActivityView) {
        this.authActivityView = authActivityView;
        this.mLoginServiceContract = AuthorizationService.mSharedLoginServiceInstance;
        this.mSignUpServiceContract = AuthorizationService.mSharedSignUpServiceInstance;
        this.mDenominationsRepository = DemoninationsRepository.sharedDenominationRepoInstance;
    }

    @Override
    public void showLoading() {
        authActivityView.showLoading();
    }

    @Override
    public void hideLoading() {
        authActivityView.hideLoading();
    }

    @Override
    public void showData() {

    }

    @Override
    public void showError(String error) {
        authActivityView.showError(error);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public Observable<Profile> getLoginService() {
        return mLoginServiceContract.mgetUserLoginDoneObservable();
    }

    @Override
    public Observable<Profile> getSignUpService() {
        return mSignUpServiceContract.mgetUserSignUpDoneObservable();
    }

    @Override
    public IDenominationsRepository getDenimationsService() {
        return mDenominationsRepository;
    }

    @Override
    public void signUp(Profile profile) {
        authActivityView.showLoading();
        mSignUpServiceContract.signUserUp(profile).subscribe(profile1 -> {
            hideLoading();
            authActivityView.showData();
        }, throwable -> {
            hideLoading();
            showError(throwable.getLocalizedMessage());
        });
    }

    @Override
    public void login(Profile profile) {
        authActivityView.showLoading();
        mLoginServiceContract.signUserIn(profile).subscribe(profile1 -> {
            hideLoading();
            authActivityView.showData();
        }, throwable -> {
            hideLoading();
            showError(throwable.getLocalizedMessage());
        });
    }

    @Override
    public void resetPassword(Profile profile) {

    }
}
