package com.aliumujib.majlis.mkanreport.reportslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.addnew.activity.EditReportActivity;
import com.aliumujib.majlis.mkanreport.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReportsFragment extends BaseFragment {

    @Bind(R.id.attachments_rv)
    RecyclerView attachmentsRv;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    public ReportsFragment() {
    }

    public static ReportsFragment newInstance() {

        Bundle args = new Bundle();

        ReportsFragment fragment = new ReportsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @OnClick(R.id.fab)
    void onFabClick() {
        EditReportActivity.start(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
