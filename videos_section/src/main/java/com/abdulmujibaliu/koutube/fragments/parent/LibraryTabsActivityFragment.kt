package com.abdulmujibaliu.koutube.fragments.parent

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.abdulmujibaliu.koutube.R
import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.abdulmujibaliu.koutube.data.repositories.PlayListRepository
import com.abdulmujibaliu.koutube.data.repositories.contracts.RepositoryContracts
import com.abdulmujibaliu.koutube.adapters.VideoTabsAdapter
import com.abdulmujibaliu.koutube.utils.ui.videodetailsview.VideoDetailsView
import com.github.pedrovgs.DraggableListener
import com.github.pedrovgs.DraggableView
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView
import jp.bglb.bonboru.behaviors.YoutubeLikeBehavior
import kotlinx.android.synthetic.main.fragment_library_tabs.*


/**
 * A placeholder fragment containing a simple view.
 */
open class LibraryTabsActivityFragment : Fragment(), ParentViewContract.View, YoutubeLikeBehavior.OnBehaviorStateListener {

    var media: YouTubePlayerView? = null
    var draggableView: DraggableView? = null
    var description: VideoDetailsView? = null
    val TAG = javaClass.simpleName
    var rootCordinator: RelativeLayout? = null
    private var player: YouTubePlayer? = null
    private val DELAY_MILLIS = 10


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_library_tabs, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootCordinator = view!!.findViewById(R.id.root_view)
        draggableView = view!!.findViewById(R.id.draggable_view)
        media = view!!.findViewById(R.id.media)
        description = view!!.findViewById(R.id.video_details)

        val videoTabsAdapter = VideoTabsAdapter(childFragmentManager)
        toolbar.setTitle("Koutube")
        toolbar.setTitleTextColor(ContextCompat.getColor(context, R.color.colorAccent))
        container.adapter = videoTabsAdapter

        tabs.setupWithViewPager(container)


        val playListRepo: RepositoryContracts.IPlaylistRepository = PlayListRepository.getInstance()!!

        playListRepo.getPlayListsAndVideosForChannels(listOf("UCpEHs4jtfj1sTo1g-ubDyMg"))

        initializeDraggableView()
        hookListeners()
    }


    /**
     * Initialize DraggableView.
     */
    private fun initializeDraggableView() {
        val handler = Handler()
        handler.postDelayed({
            //draggableView!!.setVisibility(View.GONE)
            draggableView!!.closeToRight()
        }, DELAY_MILLIS.toLong())
    }

    private fun hookListeners() {
        draggableView!!.setDraggableListener(object : DraggableListener {
            override fun onMaximized() {

            }

            override fun onMinimized() {

            }

            override fun onClosedToLeft() {

            }

            override fun onClosedToRight() {

            }
        })
    }

    override fun showVideoView(video: YoutubeVideo, data: List<YoutubeVideo>) {
        draggableView!!.visibility = View.VISIBLE
        draggableView!!.maximize()

        media!!.initialize({ initializedYouTubePlayer ->
            player = initializedYouTubePlayer

            initializedYouTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                override fun onReady() {
                    Log.d(TAG, video.videoID)
                    initializedYouTubePlayer.loadVideo(video.videoID, 0f)
                }
            })
        }, true)

        //TODO GET RELATED VIDEOS
        description!!.setVideo(video)
    }


    override fun onBehaviorStateChanged(newState: Long) {
        if (newState == YoutubeLikeBehavior.STATE_TO_RIGHT || newState == YoutubeLikeBehavior.STATE_TO_LEFT) {
            rootCordinator?.removeView(media)
            rootCordinator?.removeView(description)
            val behavior = YoutubeLikeBehavior.from(media)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): LibraryTabsActivityFragment {
            val libraryTabs = LibraryTabsActivityFragment()
            return libraryTabs
        }
    }
}
