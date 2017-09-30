package com.aliumujib.majlis.mkanreport.reportslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.base.BaseFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReportsFragment extends BaseFragment {

    public ReportsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
