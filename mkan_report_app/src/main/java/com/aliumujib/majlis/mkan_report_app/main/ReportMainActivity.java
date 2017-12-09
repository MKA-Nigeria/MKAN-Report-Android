package com.aliumujib.majlis.mkan_report_app.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.main.mvp.IMainActivityView;
import com.aliumujib.majlis.mkan_report_app.reportslist.ReportsFragment;
import com.aliumujib.mkanapps.coremodule.base.BaseMainActivity;

public class ReportMainActivity extends BaseMainActivity
        implements IMainActivityView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    @Override
    public int getMenuResID() {
        return R.menu.activity_main_drawer;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_reports) {
            setToolBarTitle("Reports");
            replaceCurrentFragmentWithBackState(ReportsFragment.newInstance());
        } else if (id == R.id.nav_bullettin) {
            // Handle the camera action
        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_podcasts) {
            setToolBarTitle("Podcasts");
        } else if (id == R.id.nav_videos) {
            setToolBarTitle("Videos");
        }

        closeDrawer();
        return true;
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, ReportMainActivity.class);
        context.startActivity(intent);
    }


}
