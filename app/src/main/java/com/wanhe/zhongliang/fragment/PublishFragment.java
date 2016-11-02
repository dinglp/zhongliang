package com.wanhe.zhongliang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanhe.zhongliang.R;
import com.wanhe.zhongliang.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Marcle on 16/10/20.
 */
public class PublishFragment extends BaseFragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_publish, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onClick(View view) {

    }
}
