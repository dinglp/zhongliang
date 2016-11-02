package com.wanhe.zhongliang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanhe.zhongliang.base.BaseActivity;
import com.wanhe.zhongliang.fragment.HomeFragment;
import com.wanhe.zhongliang.fragment.PersonFragment;
import com.wanhe.zhongliang.fragment.PublishFragment;
import com.wanhe.zhongliang.fragment.SquareFragment;
import com.wanhe.zhongliang.fragment.VideoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.ll_home)
    LinearLayout llHome;
    @Bind(R.id.ll_video)
    LinearLayout llVideo;
    @Bind(R.id.ll_publish)
    LinearLayout llPublish;
    @Bind(R.id.ll_square)
    LinearLayout llSquare;
    @Bind(R.id.ll_person)
    LinearLayout llPerson;
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.tv_home)
    TextView tvHome;
    @Bind(R.id.iv_video)
    ImageView ivVideo;
    @Bind(R.id.tv_video)
    TextView tvVideo;
    @Bind(R.id.iv_publish)
    ImageView ivPublish;
    @Bind(R.id.tv_publish)
    TextView tvPublish;
    @Bind(R.id.iv_square)
    ImageView ivSquare;
    @Bind(R.id.tv_square)
    TextView tvSquare;
    @Bind(R.id.iv_person)
    ImageView ivPerson;
    @Bind(R.id.tv_person)
    TextView tvPerson;
    private Fragment currentFragment;
    private HomeFragment homeFragment;
    private VideoFragment videoFragment;
    private PublishFragment publishFragment;
    private SquareFragment squareFragment;
    private PersonFragment personFragment;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        llHome.setOnClickListener(this);
        llVideo.setOnClickListener(this);
        llPublish.setOnClickListener(this);
        llSquare.setOnClickListener(this);
        llPerson.setOnClickListener(this);

        initTab();

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), homeFragment);
                // 设置底部tab变化
                ivHome.setImageResource(R.drawable.tab_home_select);
                ivVideo.setImageResource(R.drawable.tab_video);
                ivPublish.setBackgroundResource(R.drawable.tab_publish);
                ivSquare.setImageResource(R.drawable.tab_square);
                ivPerson.setImageResource(R.drawable.tab_person);
                break;
            case R.id.ll_video:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), videoFragment);
                // 设置底部tab变化
                ivHome.setImageResource(R.drawable.tab_home);
                ivVideo.setImageResource(R.drawable.tab_video_select);
                ivPublish.setBackgroundResource(R.drawable.tab_publish);
                ivSquare.setImageResource(R.drawable.tab_square);
                ivPerson.setImageResource(R.drawable.tab_person);
                break;
            case R.id.ll_publish:
                if (publishFragment == null) {
                    publishFragment = new PublishFragment();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), publishFragment);
                // 设置底部tab变化
                ivHome.setImageResource(R.drawable.tab_home);
                ivVideo.setImageResource(R.drawable.tab_video);
                ivPublish.setBackgroundResource(R.drawable.tab_publish);
                ivSquare.setImageResource(R.drawable.tab_square);
                ivPerson.setImageResource(R.drawable.tab_person);
                break;
            case R.id.ll_square:
                if (squareFragment == null) {
                    squareFragment = new SquareFragment();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), squareFragment);
                // 设置底部tab变化
                ivHome.setImageResource(R.drawable.tab_home);
                ivVideo.setImageResource(R.drawable.tab_video);
                ivPublish.setBackgroundResource(R.drawable.tab_publish);
                ivSquare.setImageResource(R.drawable.tab_square_select);
                ivPerson.setImageResource(R.drawable.tab_person);
                break;
            case R.id.ll_person:
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), personFragment);
                // 设置底部tab变化
                ivHome.setImageResource(R.drawable.tab_home);
                ivVideo.setImageResource(R.drawable.tab_video);
                ivPublish.setBackgroundResource(R.drawable.tab_publish);
                ivSquare.setImageResource(R.drawable.tab_square);
                ivPerson.setImageResource(R.drawable.tab_person_select);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    /**
     * 添加或者显示碎片
     *
     * @param transaction
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction,
                                   Fragment fragment) {
        if (currentFragment == fragment)
            return;

        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }

        currentFragment = fragment;
    }

    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        if (!homeFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, homeFragment).commit();
            // 记录当前Fragment
            currentFragment = homeFragment;
            // 设置底部tab变化
            ivHome.setImageResource(R.drawable.tab_home_select);
            ivVideo.setImageResource(R.drawable.tab_video);
            ivPublish.setBackgroundResource(R.drawable.tab_publish);
            ivSquare.setImageResource(R.drawable.tab_square);
            ivPerson.setImageResource(R.drawable.tab_person);

        }

    }
}
