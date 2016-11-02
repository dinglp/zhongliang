package com.wanhe.zhongliang.base;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
/*
 * Author: Administrator Email:gdpancheng@gmail.com
 * Created Date:2015年1月4日
 * Copyright @ 2015 BU
 * Description: 类描述
 *
 * History:
 */
public abstract class BaseCommonAdapter<T> extends BaseAdapter {
	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;

	public BaseCommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		return mDatas==null?0:mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder = getViewHolder(position, convertView);
		convert(viewHolder, getItem(position));
		convert(viewHolder, getItem(position), position);
		return viewHolder.getConvertView();

	}

	public void convert(ViewHolder helper, T item) {

	}

	public void convert(ViewHolder helper, T item, int position) {

	}

	private ViewHolder getViewHolder(int position, View convertView) {
		return ViewHolder.get(this.mInflater, convertView, mItemLayoutId,
				position);
	}
}
