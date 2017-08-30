package com.aliumujib.majlis.mkanreport.utils.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.aliumujib.majlis.mkanreport.R;
import com.jaouan.compoundlayout.RadioLayoutGroup;

/**
 * Created by abdulmujibaliu on 8/30/17.
 */

public class YesNoLayout extends RadioLayoutGroup {

    public YesNoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.true_false_picker_layout, this, true);

    }

    public YesNoLayout(Context context) {
        this(context, null);
    }

}
