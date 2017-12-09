package com.aliumujib.mkanapps.coremodule.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.aliumujib.mkanapps.R;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

/**
 * Created by abdulmujibaliu on 6/8/17.
 */

public class DialogUtils {

    private static MaterialDialog mMaterialDialog;

    public static void alertDialog(Context context, String text, MaterialDialog.SingleButtonCallback mCallback) {
        dialog(context, "Alert", text, mCallback);
    }

    private static void dialog(Context context, String title, String text, MaterialDialog.SingleButtonCallback mCallback) {
        new MaterialStyledDialog.Builder(context)
                .setTitle(title)
                .setDescription(text)
                .setHeaderDrawable(R.drawable.mosque_green)
                .setCancelable(false)
                .setNeutralText("OKAY")
                .onNeutral(mCallback)
                .show();
    }

    public static void loadingDialog(Context context){
      mMaterialDialog =  new MaterialDialog.Builder(context)
                .content(R.string.progress_dialog)
                .progress(true, 0).build();
        mMaterialDialog.show();
    }

    public static void hideLoadingDialog(){
        mMaterialDialog.dismiss();
    }



}
