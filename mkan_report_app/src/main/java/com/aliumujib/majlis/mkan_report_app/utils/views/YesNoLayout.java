package com.aliumujib.majlis.mkan_report_app.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.aliumujib.majlis.mkan_report_app.R;
import com.jaouan.compoundlayout.RadioLayoutGroup;

/**
 * Created by abdulmujibaliu on 8/30/17.
 */

public class YesNoLayout extends RadioLayoutGroup {

    private View mView;

    private TextView mQuestionTitle;

    public YesNoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.YesNoLayout, 0, 0);
        String titleText = a.getString(R.styleable.YesNoLayout_yes_no_title);

        a.recycle();

        mView = inflater.inflate(R.layout.true_false_picker_layout, this, true);

        mQuestionTitle = (TextView) mView.findViewById(R.id.true_false_title);

        if (titleText != null && !titleText.equals("")) {
            mQuestionTitle.setVisibility(VISIBLE);
            mQuestionTitle.setText(titleText);
        } else {
            mQuestionTitle.setVisibility(GONE);
        }

    }

    public YesNoLayout(Context context) {
        this(context, null);
    }

}
