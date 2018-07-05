package com.abdulmujibaliu.koutube.fragments.videos

import com.abdulmujibaliu.koutube.data.models.PlayListItemsResult
import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.BaseContracts

/**
 * Created by aliumujib on 25/02/2018.
 */
interface VideosContracts {

    interface VideosView : BaseContracts.BaseView<VideosPresenter> {

        fun setData(playLists: List<YoutubeVideo>)

        fun setNextPage(playLists: List<YoutubeVideo>)

        fun launchVideoPlayer(video: YoutubeVideo)
    }


    interface VideosPresenter : BaseContracts.BasePresenter {

        fun getVideos()

        fun playVideo(video: YoutubeVideo)


    }

}