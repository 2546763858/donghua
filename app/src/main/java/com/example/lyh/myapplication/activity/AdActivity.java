package com.example.lyh.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lyh.myapplication.R;

import java.time.Instant;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdActivity extends AppCompatActivity {
    @BindView(R.id.tv_ad)
    TextView tv_ad;

    @BindView(R.id.iv_image)
    ImageView imageView;

    @BindView(R.id.rl_root)
    RelativeLayout relativeLayout;

    @BindString(R.string.app_name)
    String str;

    @BindColor(R.color.colorAccent)
    int col;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @OnClick({R.id.tv_ad, R.id.iv_image})
    public void startMainActivity(View view) {
        if(view.getId()==R.id.tv_ad) {
            handler.removeCallbacks(task);
            Intent intent = new Intent(AdActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        //Butterknife绑定Activity
        ButterKnife.bind(this);


       Glide.with(AdActivity.this)
               .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574144732153&di=919cc1423ae57ca965c0b4d069a7aae0&imgtype=0&src=http%3A%2F%2Fpic1.cxtuku.com%2F00%2F10%2F22%2Fb8205f905e7e.jpg")
               .placeholder(R.mipmap.zhanweitu)
               .error(R.mipmap.error)
               .into(imageView);
                       tv_ad.setBackgroundColor(col);
        //tv_count.setText(getResources().getString(R.string.app_name));
        tv_ad.setText(str);


        count = 5;
        handler.postDelayed(task, 1000);

        //handler.handleMessage();
    }

    int count = 5;
    Runnable task = new Runnable() {
        @Override
        public void run() {
            tv_ad.setText("点击跳转 " + count);
            if (count > 0) {
                count--;
                handler.postDelayed(task, 1000);
            } else {
                Intent intent = new Intent(AdActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


}
