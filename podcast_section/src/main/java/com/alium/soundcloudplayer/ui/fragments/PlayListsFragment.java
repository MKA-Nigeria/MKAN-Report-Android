package com.alium.soundcloudplayer.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alium.soundcloudplayer.R;
import com.alium.soundcloudplayer.data.models.Playlist;
import com.alium.soundcloudplayer.data.models.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;
import io.reactivex.functions.Consumer;


public class PlayListsFragment extends BaseLibraryChildFragment {


    private ExpandableLayout mSectionLinearLayout;


    public PlayListsFragment() {
        // Required empty public constructor
    }

    public static PlayListsFragment newInstance() {
        PlayListsFragment fragment = new PlayListsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();

    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);

        mSectionLinearLayout = (ExpandableLayout) rootView.findViewById(R.id.el);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });


        mSectionLinearLayout.setRenderer(mSectionRenderer);

        mSectionLinearLayout.setExpandListener(mExpandListener);
        mSectionLinearLayout.setCollapseListener(mCollapseListener);

    }

    ExpandableLayout.Renderer<Playlist, Track> mSectionRenderer = new ExpandableLayout.Renderer<Playlist, Track>() {
        @Override
        public void renderParent(View view, Playlist model, boolean isExpanded, int parentPosition) {
            ((TextView) view.findViewById(R.id.track_card_title)).setText(model.getTitle());
            ((TextView) view.findViewById(R.id.item_view_user__description)).setText(model.getOwner());
            ((ImageView) view.findViewById(R.id.action_icon)).setImageResource(isExpanded ? R.drawable.arrow_up : R.drawable.arrow_down);
            if (model.getImageUrl() != null) {
                Picasso.with(getContext()).load(model.getImageUrl()).into(((ImageView) view.findViewById(R.id.track_card_thumbnail)));
            }
        }

        @Override
        public void renderChild(View view, final Track model, int parentPosition, final int childPosition) {
            ((TextView) view.findViewById(R.id.tvChild)).setText(model.getTitle());
            ((TextView) view.findViewById(R.id.tvChildNumber)).setText(String.format("%d.", childPosition + 1));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mParentFragment.playPodCast(childPosition, model);
                }
            });
        }
    };

    private ExpandCollapseListener.ExpandListener<? extends Object> mExpandListener = new ExpandCollapseListener.ExpandListener<Playlist>() {
        @Override
        public void onExpanded(int parentIndex, Playlist parent, View view) {
            ((ImageView) view.findViewById(R.id.action_icon)).setImageResource(R.drawable.arrow_up);
        }
    };

    private ExpandCollapseListener.CollapseListener<? extends Object> mCollapseListener = new ExpandCollapseListener.CollapseListener<Playlist>() {
        @Override
        public void onCollapsed(int parentIndex, Playlist parent, View view) {
            ((ImageView) view.findViewById(R.id.action_icon)).setImageResource(R.drawable.arrow_down);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void initData() {
        showLoading();
        mParentFragment.getPresenter().getAllPlayLists().subscribe(new Consumer<List<Playlist>>() {
            @Override
            public void accept(List<Playlist> playlists) throws Exception {
                hideLoading();
                mSectionLinearLayout.removeAllViews();
                for (Playlist playlist : playlists) {
                    Section<Playlist, Track> section = new Section<>();
                    section.parent = playlist;
                    section.children.addAll(playlist.getTrackList());
                    mSectionLinearLayout.addSection(section);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_lists, container, false);
    }

}
