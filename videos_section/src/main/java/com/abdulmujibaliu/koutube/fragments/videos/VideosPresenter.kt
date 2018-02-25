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
        view.showLoading()
        dataSource.getVideosObservable()?.subscribe({ data ->
            view.hideLoading()
            view.setData(data.items as List<YoutubeVideo>)
        }, { error ->
            view.hideLoading()
            view.showMessage(error.message)
            error.printStackTrace()
        })
    }

    override fun playVideo(video: YoutubeVideo) {
        parentView!!.showVideoView(video, mutableListOf())
    }
}