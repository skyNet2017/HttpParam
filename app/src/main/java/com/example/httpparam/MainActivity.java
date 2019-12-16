package com.example.httpparam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import okhttp3.MultipartBody;
import okio.Buffer;

/**
 * Created on 2019/12/16
 * Author: bigwang
 * Description:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        findViewById(R.id.fab).setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Buffer buffer = new Buffer();
            Test test = new Test();
            StringBuilder builder = new StringBuilder();
            Log.d("test", "log params start");
            Log.d("test", test.getParams().toString());
            Log.d("test", "log params end\n");
            Log.d("test", "log parts start");

            try {
                for (MultipartBody.Part part : test.getParts()) {
                    builder.append("\n").append(part.headers());
                    buffer.clear();
                    part.body().writeTo(buffer);
                    builder.append(buffer.readUtf8());
                }

                Log.d("test", builder.toString());
                Log.d("test", "log parts end");
                Log.d("test", "log body start");
                buffer.clear();
                test.getBody().build().writeTo(buffer);
                Log.d("test", buffer.readUtf8());
                Log.d("test", "log body end");
//                Log.d("test", new KotlinTest().getParams().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
