package com.sdaishu.block.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.WindowManager;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by dongmingcui on 2018/1/9.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeSetContentView();

        if (onContentView() != 0) {
            setContentView(onContentView());
        }

        ButterKnife.bind(this);

        initView();
        initData();
    }

    /**
     * 视图初始化前置操作
     */
    protected void beforeSetContentView() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }

    /**
     * 设置布局
     */
    @LayoutRes
    public abstract int onContentView();


    /**
     * View初始化
     */
    public abstract void initView();

    /**
     * 数据加载初始化
     */
    public abstract void initData();
}
