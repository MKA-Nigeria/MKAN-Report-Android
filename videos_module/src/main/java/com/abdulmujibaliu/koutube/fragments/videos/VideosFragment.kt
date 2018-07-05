package com.abdulmujibaliu.koutube.fragments.videos


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.abdulmujibaliu.koutube.adapters.VideoRVAdapter
import com.abdulmujibaliu.koutube.data.models.PlayListItemsResult
import com.abdulmujibaliu.koutube.fragments.parent.BaseVideoTabFragment
import kotlinx.android.synthetic.main.fragment_base.*


class VideosFragment : BaseVideoTabFragment() , VideosContracts.VideosView{


    private var videosPresenter: VideosContracts.VideosPresenter? = null

    override fun setPresenter(presenter: VideosContracts.VideosPresenter?) {
        this.videosPresenter = presenter
    }

    override fun setData(playLists: List<YoutubeVideo>) {
        Log.d(TAG, playLists.toString())
        videosRVAdapter!!.addAll(playLists as List<YoutubeVideo>)
    }

    override fun setNextPage(playLists: List<YoutubeVideo>) {

    }

    override fun launchVideoPlayer(video: YoutubeVideo) {
        parentView?.showVideoView(video, mutableListOf())
    }

    override fun onVideoClicked(youtubeVideo: YoutubeVideo, data: List<YoutubeVideo>) {
        videosPresenter!!.playVideo(youtubeVideo)
    }


    var videosRVAdapter: VideoRVAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        videosRVAdapter = VideoRVAdapter(context, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = videosRVAdapter
        videosRVAdapter?.notifyDataSetChanged()


        setPresenter(VideosPresenter(this, dataSource, parentView))

        videosPresenter!!.onCreate()

        //UCpEHs4jtfj1sTo1g-ubDyMg //MTANG


    }


    companion object {

        fun newInstance(): VideosFragment {
            val fragment = VideosFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}


interface VideoClickListener {
    fun onVideoClicked(youtubeVideo: YoutubeVideo, relatedVideos: List<YoutubeVideo>)
}