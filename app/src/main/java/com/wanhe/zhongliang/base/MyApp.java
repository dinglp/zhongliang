package com.wanhe.zhongliang.base;
import android.app.Application;
import android.content.Context;

import com.zhy.autolayout.config.AutoLayoutConifg;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Created by yangqq on 2016/8/29.
 */
public class MyApp  extends Application {
    private static MyApp instance;
    public static Context applicationContext;
        @Override
        public void onCreate() {
            super.onCreate();
            applicationContext=this;
            instance=this;
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
                    //其他配置
                    .build();
            OkHttpUtils.initClient(okHttpClient);
            AutoLayoutConifg.getInstance().useDeviceSize();
        }
    public static MyApp getInstance() {
        return instance;
    }
}
