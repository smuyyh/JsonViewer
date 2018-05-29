package com.yuyh.jsonviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import com.yuyh.jsonviewer.library.JsonRecyclerView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private JsonRecyclerView mRecyclewView;
    private HorizontalScrollView mHScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHScrollView = findViewById(R.id.hsv);

        mRecyclewView = findViewById(R.id.rv_json);
        mRecyclewView.setScaleEnable(true);
        mRecyclewView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // 避免双指缩放与上下左右滑动冲突
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent event) {
                switch (event.getAction() & event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        mHScrollView.requestDisallowInterceptTouchEvent(false);
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        mHScrollView.requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        break;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is = null;
                try {
                    is = getAssets().open("demo.json");
                    int lenght = is.available();
                    byte[] buffer = new byte[lenght];
                    is.read(buffer);
                    final String result = new String(buffer, "utf8");
                    is.close();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRecyclewView.bindJson(result);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
