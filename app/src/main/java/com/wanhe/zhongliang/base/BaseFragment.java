package com.wanhe.zhongliang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangqq on 2016/8/29.
 */
public abstract  class BaseFragment  extends Fragment implements View.OnClickListener,IShowWidget{
    private BaseActivity mActivity;
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private boolean getStatus() {
        return (isAdded() && !isRemoving());
    }
    public BaseActivity getBaseActivity() {
        if (mActivity == null) {
            mActivity = (BaseActivity) getActivity();
        }
        return mActivity;
    }
    @Override
    public void showToast(int resId) {
        if (getStatus()) {
            BaseActivity activity = getBaseActivity();
            if (activity != null) {
                activity.showToast(resId);
            }
        }
    }


    @Override
    public void showToast(String msg) {
        if (getStatus()) {
            BaseActivity activity = getBaseActivity();
            if (activity != null) {
                activity.showToast(msg);
            }
        }
    }

    @Override
    public void showNetError() {
        if (getStatus()) {
            BaseActivity activity = getBaseActivity();
            if (activity != null) {
                activity.showNetError();
            }
        }
    }

    @Override
    public void showParseError() {
        if (getStatus()) {
            BaseActivity activity = getBaseActivity();
            if (activity != null) {
                activity.showParseError();
            }
        }
    }
}
