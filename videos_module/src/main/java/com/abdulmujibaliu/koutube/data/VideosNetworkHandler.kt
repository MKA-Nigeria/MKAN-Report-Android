package com.abdulmujibaliu.koutube.data

import com.abdulmujibaliu.koutube.data.models.*
import com.abdulmujibaliu.koutube.data.models.deserializers.ChannelPlaylistsDeserializer
import com.abdulmujibaliu.koutube.data.models.deserializers.PlaylistsItemsDeserializer
import com.abdulmujibaliu.koutube.data.models.deserializers.VideoDeserializer
import com.aliumujib.mkanapps.coremodule.utils.BaseNetworkHandler
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor

/**
 * Created by abdulmujibaliu on 10/15/17.
 */

class VideosNetworkHandler : BaseNetworkHandler() {

    var playListserviceInstance: PlaylistService? = null
    var videosServiceInstance: VideosService? = null


    companion object {

       private var videoHandlerInstance: VideosNetworkHandler? = null

        fun getInstance(): VideosNetworkHandler {
            if (videoHandlerInstance == null) {
                videoHandlerInstance = VideosNetworkHandler()
            }

            return videoHandlerInstance as VideosNetworkHandler
        }
    }

    fun getPlayListService(): PlaylistService {
        if (playListserviceInstance == null) {
            initPlayListService()
        }
        return playListserviceInstance!!
    }


    fun getVideosService(): VideosService {
        if (videosServiceInstance == null) {
            initVideosService()
        }
        return videosServiceInstance!!
    }

    fun initPlayListService() {
        playListserviceInstance = retrofit.create(PlaylistService::class.java)
    }


    fun initVideosService() {
        videosServiceInstance = retrofit.create(VideosService::class.java)
    }

    init {
        initService()
    }

    override fun initVariables() {

    }


    override fun getGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(PlayListsResult::class.java, ChannelPlaylistsDeserializer())
                .registerTypeAdapter(PlayListItemsResult::class.java, PlaylistsItemsDeserializer())
                .registerTypeAdapter(VideoResult::class.java, VideoDeserializer())
                .create()
    }

    override fun getBaseURL(): String {
        return "https://www.googleapis.com/youtube/v3/"
    }

    override fun createApiKeyQueryInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("part", "snippet,contentDetails")
                    .addQueryParameter("maxResults", 50.toString())
                    .addQueryParameter(KutConstants.API_KEY,
                            KutConstants.API_KEY_VAL)
                    //.addQueryParameter(WSConstants.PAGE_LIMIT, 200.toString())
                    .build()
            chain.proceed(original.newBuilder().url(url).build())
        }
    }


}


class KutConstants {
    companion object {
        val API_KEY = "key"
        val API_KEY_VAL = "AIzaSyCzTQAdni52z7AR6vLPBVoM75FES9BIUTw"
        val KEY_ITEMS = "items"
        val KEY_ITEM_ID: String = "id"

        val KEY_CONTENT_DETAILS: String = "contentDetails"

        val KEY_VIDEO_ID: String = "videoId"
        val SNIPPET: String = "snippet"
        val RECOURCE_ID: String = "resourceId"

        val VIDEO_PUBSLISHED_AT: String = "publishedAt"
        val VIDEO_TITLE: String = "title"
        val VIDEO_DESCRIPTION: String = "description"
        val VIDEO_THUMBNAILS: String = "thumbnails"
        val VIDEO_MAXRES_IMG: String = "standard"
        val VIDEO_STANDARD: String = "standard"
        val VIDEO_MEDIUM_IMG: String = "medium"
        val VIDEO_HIGH_IMG: String = "high"
        val VIDEO_DEFAULT_IMG: String = "default"

        val VIDEO_THUMB_URL: String = "url"
        val VIDEO_CHANNEL_NAME: String = "channelName"

        val VIDEO_CHANNEL_TITLE: String = "channelTitle"

        val VIDEO_VIDEO_DURATION: String = "duration"
        val VIDEO_VIDEO_STATISTICS: String = "statistics"

        val VIDEO_VIDEO_VIEW_COUNT: String = "viewCount"


    }
}