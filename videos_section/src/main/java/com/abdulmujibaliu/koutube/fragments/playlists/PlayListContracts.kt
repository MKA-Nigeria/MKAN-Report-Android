package com.abdulmujibaliu.koutube.fragments.playlists

import com.abdulmujibaliu.koutube.data.models.PlayList
import com.abdulmujibaliu.koutube.data.models.PlayListItemsResult
import com.aliumujib.mkanapps.coremodule.basemvpcontracts.BaseContracts

/**
 * Created by aliumujib on 25/02/2018.
 */
interface PlayListContracts {

    interface PlayListView : BaseContracts.BaseView<PlayListPresenter>{

        fun setData(playLists: List<PlayListItemsResult>)

        fun setNextPage(playLists: List<PlayListItemsResult>)

    }


    interface PlayListPresenter : BaseContracts.BasePresenter{

        fun getPlayLists()

    }

}