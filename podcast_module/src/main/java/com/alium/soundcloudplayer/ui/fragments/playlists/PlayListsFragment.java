package com.alium.soundcloudplayer.ui.fragments.playlists;


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
import com.alium.soundcloudplayer.ui.fragments.base.BaseLibraryChildFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;


public class PlayListsFragment extends BaseLibraryChildFragment implements PlayListsContracts.PlayListsView {


    private ExpandableLayout sectionLinearLayout;
    private PlayListsContracts.PlayListsPresenter presenter;


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

        setPresenter(new PlayListsPresenter(this, parentView, soundCloudRepository));
        presenter.onCreate();

    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);

        sectionLinearLayout = (ExpandableLayout) rootView.findViewById(R.id.el);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getAllPlayLists();
            }
        });

        sectionLinearLayout.setRenderer(mSectionRenderer);

        sectionLinearLayout.setExpandListener(mExpandListener);
        sectionLinearLayout.setCollapseListener(mCollapseListener);

    }


    //TODO ... move this BS else where ...
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
                    presenter.playTrack(childPosition, model);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_lists, container, false);
    }

    @Override
    public void setPresenter(PlayListsContracts.PlayListsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setData(List<Playlist> playlists) {
        hideLoading();
        sectionLinearLayout.removeAllViews();
        for (Playlist playlist : playlists) {
            Section<Playlist, Track> section = new Section<>();
            section.parent = playlist;
            if (playlist.getTrackList() != null) {
                section.children.addAll(playlist.getTrackList());
                sectionLinearLayout.addSection(section);
            }
        }
    }

    @Override
    public void addMorePlayLists(List<Playlist> playlists) {

    }
}
