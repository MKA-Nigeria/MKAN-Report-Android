package com.aliumujib.mkanapps.coremodule.base;

import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.alium.mkan_report_data.constants.Constants;
import com.aliumujib.mkanapps.R;
import com.aliumujib.mkanapps.coremodule.utils.Utils;

public abstract class BaseMainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();


        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.inflateMenu(getMenuResID());
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
            try {
                super.onBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public abstract @MenuRes
    int getMenuResID();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_main, menu);
        return true;
    }

    public void openDrawer() {
        mDrawer.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }


    public void setToolBarTitle(String toolBarTitle) {
        mToolbar.setTitle(toolBarTitle);
    }


}
