package com.aliumujib.majlis.mkan_report_app.addnew.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aliumujib.majlis.mkan_report_app.R
import com.aliumujib.majlis.mkan_report_app.auth.Tools.MyTimeUtils
import com.aliumujib.majlis.mkan_report_app.utils.views.VerifiableEditText
import com.stepstone.stepper.VerificationError
import kotlinx.android.synthetic.main.fragment_basic_report_details.*
import java.util.*

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

    fun birthDayClick() {
        val calendar = Calendar.getInstance()
        val dpd = DatePickerDialog(activity,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val temp = Calendar.getInstance()
                    temp.set(Calendar.YEAR, year)
                    temp.set(Calendar.MONTH, monthOfYear)
                    temp.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    (getView()!!.findViewById<View>(R.id.date_edit) as VerifiableEditText).setmContentEtText(MyTimeUtils.formatDate(temp.timeInMillis, MyTimeUtils.REPORT_DATE_FORMAT))
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        dpd.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_report_details, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        date_edit.setOnClickListener({
            birthDayClick()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(): BasicReportDetailsFragment {
            val fragment = BasicReportDetailsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
