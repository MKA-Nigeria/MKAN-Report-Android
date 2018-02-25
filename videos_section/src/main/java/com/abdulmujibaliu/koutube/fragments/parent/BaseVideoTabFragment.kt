package com.abdulmujibaliu.koutube.fragments.parent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.abdulmujibaliu.koutube.R
import com.abdulmujibaliu.koutube.data.models.YoutubeVideo
import com.abdulmujibaliu.koutube.data.repositories.PlayListRepository
import com.abdulmujibaliu.koutube.data.repositories.contracts.RepositoryContracts
import com.abdulmujibaliu.koutube.fragments.videos.VideoClickListener
import com.aliumujib.mkanapps.coremodule.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 */
abstract class BaseVideoTabFragment : BaseFragment(), VideoClickListener {

    //val TAG: String = javaClass.simpleName
    protected var parentView: ParentViewContract.View ? = null
    val dataSource: RepositoryContracts.IDataSource = PlayListRepository.getInstance()!!


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_base, container, false)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onAttachToParentFragment(parentFragment)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    // In the child fragment.
    private fun onAttachToParentFragment(fragment: Fragment) {
        try {
            parentView = fragment as ParentViewContract.View

        } catch (e: ClassCastException) {
            throw ClassCastException(
                    fragment.toString() + " must implement ParentViewContract.View")
        }

    }


}// Required empty public constructor
