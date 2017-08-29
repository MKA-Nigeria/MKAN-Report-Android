package com.aliumujib.majlis.mkanreport.auth.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.aliumujib.majlis.mkanreport.auth.view.IAuthActivityView;


/**
 * Created by abdulmujibaliu on 8/23/17.
 */

public class BaseAuthFragment extends Fragment {

    protected IAuthActivityView mAuthActivityView;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof IAuthActivityView) {
            mAuthActivityView = (IAuthActivityView) context;
        }
    }
}