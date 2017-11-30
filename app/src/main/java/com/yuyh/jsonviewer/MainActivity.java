package com.yuyh.jsonviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yuyh.jsonviewer.library.JsonRecyclerView;
import com.yuyh.jsonviewer.library.adapter.JsonViewerAdapter;
import com.yuyh.jsonviewer.library.utils.Utils;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private JsonRecyclerView mRecyclewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclewView = findViewById(R.id.rv_json);

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
                            Log.i("-----", Utils.jsonFormat(result));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
