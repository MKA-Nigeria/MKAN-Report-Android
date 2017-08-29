package com.alium.mkan_report_data.services;


import com.alium.mkan_report_data.constants.Constants;
import com.alium.mkan_report_data.models.Profile;
import com.alium.mkan_report_data.services.contracts.IAuthServiceContract;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public class AuthorizationService implements IAuthServiceContract.ILoginServiceContract, IAuthServiceContract.ISignUpServiceContract {

    public static IAuthServiceContract.ILoginServiceContract mSharedLoginServiceInstance = new AuthorizationService();

    public static IAuthServiceContract.ISignUpServiceContract mSharedSignUpServiceInstance = new AuthorizationService();

    private PublishSubject<Profile> loginPublishSubject = PublishSubject.create();

    private PublishSubject<Profile> signUpPublishSubject = PublishSubject.create();

    @Override
    public PublishSubject<Profile> mgetUserLoginDoneObservable() {
        return loginPublishSubject;
    }

    @Override
    public Observable<Profile> signUserIn(final Profile profile) {
        return new Observable<Profile>() {
            @Override
            protected void subscribeActual(final Observer<? super Profile> observer) {
                ParseUser.logInInBackground(profile.get(Profile.Field.USERNAME), profile.get(Profile.Field.PASSWORD), new LogInCallback() {
                    public void done(final ParseUser user, final ParseException e) {
                        if (user != null) {
                            Profile profileObj = new Profile(user);
                            observer.onNext(profileObj);
                        } else {
                            observer.onError(e);
                        }
                    }

                });
            }
        };
    }



    @Override
    public void performTwitterSignIn() {

    }

    @Override
    public void performFacebookSignIn() {

    }


    @Override
    public PublishSubject<Profile> mgetUserSignUpDoneObservable() {
        return signUpPublishSubject;
    }

    @Override
    public Observable<Profile> signUserUp(final Profile profile) {
        return new Observable<Profile>() {
            @Override
            protected void subscribeActual(final Observer<? super Profile> observer) {
                final ParseUser user = new ParseUser();
                user.setUsername(profile.getmUserName());
                user.setPassword(profile.getmUserPassword());
                user.setEmail(profile.getmEmail());
//                user.put(Constants.USER_INFO_CLASS_ILAQA_ID, profile.getmIlaqa().getSubtitle());
//                user.put(Constants.USER_INFO_CLASS_DILA_ID, profile.getmDila().getSubtitle());
//                user.put(Constants.USER_INFO_CLASS_MUQAMI_ID, profile.getmMuqami().getSubtitle());

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Profile profileObj = new Profile(user);
                            observer.onNext(profileObj);
                        } else {
                            observer.onError(e);
                        }
                    }
                });
            }
        };
    }
}
