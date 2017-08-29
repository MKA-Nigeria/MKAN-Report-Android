package com.aliumujib.majlis.mkanreport.utils;

import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.app.BaseApplication;
import com.muddzdev.styleabletoastlibrary.StyleableToast;


public class ToastUtils {

    public static void shortToast(@StringRes int text) {
        shortToast(BaseApplication.getInstance().getString(text));
    }

    public static void shortToast(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    public static void longToast(@StringRes int text) {
        longToast(BaseApplication.getInstance().getString(text));
    }

    public static void longToast(String text) {
        show(text, Toast.LENGTH_LONG);
    }

    private static StyleableToast makeToast(String text, @ToastLength int length) {
        //return Toast.makeText(BaseApplication.getInstance(), text, length);
        StyleableToast st = new StyleableToast(BaseApplication.getInstance(), text, length);
        st.setBackgroundColor(BaseApplication.getInstance().getResources().getColor(R.color.colorPrimary));
        st.setTextColor(Color.WHITE);
        st.setIcon(R.drawable.ic_shape_square_plus_white_24dp);
        st.spinIcon();
        //st.setMaxAlpha();
        //st.show();

        return st;
    }

    private static void show(String text, @ToastLength int length) {
        makeToast(text, length).show();
    }

    @IntDef({ Toast.LENGTH_LONG, Toast.LENGTH_SHORT })
    private @interface ToastLength {

    }
}