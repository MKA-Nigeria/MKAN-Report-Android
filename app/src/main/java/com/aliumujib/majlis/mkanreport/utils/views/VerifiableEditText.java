package com.aliumujib.majlis.mkanreport.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.utils.inputvalidator.InputValidator;

/**
 * Created by abdulmujibaliu on 8/30/17.
 */

public class VerifiableEditText extends LinearLayout {


    private TextView mTitleText;
    private EditText mContentEt;
    private View mBottomBorder;
    private InputValidator mInputValidator;
    private View mRootView;

    public CharSequence getText() {
        return mContentEt.getText();
    }

    public VerifiableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.VerifiableEditText, 0, 0);
        String titleText = a.getString(R.styleable.VerifiableEditText_titleText);
        boolean isRequired = a.getBoolean(R.styleable.VerifiableEditText_isrequired, true);
        String hint = a.getString(R.styleable.VerifiableEditText_hinttext);

        a.recycle();

//        setOrientation(LinearLayout.HORIZONTAL);
//        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRootView = inflater.inflate(R.layout.verifyable_edittext, this, true);


        initView();

        if(titleText == null || titleText.matches("")){
            mTitleText.setVisibility(GONE);
        }else {
            mTitleText.setText(titleText);
        }

        if(hint == null || hint.matches("")){
            mContentEt.setHint("0000");
        }else {
            mContentEt.setHint(hint);
        }

        mInputValidator.setRequired(isRequired);
    }


    public VerifiableEditText(Context context) {
        super(context);
    }

    private void initView() {
        mTitleText = (TextView) mRootView.findViewById(R.id.title_text);
        mContentEt = (EditText) mRootView.findViewById(R.id.content_et);
        mBottomBorder = mRootView.findViewById(R.id.bottom_border);
        mInputValidator = (InputValidator) mRootView.findViewById(R.id.input_validator);
    }
}
