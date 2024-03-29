package com.example.lyh.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lyh.myapplication.R;
import com.example.lyh.myapplication.bean.LoginResponse;
import com.example.lyh.myapplication.SpTools;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.bt_login)
    void login() {

        final String username = et_username.getText().toString();
        final String pwd = et_pwd.getText().toString();

        String url="http://10.10.16.37:8088/MobileShop/member/login2";

        OkHttpUtils
                .post()
                .url(url)
                .addParams("input", username)
                .addParams("password", pwd)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Gson gson = new Gson();
                        LoginResponse response2 = gson.fromJson(response, LoginResponse.class);
                        if(response2.getStatus()==0){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            SpTools.setBoolean("isLogin",true);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"登录失败："+response2.getMsg(),Toast.LENGTH_SHORT).show();
                        }


                    }
                });

    }

}