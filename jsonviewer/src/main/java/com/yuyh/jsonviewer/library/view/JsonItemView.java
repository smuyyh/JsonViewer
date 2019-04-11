package com.yuyh.jsonviewer.library.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuyh.jsonviewer.library.R;
import com.yuyh.jsonviewer.library.adapter.BaseJsonViewerAdapter;

/**
 * Created by yuyuhang on 2017/11/29.
 */
public class JsonItemView extends LinearLayout {

    public static int TEXT_SIZE_DP = 12;

    private Context mContext;

    private TextView mTvLeft, mTvRight;
    private ImageView mIvIcon;

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
        LayoutInflater.from(mContext).inflate(R.layout.jsonviewer_layout_item_view, this, true);

        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);
        mIvIcon = findViewById(R.id.iv_icon);
    }

    public void setTextSize(float textSizeDp) {
        if (textSizeDp < 12) {
            textSizeDp = 12;
        } else if (textSizeDp > 30) {
            textSizeDp = 30;
        }

        TEXT_SIZE_DP = (int) textSizeDp;

        mTvLeft.setTextSize(TEXT_SIZE_DP);
        mTvRight.setTextSize(TEXT_SIZE_DP);
        mTvRight.setTextColor(BaseJsonViewerAdapter.BRACES_COLOR);

        // align the vertically expand/collapse icon to the text
        int textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DP, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mIvIcon.getLayoutParams();
        int padding = dip2px(2);
        int paddingRight = padding + dip2px(1);
        layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.width = textSize + (paddingRight - padding);
        layoutParams.setMargins(0,0,0,0);

        mIvIcon.setPadding(padding, textSize / 5, paddingRight, 0);
        mIvIcon.setLayoutParams(layoutParams);
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
        mIvIcon.setVisibility(GONE);
    }

    public void showIcon(boolean isPlus) {
        mIvIcon.setVisibility(VISIBLE);
        mIvIcon.setImageResource(isPlus ? R.drawable.jsonviewer_plus : R.drawable.jsonviewer_minus);
        mIvIcon.setContentDescription(getResources().getString(isPlus ? R.string.jsonViewer_icon_plus : R.string.jsonViewer_icon_minus));
    }

    public void setIconClickListener(OnClickListener listener) {
        mIvIcon.setOnClickListener(listener);
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

    private int dip2px (float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
