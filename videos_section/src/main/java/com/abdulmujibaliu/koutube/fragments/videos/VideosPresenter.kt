package com.abdulmujibaliu.koutube.fragments.videos

import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.abdulmujibaliu.koutube.data.repositories.contracts.RepositoryContracts
import com.abdulmujibaliu.koutube.fragments.parent.ParentViewContract

/**
 * Created by aliumujib on 25/02/2018.
 */
class VideosPresenter(val view: VideosContracts.VideosView, val dataSource: RepositoryContracts.IDataSource, val parentView: ParentViewContract.View?) : VideosContracts.VideosPresenter {


    override fun onCreate() {
        getVideos()
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun getVideos() {
        dataSource.getVideosObservable()?.subscribe(
                { data ->
                    view.setData(data.items as List<YoutubeVideo>)
                }, { error ->
                    view.showMessage(error.message)
                    error.printStackTrace()
        })
    }

    override fun playVideo(video: YoutubeVideo) {

    }
}