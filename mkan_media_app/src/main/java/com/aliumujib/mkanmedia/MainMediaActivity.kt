package com.aliumujib.mkanmedia

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.abdulmujibaliu.koutube.fragments.parent.LibraryTabsActivityFragment
import com.alium.soundcloudplayer.ui.fragments.parent.PodcastsLibraryFragment
import com.aliumujib.mkanapps.coremodule.base.BaseMainActivity
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric


class MainMediaActivity : BaseMainActivity() {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_podcasts) {
            setToolBarTitle("Podcasts")
            replaceCurrentFragmentWithBackState(PodcastsLibraryFragment.newInstance())
        } else if (id == R.id.nav_videos) {
            setToolBarTitle("Videos")
            replaceCurrentFragmentWithBackState(LibraryTabsActivityFragment.newInstance())
        }
        closeDrawer()
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fabric.with(this, Crashlytics())
        replaceCurrentFragmentWithBackState(PodcastsLibraryFragment.newInstance())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main_media, menu)
        return true
    }

    override fun getMenuResID(): Int {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            R.menu.activity_media_drawer
        } else {
            R.menu.activity_media_drawer_lollipop
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
