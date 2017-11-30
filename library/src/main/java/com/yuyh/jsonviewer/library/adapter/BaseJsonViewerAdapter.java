package com.yuyh.jsonviewer.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;

/**
 * Created by yuyuhang on 2017/11/30.
 */
public abstract class BaseJsonViewerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public static ForegroundColorSpan keySpan = new ForegroundColorSpan(0xFF922799);
    public static ForegroundColorSpan textSpan = new ForegroundColorSpan(0xFF3AB54A);
    public static ForegroundColorSpan numberSpan = new ForegroundColorSpan(0xFF25AAE2);
    public static ForegroundColorSpan urlSpan = new ForegroundColorSpan(0xFF66D2D5);
    public static ForegroundColorSpan nullSpan = new ForegroundColorSpan(0xFFEF5935);
    public static ForegroundColorSpan bracesSpan = new ForegroundColorSpan(0xFF4A555F);
}
