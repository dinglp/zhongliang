package com.wanhe.zhongliang.base;

/**
 * Created by Julian on 2015/8/28.
 */

public interface IShowWidget {

    void showToast(int resId);



    void showToast(String msg);


    void showNetError();


    void showParseError();


}



