package com.wanhe.zhongliang.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by yangqq on 2016/8/31.
 */
public abstract class BaseFragmentActivity extends FragmentActivity implements View.OnClickListener,IShowWidget{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView();
        setListener();
        initData();
    }
    /**
     * 1设置XML
     */
    public abstract void setContentView();

//    /**
//     * 2初始化布局View
//     */
//    public abstract void initView();

    /**
     * 3设置监听
     */
    public abstract void setListener();

    /**
     * 4逻辑处理
     */
    public abstract void initData();
}
