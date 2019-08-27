package com.nandi.mydemo;

import android.view.View;
import android.widget.TextView;

import com.nandi.lqsbaselibrary.base.BaseActivity;

import org.w3c.dom.Text;


public class MainActivity extends BaseActivity {


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTitle("首页", R.color.white);
        setTitleBack(R.mipmap.ic_left);
        setTitleRight("qs", null);
        TextView viewById = findViewById(R.id.text);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void onRightClick() {
        showToast("qs");
    }
}
