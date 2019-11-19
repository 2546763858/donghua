package com.example.lyh.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.example.lyh.myapplication.R;
import com.example.lyh.myapplication.SpTools;
import com.example.lyh.myapplication.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeFragment extends Fragment {

    @BindView(R.id.bt_login)Button button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        boolean isLogin = SpTools.getBoolean("isLogin", false);
        if (isLogin){
            button.setText("退出登录");
        }else {
            button.setText("登录");
        }
    }

    @OnClick(R.id.bt_login)
    void login(){

        boolean isLogin = SpTools.getBoolean("isLogin", false);
        if (isLogin){

            SpTools.setBoolean("isLogin",false);
            Toast.makeText(getActivity(),"退出登录成功",Toast.LENGTH_SHORT).show();
            onResume();
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }


    }
}
