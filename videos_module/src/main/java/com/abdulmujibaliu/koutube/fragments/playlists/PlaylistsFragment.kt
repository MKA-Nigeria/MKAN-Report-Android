package com.abdulmujibaliu.koutube.fragments.playlists

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.abdulmujibaliu.koutube.data.models.PlayListItem
import com.abdulmujibaliu.koutube.adapters.PlaylistRVAdapter
import com.abdulmujibaliu.koutube.data.models.PlayListItemsResult
import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.abdulmujibaliu.koutube.fragments.parent.BaseVideoTabFragment
import kotlinx.android.synthetic.main.fragment_base.*

class PlaylistsFragment : BaseVideoTabFragment(), PlayListContracts.PlayListView {


    var playListPresenter: PlayListContracts.PlayListPresenter? = null

    override fun onVideoClicked(youtubeVideo: YoutubeVideo, data: List<YoutubeVideo>) {
        //playListPresenter!!.playVideo(youtubeVideo)
    }

    override fun setPresenter(presenter: PlayListContracts.PlayListPresenter?) {
        this.playListPresenter = presenter
    }

    override fun setData(playLists: List<PlayListItemsResult>) {
        rvAdapter?.addAll(playLists)
    }

    override fun setNextPage(playLists: List<PlayListItemsResult>) {

    }

    var rvAdapter: PlaylistRVAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {

        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAdapter = PlaylistRVAdapter(context, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = rvAdapter
        rvAdapter?.notifyDataSetChanged()


       setPresenter(PlayListPresenter(this, dataSource, parentView))

        playListPresenter!!.onCreate()

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    companion object {

        fun newInstance(): PlaylistsFragment {
            val fragment = PlaylistsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}


open interface PlayListItemClickListener {
    fun onPlayListClick(playListItem: PlayListItem)
}