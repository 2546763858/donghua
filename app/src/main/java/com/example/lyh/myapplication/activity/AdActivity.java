package com.example.lyh.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lyh.myapplication.R;

import java.time.Instant;

public class AdActivity extends AppCompatActivity {
    TextView tv_ad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

       tv_ad = findViewById(R.id.tv_ad);

        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i=5;i>=0;i--){
                    SystemClock.sleep(1000);
                    final int count=i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_ad.setText("点击跳转"+count);
                        }
                    });

                }
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        Intent intent=new Intent(AdActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

});

            }
        }.start();

    }
}