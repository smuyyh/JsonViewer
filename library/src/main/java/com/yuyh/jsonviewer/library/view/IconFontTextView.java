package com.yuyh.jsonviewer.library.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by yuyuhang on 2017/11/29.
 */
public class IconFontTextView extends AppCompatTextView {

    public IconFontTextView(Context context) {
        this(context, null);
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setTypeface(Typeface.createFromAsset(context.getAssets(), "icomoon.ttf"));
    }
}
