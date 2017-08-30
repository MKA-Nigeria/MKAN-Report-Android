package com.aliumujib.majlis.mkanreport.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliumujib.majlis.mkanreport.R;

/**
 * Created by abdulmujibaliu on 8/30/17.
 */

public class QuestionLayout extends LinearLayout {

    public static int INVALID_QUESTION_NUMBER = -2;
    private final View mView;

    private TextView mQuestionTitle, mQuestionNumber;

    public QuestionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.QuestionLayout, 0, 0);
        String titleText = a.getString(R.styleable.QuestionLayout_questiontitle);
        int questionNumber = a.getInt(R.styleable.QuestionLayout_questionnumber, INVALID_QUESTION_NUMBER);


        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mView = inflater.inflate(R.layout.question_layout, this, true);

        mQuestionNumber = (TextView) mView.findViewById(R.id.question_number);
        mQuestionTitle = (TextView) mView.findViewById(R.id.question_title);

        if(questionNumber!= INVALID_QUESTION_NUMBER){
            mQuestionNumber.setText(String.format("%s.", String.valueOf(questionNumber)));
        }

        mQuestionTitle.setText(titleText);

    }


    //Hopefull this never gets callled ... and if it does, //TODO CHECK FOR NULL
    public QuestionLayout(Context context){
        this(context, null);
    }


}
