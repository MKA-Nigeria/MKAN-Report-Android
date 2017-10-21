package com.abdulmujibaliu.koutube.utils.ui.playlistrowitem

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.view.LayoutInflater
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.abdulmujibaliu.koutube.R
import com.abdulmujibaliu.koutube.data.models.BaseModel
import com.abdulmujibaliu.koutube.data.models.PlayListItem
import com.abdulmujibaliu.koutube.data.models.PlayListItemsResult
import com.abdulmujibaliu.koutube.fragments.childfragments.PlayListItemClickListener
import com.abdulmujibaliu.koutube.utils.ui.playlistrowitem.adapter.PlayListRowRVAdapter


/**
 * Created by abdulmujibaliu on 10/17/17.
 */

class PlayListItemRowView : LinearLayout {

    private val TAG = javaClass.simpleName
    private var mView: View? = null
    private var mSectionTitleView: TextView? = null
    private var mYoutubeVideosRV: RecyclerView? = null

    protected var mAttachmentsAdapter: PlayListRowRVAdapter? = null
    protected var mLayoutManager: RecyclerView.LayoutManager? = null

    private var mSectionTitle: String? = null
    protected var mDataSource: List<BaseModel> = ArrayList()
    var mListener: PlayListItemClickListener? = null


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val a = context.obtainStyledAttributes(attrs,
                R.styleable.PlayListRowView, 0, 0)


        mSectionTitle = a.getString(R.styleable.PlayListRowView_section_title)

        a.recycle()

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        mView = inflater.inflate(R.layout.playlist_item_row, this, true)

        mSectionTitleView = mView!!.findViewById(R.id.section_title)
        mYoutubeVideosRV = mView!!.findViewById(R.id.section_items_recycler)

        initRV()


        if (mSectionTitle != null && !mSectionTitle!!.matches("".toRegex()))
            mSectionTitleView!!.text = mSectionTitle

    }

    fun getSectionTitle(): String? {
        return mSectionTitle
    }

    fun setSectionTitle(sectionTitle: String) {
        this.mSectionTitle = sectionTitle
        mSectionTitleView!!.text = sectionTitle
    }

    fun getmDataSource(): List<BaseModel> {
        return mDataSource
    }

    fun setPlayListItemResult(playListItemResult: PlayListItemsResult) {
        this.setmDataSource(playListItemResult.items)
        if(!playListItemResult.items.isEmpty()){
            this.setSectionTitle("${playListItemResult.items[0].itemTitle} (${playListItemResult.items.size} videos)" )
        }
    }

    fun setmDataSource(youtubeVideos: List<BaseModel>) {
        this.mDataSource = youtubeVideos
        this.mAttachmentsAdapter!!.addAll(youtubeVideos)
    }

    protected fun initRV() {
        mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mYoutubeVideosRV!!.layoutManager = mLayoutManager
        mYoutubeVideosRV!!.setHasFixedSize(true)
        mYoutubeVideosRV!!.isNestedScrollingEnabled = false
        try {
            mAttachmentsAdapter = PlayListRowRVAdapter(context, mListener)
            mYoutubeVideosRV!!.adapter = mAttachmentsAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //mAttachmentsAdapter.reloadData()
    }

    companion object {
        var INVALID_REQUEST_CODE_NUMBER = -2
    }
}
