package com.example.lyh.myapplication.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lyh.myapplication.R;

public class HomeFragment extends Fragment {
    private WebView  WebView ;
    private SwipeRefreshLayout refresh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        WebView  = view.findViewById(R.id.webview);
        refresh=view.findViewById(R.id.refresh);
        initView();
        return view;
    }

    private void initView(){
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(false);
                WebView.loadUrl("https://www.huawei.com/cn/");
            }
        });
        WebView.getSettings().setSupportZoom(true);
        WebView.getSettings().setJavaScriptEnabled(true);
     WebView.setWebViewClient(new WebViewClient(){
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url) {
             view.loadUrl(url);
             return true;
         }


     });
       WebView.loadUrl("https://www.huawei.com/cn/");
    }
}
