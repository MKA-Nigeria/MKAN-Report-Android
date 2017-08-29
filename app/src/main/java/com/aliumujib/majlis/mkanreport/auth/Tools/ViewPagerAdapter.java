package com.aliumujib.majlis.mkanreport.auth.Tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aliumujib.majlis.mkanreport.auth.Fragments.LoginFragment;
import com.aliumujib.majlis.mkanreport.auth.Fragments.ResetPasswordFragment;
import com.aliumujib.majlis.mkanreport.auth.Fragments.SignUpFragment;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LoginFragment tab1 = new LoginFragment();
                return tab1;
            case 1:
                SignUpFragment tab2 = new SignUpFragment();
                return tab2;
//
            case 2:
                ResetPasswordFragment tab3 = new ResetPasswordFragment();
                return tab3;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}