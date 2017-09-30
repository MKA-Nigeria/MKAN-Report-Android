package com.aliumujib.majlis.mkanreport.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.alium.mkan_report_data.constants.Constants;
import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.main.mvp.IMainActivityView;
import com.aliumujib.majlis.mkanreport.podcast.PodcastsFragment;
import com.aliumujib.majlis.mkanreport.utils.Utils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainActivityView {

    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();


        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    public void replaceCurrentFragmentWithoutBackState(Fragment fragment) {
        Utils.replaceFragmentWithorWithoutBackState(fragment, this, Constants.WITHOUTBSTATE, R.id.frame_container);
    }

    public void replaceCurrentFragmentWithBackState(Fragment fragment) {
        Utils.replaceFragmentWithorWithoutBackState(fragment, this, Constants.WITHBSTATE, R.id.frame_container);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
           closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bullettin) {
            // Handle the camera action
        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_podcasts) {
            setToolBarTitle("Podcasts");
            replaceCurrentFragmentWithBackState(PodcastsFragment.newInstance());
        } else if (id == R.id.nav_shop) {

        }

        closeDrawer();
        return true;
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void openDrawer() {
        mDrawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }


    public void setToolBarTitle(String toolBarTitle) {
        mToolbar.setTitle(toolBarTitle);
    }
}
