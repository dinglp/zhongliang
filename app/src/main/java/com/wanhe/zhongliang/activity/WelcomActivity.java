package com.wanhe.zhongliang.activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.wanhe.zhongliang.MainActivity;
import com.wanhe.zhongliang.R;
import com.wanhe.zhongliang.utils.SPUtil;
import com.wanhe.zhongliang.view.CubeTransformer;

public class WelcomActivity extends Activity implements OnClickListener {
	private ViewPager vp;
	private welViewPagerAdapter adapter;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView();
		initView();
		setListener();
		processLogic();
	}

	protected void setContentView() {
		setContentView(R.layout.activity_welcome);
		context = this;
	}

	protected void initView() {
		// TODO Auto-generated method stub
		vp = (ViewPager) findViewById(R.id.vp);
		vp.setPageTransformer(true, new CubeTransformer());
	}

	protected void setListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_jump:
			WelcomActivity.this.finish();
			startActivity(new Intent(WelcomActivity.this, MainActivity.class));
			break;
		default:
			break;
		}
	}

	protected void processLogic() {
		// TODO Auto-generated method stub
		// imgList = new ArrayList<Integer>();
		// imgList.add(R.drawable.hy01);
		// imgList.add(R.drawable.hy02);
		// imgList.add(R.drawable.hy03);
		// imgList.add(R.drawable.hy04);
		adapter = new welViewPagerAdapter();
		vp.setAdapter(adapter);
	}

	TextView tv_in;

	class welViewPagerAdapter extends PagerAdapter {

		private LayoutInflater inflater;

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			View view = (View) object;
			container.removeView(view);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			destroyItem(container, position, null);
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.item_welcome, null);
			ImageView iv = (ImageView) view.findViewById(R.id.iv);
			TextView tv_jump = (TextView) view.findViewById(R.id.tv_jump);
			tv_in = (TextView) view.findViewById(R.id.tv_in);
			tv_jump.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					goToMainPage();
				}

			});
			switch (position) {
			case 0:
				Glide.with(context).load(R.drawable.bg_ac).asBitmap().into(iv);
				break;
			case 1:
				Glide.with(context).load(R.drawable.bg_ac).asBitmap().into(iv);
				break;
			case 2:
				Glide.with(context).load(R.drawable.bg_ac).asBitmap().into(iv);
				tv_jump.setVisibility(View.GONE);
				tv_in.setVisibility(View.VISIBLE);
				tv_in.setOnClickListener(WelcomActivity.this);
				tv_in.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						goToMainPage();
					}
				});
				break;

			default:
				break;
			}
			container.addView(view);
			return view;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {

		}

		@Override
		public void finishUpdate(View arg0) {

		}
	}
	private void goToMainPage() {
		WelcomActivity.this.finish();
		startActivity(new Intent(WelcomActivity.this, MainActivity.class));
		SPUtil.put(this,"isfirstIn","no");
	}
}
