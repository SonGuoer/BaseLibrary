package com.nandi.lqsbaselibrary.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nandi.lqsbaselibrary.R;

public abstract class BaseHeadActivity extends AppCompatActivity {
    protected TextView titleTv;
    protected TextView titleRight;
    private ImageView titleBack;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_head);
        initBaseView();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View.inflate(this, layoutResID, (ViewGroup) findViewById(R.id.base_content));
    }

    /**
     * 调用后 才能得到titleTv否则为空
     */
    private void initBaseView() {
        toolbar = findViewById(R.id.base_tool_bar);
        setSupportActionBar(toolbar);
        titleTv = (TextView) findViewById(R.id.base_toolbar_title);
        titleBack = (ImageView) findViewById(R.id.base_nav_back);
        titleRight = (TextView) findViewById(R.id.base_nav_right);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        BaseTitleClick baseTitleClick = new BaseTitleClick();
        titleBack.setOnClickListener(baseTitleClick);
        titleRight.setOnClickListener(baseTitleClick);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 返回事件
     */
    public void back() {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setBackGround(Integer drawableRes) {
        if (drawableRes != null) {
            toolbar.setBackgroundColor(getResources().getColor(drawableRes));
        }
    }

    public void setTitleBack(Integer drawableRes) {
        if (titleBack == null) {
            return;
        }
        if (drawableRes == null) {
            titleBack.setVisibility(View.GONE);
        } else {
            titleBack.setVisibility(View.VISIBLE);
            titleBack.setImageResource(drawableRes);
        }
    }

    /**
     * 设置中间标题
     *
     * @param titleText
     */
    public void setTitle(String titleText) {
        if (titleText != null) {
            if (titleTv != null) {
                titleTv.setText(titleText);
            }
        }
    }

    /**
     * 设置中间标题
     *
     * @param titleText
     */
    public void setTitle(String titleText, Integer color) {
        if (titleText != null) {
            if (titleTv != null) {
                titleTv.setText(titleText);
                titleTv.setTextColor(getResources().getColor(color));
            }
        }
    }


    /**
     * @param drawableRes 设置右侧显示图片
     */
    public void setTitleRight(Integer drawableRes) {
        if (titleRight == null) {
            return;
        }
        if (drawableRes == null) {
            titleRight.setVisibility(View.GONE);
        } else {
            titleRight.setVisibility(View.VISIBLE);
            titleRight.setBackgroundResource(drawableRes);
            titleRight.setText("");
        }

    }

    /**
     * @param text        设置右侧的按钮，可显示文字
     * @param drawableRes 字体颜色
     */
    public void setTitleRight(String text, Integer drawableRes) {
        if (titleRight == null) {
            return;
        }
        if (text == null) {
            titleRight.setVisibility(View.GONE);
        } else {
            titleRight.setVisibility(View.VISIBLE);
            titleRight.setText(text);
            titleRight.setBackgroundResource(R.color.colorTransparents);
        }
        if (drawableRes != null) {
            titleRight.setTextColor(getResources().getColor(drawableRes));
        }
    }

    /**
     * 标题按钮的点击事件
     */
    private class BaseTitleClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.base_nav_back) {
                onBackClick();
            } else if (id == R.id.base_nav_right) {
                onRightClick();
            }
        }
    }

    /**
     * 标题中右边的部分，
     */
    protected abstract void onRightClick();

    /**
     * 返回按钮的点击事件
     */
    private void onBackClick() {
        back();
    }

}