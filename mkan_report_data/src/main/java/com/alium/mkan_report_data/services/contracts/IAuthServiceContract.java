package com.alium.mkan_report_data.services.contracts;


import com.alium.mkan_report_data.models.Profile;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public interface IAuthServiceContract {

     interface ILoginServiceContract {

         PublishSubject<Profile> mgetUserLoginDoneObservable();

         Observable<Profile> signUserIn(Profile profile);

         void performTwitterSignIn();

         void performFacebookSignIn();

     }

    interface ISignUpServiceContract {

        PublishSubject<Profile> mgetUserSignUpDoneObservable();

        Observable<Profile> signUserUp(Profile profile);

    }

}
