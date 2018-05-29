package com.yuyh.jsonviewer.library.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuyh.jsonviewer.library.R;

/**
 * Created by yuyuhang on 2017/11/29.
 */
public class JsonItemView extends LinearLayout {

    private Context mContext;

    private TextView mTvLeft, mTvRight;
    private TextView mTvIcon;

    public JsonItemView(Context context) {
        this(context, null);
    }

    public JsonItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JsonItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
        LayoutInflater.from(mContext).inflate(R.layout.layout_json_item_view, this, true);

        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);
        mTvIcon = findViewById(R.id.tv_icon);
    }

    public void setTextSize(float textSizeDp) {
        if (textSizeDp < 10) {
            textSizeDp = 10;
        } else if (textSizeDp > 30) {
            textSizeDp = 30;
        }

        mTvLeft.setTextSize(textSizeDp);
        mTvRight.setTextSize(textSizeDp);
        mTvIcon.setTextSize(textSizeDp - 2);
    }

    public void setRightColor(int color) {
        mTvRight.setTextColor(color);
    }

    public void hideLeft() {
        mTvLeft.setVisibility(GONE);
    }

    public void showLeft(CharSequence text) {
        mTvLeft.setVisibility(VISIBLE);
        if (text != null) {
            mTvLeft.setText(text);
        }
    }

    public void hideRight() {
        mTvRight.setVisibility(GONE);
    }

    public void showRight(CharSequence text) {
        mTvRight.setVisibility(VISIBLE);
        if (text != null) {
            mTvRight.setText(text);
        }
    }

    public CharSequence getRightText() {
        return mTvRight.getText();
    }

    public void hideIcon() {
        mTvIcon.setVisibility(GONE);
    }

    public void showIcon(boolean isPlus) {
        mTvIcon.setVisibility(VISIBLE);
        mTvIcon.setText(getResources().getString(isPlus ? R.string.icon_plus : R.string.icon_minus));
    }

    public void setIconClickListener(OnClickListener listener) {
        mTvIcon.setOnClickListener(listener);
    }

    public void addViewNoInvalidate(View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = generateDefaultLayoutParams();
            if (params == null) {
                throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            }
        }
        addViewInLayout(child, -1, params);
    }
}
