package com.abdulmujibaliu.koutube.fragments.parent

import com.abdulmujibaliu.koutube.data.models.YoutubeVideo

/**
 * Created by abdulmujibaliu on 10/15/17.
 */
interface ParentViewContract {

    interface View{
        fun showVideoView(video: YoutubeVideo, data: List<YoutubeVideo>)
    }

    interface Presenter

}