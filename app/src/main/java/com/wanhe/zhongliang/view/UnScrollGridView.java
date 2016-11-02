package com.wanhe.zhongliang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by yangqq on 2016/9/1.
 */
public class UnScrollGridView extends GridView {

    public UnScrollGridView(Context context) {
        super(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    public UnScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public UnScrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


//    /**通过重新dispatchTouchEvent方法来禁止滑动*/
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//// TODO Auto-generated method stub
//        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//
//            return true;/**只要简单改下这里就可以禁止Gridview进行滑动*/
//        }
//        return super.dispatchTouchEvent(ev);
//    }
}