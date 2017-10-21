package com.aliumujib.majlis.mkanreport.addnew.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aliumujib.majlis.mkanreport.R
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

class BasicReportDetailsFragment : BaseReportFragment() {
    override fun onSelected() {

    }

    override fun verifyStep(): VerificationError? {
       return null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_report_details, container, false)
    }

    companion object {

        fun newInstance(): BasicReportDetailsFragment {
            val fragment = BasicReportDetailsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
