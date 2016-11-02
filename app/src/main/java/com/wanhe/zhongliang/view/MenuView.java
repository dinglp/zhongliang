//package com.wanhe.wanxingren.view;
//import com.bm.findbaby.MainActivity;
//import com.bm.findbaby.R;
//import com.bm.findbaby.adapter.BabyEduAdapter;
//import com.bm.findbaby.adapter.HomeMenuAdapter;
//import com.bm.findbaby.adapter.PersonGridAdapter;
//import com.bm.findbaby.fragment.HomeFragment;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//public class MenuView extends PopupWindow implements OnClickListener {
//	private Bundle bundle;
//	private Context context;
//	private ListView lv_home_popmenu;
//	private ImageButton ib_left;
//	private View ll_home_menu;
//	private TextView tv_title;
//	public MenuView(final Context context) {
//		super(context);
//		this.context = context;
//		View contentView = LayoutInflater.from(context).inflate(R.layout.pop_home_menu, null);
//		ll_home_menu = (LinearLayout)contentView.findViewById(R.id.ll_home_menu);
//		ib_left = (ImageButton)contentView.findViewById(R.id.ib_left);
//		tv_title = (TextView)contentView.findViewById(R.id.tv_title);
//		tv_title.setText("切换宝贝");
//		lv_home_popmenu = (ListView)contentView.findViewById(R.id.lv_home_popmenu);
//		HomeMenuAdapter adapter=new HomeMenuAdapter(context);
//		lv_home_popmenu.setAdapter(adapter);
//		ib_left.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				hideMenu();
//				HomeFragment.menuView.dismiss();
//			}
//		});
//		setContentView(contentView);
//		setHeight(LayoutParams.WRAP_CONTENT);
//		setWidth(LayoutParams.MATCH_PARENT);
//		setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////		setFocusable(true);
//		setAnimationStyle(R.style.top_popup);
//	}
//
//	public void showMenu() {
//		ll_home_menu.setVisibility(View.VISIBLE);
//	}
//
//	public void hideMenu() {
//		ll_home_menu.setVisibility(View.GONE);
//	}
//
//	public void show(View parent) {
//		showAtLocation(parent, Gravity.TOP, 0, 0);
//	}
//
//	@Override
//	public void onClick(View v) {
////		Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
//	}
//}
