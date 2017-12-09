package com.aliumujib.majlis.mkan_report_app.reportslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.addnew.activity.EditReportActivity;
import com.aliumujib.mkanapps.coremodule.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReportsFragment extends BaseFragment {

    @BindView(R.id.attachments_rv)
    RecyclerView attachmentsRv;
    @BindView(R.id.fab)
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
    }
}
