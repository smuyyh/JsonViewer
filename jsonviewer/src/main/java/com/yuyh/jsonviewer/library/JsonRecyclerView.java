package com.yuyh.jsonviewer.library;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

import com.yuyh.jsonviewer.library.adapter.BaseJsonViewerAdapter;
import com.yuyh.jsonviewer.library.adapter.JsonViewerAdapter;
import com.yuyh.jsonviewer.library.view.JsonItemView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by yuyuhang on 2017/11/30.
 */
public class JsonRecyclerView extends RecyclerView {

    private BaseJsonViewerAdapter mAdapter;

    public JsonRecyclerView(Context context) {
        this(context, null);
    }

    public JsonRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JsonRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initView();
    }

    private void initView() {
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void bindJson(String jsonStr) {
        mAdapter = null;
        mAdapter = new JsonViewerAdapter(jsonStr);
        setAdapter(mAdapter);
    }

    public void bindJson(JSONArray array) {
        mAdapter = null;
        mAdapter = new JsonViewerAdapter(array);
        setAdapter(mAdapter);
    }

    public void bindJson(JSONObject object) {
        mAdapter = null;
        mAdapter = new JsonViewerAdapter(object);
        setAdapter(mAdapter);
    }

    public void setKeyColor(int color) {
        BaseJsonViewerAdapter.KEY_COLOR = color;
    }

    public void setValueTextColor(int color) {
        BaseJsonViewerAdapter.TEXT_COLOR = color;
    }

    public void setValueNumberColor(int color) {
        BaseJsonViewerAdapter.NUMBER_COLOR = color;
    }

    public void setValueUrlColor(int color) {
        BaseJsonViewerAdapter.URL_COLOR = color;
    }

    public void setValueNullColor(int color) {
        BaseJsonViewerAdapter.NUMBER_COLOR = color;
    }

    public void setBracesColor(int color) {
        BaseJsonViewerAdapter.BRACES_COLOR = color;
    }

    public void setTextSize(int sizeDP) {
        JsonItemView.TEXT_SIZE_DP = sizeDP;
    }
}
