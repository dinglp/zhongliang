package com.wanhe.zhongliang.base;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.wanhe.zhongliang.R;
import com.zhy.autolayout.AutoLayoutActivity;
/**
 * Created by yangqq on 2016/8/29.
 */
public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener,IShowWidget {
    private Dialog dialog;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        AppManager.getAppManager().addActivity(this);
        setContentView();
        initView();
        initData();
    }

    /**
     * 1设置XML
     */
    public abstract void setContentView();

    /**
     * 2初始化布局View
     */
    public abstract void initView();

    /**
     * 3数据逻辑处理
     */
    public abstract void initData();

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showNetError() {
        showToast("网络连接错误！");
    }

    @Override
    public void showParseError() {
        showToast("json解析错误");
    }


    public Dialog getDialog() {
        if (dialog == null) {
            dialog = new Dialog(this, R.style.Theme_dialog);
            dialog.setContentView(R.layout.load_animate_progressbar);
        }
        return dialog;
    }
    /**
     * 加载动画
     */
    public void showLoadAnimate() {
        getDialog().show();
    }

    /**
     * 停止动画
     */
    public void dismissLoadAnimate() {
        getDialog().dismiss();
        dialog = null;
    }
    /**
     * 页面跳转
     * @param classObj
     */
    public void open(Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.startActivity(intent);
    }
    /**
     * 传递参数的页面
     * @param classObj
     * @param params
     */
    public void open (Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(params);
        this.startActivity(intent);
    }
    /**
     * 页面跳转关闭当前页面
     * @param classObj
     */
    public void forward (Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();
    }
    /**
     * 传递参数的页面，跳转关闭当前页面
     * @param classObj
     * @param params
     */
    public void forward (Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(params);
        this.startActivity(intent);
        this.finish();
    }


}
