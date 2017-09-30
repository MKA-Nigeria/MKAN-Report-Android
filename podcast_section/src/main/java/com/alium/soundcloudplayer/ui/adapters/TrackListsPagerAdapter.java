package com.alium.soundcloudplayer.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.User;
import com.alium.soundcloudplayer.ui.fragments.PlayListsFragment;
import com.alium.soundcloudplayer.ui.fragments.TrackListFragment;

/**
 * Created by Abdul-Mujeeb Aliu  on 10-10-2017
 */

public class TrackListsPagerAdapter extends FragmentPagerAdapter {

    private List<User> users = new ArrayList<>();

    public TrackListsPagerAdapter(FragmentManager fm, List<User> users) {
        super(fm);
        addUsers(users);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return TrackListFragment.newInstance();
        } else {
            return PlayListsFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < users.size()) {
            return users.get(position).getUsername();
        }
        return null;
    }

    public void addUsers(List<User> users) {
        if (users != null && !users.isEmpty()) {
            this.users.addAll(users);
            notifyDataSetChanged();
        }
    }
}
