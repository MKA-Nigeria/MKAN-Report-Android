package com.aliumujib.majlis.mkan_report_app.utils.views.attachmentpickerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.aliumujib.majlis.mkan_report_app.utils.Utils;

/**
 * Created by abdulmujibaliu on 9/1/17.
 */

public class MaxHeightRecyclerView extends RecyclerView {
    public MaxHeightRecyclerView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        heightSpec = MeasureSpec.makeMeasureSpec(Utils.dpToPx(240), MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
}
