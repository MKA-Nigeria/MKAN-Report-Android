package com.aliumujib.majlis.mkanreport.auth.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by one on 3/12/15.
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf;
            switch (getTypeface().getStyle()) {
                case Typeface.BOLD:
                    tf=Typeface.createFromAsset(getContext().getAssets(), FontConstants.FONT_BOLD);
                    break;
                default:
                    tf=Typeface.createFromAsset(getContext().getAssets(), FontConstants.FONT_NORMAL);
            }
            setTypeface(tf);
        }
    }

}