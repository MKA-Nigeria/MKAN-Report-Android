package com.abdulmujibaliu.koutube.fragments.playlists

import com.abdulmujibaliu.koutube.data.repositories.contracts.RepositoryContracts
import com.abdulmujibaliu.koutube.fragments.parent.ParentViewContract

/**
 * Created by aliumujib on 25/02/2018.
 */


class PlayListPresenter(val view: PlayListContracts.PlayListView, val dataSource: RepositoryContracts.IDataSource, val parentView: ParentViewContract.View?) : PlayListContracts.PlayListPresenter {

    override fun onResume() {

    }

    override fun onPause() {
    }

    override fun getPlayLists() {
        dataSource.getPlayListObservable()?.subscribe({ data ->
            view.hideLoading()
            view.setData(data)
        }, { error ->
            view.hideLoading()
            view.showMessage(error.message)
            error.printStackTrace()
        })
    }

    override fun onCreate() {
        getPlayLists()
    }


}