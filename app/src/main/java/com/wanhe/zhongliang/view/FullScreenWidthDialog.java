package com.wanhe.zhongliang.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;

/**
 * 宽度充满屏幕dialog
 */
public class FullScreenWidthDialog extends Dialog {
    private Context context;
    private Activity ac;
    private LayoutInflater inflater;

    protected FullScreenWidthDialog(Context context, boolean cancelable,
                                    OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        ac = (Activity) context;
        inflater = getLayoutInflater();
    }

    public FullScreenWidthDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
        ac = (Activity) context;
        inflater = getLayoutInflater();
    }

    public FullScreenWidthDialog(Context context) {
        super(context);
        this.context = context;
        ac = (Activity) context;
        inflater = getLayoutInflater();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(true);
        WindowManager windowManager = ac.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (display.getWidth()); // 设置宽度
        getWindow().setAttributes(lp);
    }
}
