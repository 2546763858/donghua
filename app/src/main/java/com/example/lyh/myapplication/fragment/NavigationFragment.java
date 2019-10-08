package com.example.lyh.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lyh.myapplication.R;

public class NavigationFragment extends Fragment {
    private ImageView iv_home;
    private ImageView iv_categor;
    private ImageView iv_cart;
    private ImageView iv_personal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        iv_home = view.findViewById(R.id.iv_home);
        iv_categor = view.findViewById(R.id.iv_categor);
        iv_cart = view.findViewById(R.id.iv_cart);
        iv_personal = view.findViewById(R.id.iv_personal);
        resetImageResource(iv_home);
        showFragment(iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_home);
                resetImageResource(iv_home);


            }
        });
        iv_categor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_categor);
                resetImageResource(iv_categor);

            }
        });
        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetImageResource(iv_cart);
                showFragment(iv_cart);
            }
        });
        iv_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetImageResource(iv_personal);
                showFragment(iv_personal);
            }
        });
    }


    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private CatgorFragment catgorFragment;
    private PersonalFragment personalFragment;

    private void showFragment(ImageView icon) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (cartFragment != null) {
            transaction.hide(cartFragment);
        }
        if (catgorFragment != null) {
            transaction.hide(catgorFragment);
        }
        if (personalFragment != null) {
            transaction.hide(personalFragment);
        }
        if (icon.getId()==R.id.iv_home){
           if (homeFragment==null){
               homeFragment=new HomeFragment();
               transaction.add(R.id.ta_tag,homeFragment);
           }else {
               transaction.show(homeFragment);
           }
        }else if (icon.getId()==R.id.iv_categor){
            if (catgorFragment==null){
                catgorFragment=new CatgorFragment();
                transaction.add(R.id.ta_tag,catgorFragment);
            }else {
                transaction.show(catgorFragment);
            }
        }else if (icon.getId()==R.id.iv_cart){
            if (cartFragment==null){
                cartFragment=new CartFragment();
                transaction.add(R.id.ta_tag,cartFragment);
            }else {
                transaction.show(cartFragment);
            }
        }else if (icon.getId()==R.id.iv_personal){
            if (personalFragment==null){
                personalFragment=new PersonalFragment();
                transaction.add(R.id.ta_tag,personalFragment);
            }else {
                transaction.show(personalFragment);
            }

        }
        transaction.commit();

    }

    private void resetImageResource(View icon) {
        iv_home.setImageResource(R.mipmap.tab_item_home_normal);
        iv_cart.setImageResource(R.mipmap.tab_item_cart_normal);
        iv_categor.setImageResource(R.mipmap.tab_item_category_normal);
        iv_personal.setImageResource(R.mipmap.tab_item_personal_normal);
        if (icon.getId() == R.id.iv_home) {
            iv_home.setImageResource(R.mipmap.tab_item_home_focus);
        } else if (icon.getId() == R.id.iv_categor) {
            iv_categor.setImageResource(R.mipmap.tab_item_category_focus);
        } else if (icon.getId() == R.id.iv_cart) {
            iv_cart.setImageResource(R.mipmap.tab_item_cart_focus);
        } else if (icon.getId() == R.id.iv_personal) {
            iv_personal.setImageResource(R.mipmap.tab_item_personal_focus);
        }

    }}

