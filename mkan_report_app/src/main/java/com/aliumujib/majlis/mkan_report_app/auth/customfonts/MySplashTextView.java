package com.aliumujib.majlis.mkan_report_app.auth.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by one on 3/12/15.
 */
public class MySplashTextView extends android.support.v7.widget.AppCompatTextView {

    public MySplashTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MySplashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySplashTextView(Context context) {
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