package com.wanhe.zhongliang.utils;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * 手机配置信息类
 */
public class PhoneInfoUtils {
    private static final String PREFERENCES_INSTALL_appVersion = "install_appVersion";
    private static PhoneInfoUtils instance = null;
    /**
     * 国际移动用户识别码IMSI
     */
    private static String IMSI;
    /**
     * 设备识别码
     */
    public static String IMEI;
    /**
     * 运营商
     */
    public static String ICCID;
    /**
     * 手机型号
     */
    public static String mobileType;
    
    /**
     * mac地址
     */
    public static String mac;
    
    /**
     * 手机操作系统
     */
    public static String mobileSystem;
    
    
    /**
     * IP地址
     */
    public static String ip;

    /**
     * 本机号码
     */
    public static String tel;

    /**
     * 上网类型
     */
    public static String InternetType;

    /**
     * APP名称
     */
    public static String appName;

    /**
     * APP版本信息
     */
    public static String appVersion;
    
    
    /**
     * APP安装渠道
     */
    public static String appChannel;
    
    /**
     * APP打开时间
     */
    public static String appOpenTime;
    /**
     * 屏幕宽度
     */
    public static int screenWidth = 0;
    public static int screenHeight = 0;
    public static float screenDensity;
    public static int screenDensityDpi;

    private final static String USER_AGENT = "IFENGVIDEO7_Platform_Android";
   

    public static void init(Context context) {

        // 软件版本号！！！注意！！！顺序在publishId初始化之前
//        appVersion = softwareVersionInit(context);

        // 发布渠道号
//        DistributionInfo.getInstance(context);
//        publishid = PublishIdUtils.initPublishID(context);

        
//      IMSI = getIMSI(context);
        IMEI = getIMEI(context);
        
        ICCID= getSimName(context);
        
        mobileType=getPhoneModel();
        
        mac=getDeviceMac(context);
        // 系统版本号
        mobileSystem = "android_" + android.os.Build.VERSION.RELEASE;
        ip =getIpAddress();
        
        tel=getPhoneNumber(context);
        //获取网络类型
        InternetType=getInternetType();
        appName=getAppName(context);
        appChannel=getAppChannel(context);
        appOpenTime=getAppOpenTime();
        
//        UID = getDeviceID(context);

        DisplayMetrics metric = getDisplayMetrics(context);
        screenWidth = metric.widthPixels;
        screenHeight = metric.heightPixels;
        screenDensity = metric.density;
        screenDensityDpi = metric.densityDpi;
    }
    
    public synchronized static PhoneInfoUtils getInstance() {
        if (instance == null) {
            instance = new PhoneInfoUtils();
        }
        return instance;
    }
    //获取屏幕宽高
    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }
    
    /**
     * 获取IMSI
     *
     * @param context
     * @return
     */
    private static String getIMSI(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        try {
            if (telephonyManager != null) {
                return telephonyManager.getSubscriberId();
            }
        } catch (Exception e) {
        	 e.printStackTrace();
//            logger.error("getIMSI error ! {}", e.getMessage());
        }
        return "UnKnown";
    }
    
    /**
     * 获取IMEI
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return "";
    }
    /**
     * 获取运营商名称
     * @param context
     * @return
     */
    public static String getSimName(Context context) {
        TelephonyManager telManager = getTelephonyManager(context);
        if (telManager == null) {
            return "Unknown";
        }
        String operator = telManager.getSimOperator();
        if (TextUtils.isEmpty(operator)) {
            return "Unknown";
        }
        if (telManager.getSimState() != TelephonyManager.SIM_STATE_ABSENT && telManager.getSimState() != TelephonyManager.SIM_STATE_UNKNOWN) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
                return "中国移动";// 中国移动
            }
            if (operator.equals("46001")) {
                return "中国联通";// 中国联通
            }
            if (operator.equals("46003")) {
                return "中国电信";// 中国电信
            }
        }
        return "Unknown";
    }

    
    /**
     * 获取SIM卡运营商对应的编号
     * 0-Unkown,1-移动,2-联通,3-电信
     *
     * @param context
     * @return
     */
    public static int getSimCode(Context context) {
        TelephonyManager telManager = getTelephonyManager(context);
        if (telManager == null) {
            return 0;
        }
        String operator = telManager.getSimOperator();
        int operatorCode = 0;
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
                // 中国移动
                operatorCode = 1;
            } else if (operator.equals("46001")) {
                // 中国联通
                operatorCode = 2;
            } else if (operator.equals("46003")) {
                // 中国电信
                operatorCode = 3;
            } else if (!operator.equals("")) {
                operatorCode = 0;
            }

        }
        return operatorCode;
    }

   
    public static String getNetName(Context context) {
        TelephonyManager telManager = getTelephonyManager(context);
        if (telManager == null) {
            return "other";
        }
        String operator = telManager.getSimOperator();
        if (TextUtils.isEmpty(operator)) {
            return "other";// 其他
        }
        if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
            return "cmcc"; // 中国移动
        }
        if (operator.equals("46001")) {
            return "cucc"; // 中国联通
        }
        if (operator.equals("46003")) {
            return "ctcc";  // 中国电信
        }
        return "other";
    }
    
    
    /**
     * 获取手机型号
     * DeviceUtils.getPhoneModel()<BR>
      * <P>Author : chenbo </P>  
     * <P>Date : 2012-11-8 </P>
     * @return
     */
    public static String getPhoneModel(){
        return android.os.Build.MODEL;
    }
    
    /**
     * 设备mac地址
     *
     * @param context
     * @return
     */
    public static String getDeviceMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            return wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    /**
     * 获取ip地址
     *
     * @return
     */
    public static String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "";
        }
    }
    
    
    /**
     * 获取当前手机号码
     *
     * @return
     */
    public static String getPhoneNumber(Context context) {
        try {
        	 //获取本机号码  
        	TelephonyManager mTelephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

        	String strPhoneNum = mTelephonyManager.getLine1Number();
//        	TelephonyManager telephonyManager = getTelephonyManager(context);
//            String strPhoneNum = telephonyManager.getLine1Number();  
            return strPhoneNum;
        } catch (Exception e) {
        	e.printStackTrace();
            return "";
        }
    }
 
    /**
     * 上网类型
     * @param
     * @return 
     */
    public static String getInternetType(){
    	
    	
		return "3G";
    	
    }
    
    /**
     * APP名称
     * @param context
     * @return 
     */
    public static String getAppName(Context context){
    	        PackageManager packageManager = null; 
    	        ApplicationInfo applicationInfo = null; 
    	        try { 
    	            packageManager = context.getPackageManager(); 
    	            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0); 
    	        } catch (PackageManager.NameNotFoundException e) { 
    	            applicationInfo = null; 
    	        } 
    	        String applicationName =  
    	        (String) packageManager.getApplicationLabel(applicationInfo); 
    	        return applicationName; 
    	    } 
    /*
     * App版本号
     */
//    public static String softwareVersionInit(Context context) {
//        try {
//            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
//            String versionName = packageInfo.versionName;
//            String oldVersionName= SharedPreferenceUtil.getVersionCode(context);
//            if (TextUtils.isEmpty(oldVersionName)) {
//            	SharedPreferenceUtil.saveVersionCode(context, versionName);
//            }
//            return versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//            return "";
//        }
//    }
//
    /**
     * APP安装渠道
     * @param context
     * @return
     */
    public static String getAppChannel(Context context){
        String channelId = "-";
        try {
           String channelName = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("UMENG_CHANNEL");
         if (channelName.equals("ceshi")) {
        	 channelId="CN000";
		}else if (channelName.equals("wo")) {
        	 channelId="CN001";
		 }else if (channelName.equals("cn189store")) {
			 channelId="CN002";
		}else if (channelName.equals("xiaomi")) {
			channelId="CN003";
		}else if (channelName.equals("lenovomm")) {
			 channelId="CN004";
		}else if (channelName.equals("meizu")) {
			channelId="CN007";
		}else if (channelName.equals("anzhuoapk")) {
			 channelId="CN011";
		}else if (channelName.equals("cn360")) {
			channelId="CN013";
		}else if (channelName.equals("baidu")) {
			 channelId="CN014";
		}else if (channelName.equals("cn91")) {
			channelId="CN015";
		}else if (channelName.equals("taobao")) {
			 channelId="CN017";
		}else if (channelName.equals("sogou")) {
			channelId="CN019";
		}else if (channelName.equals("myapp")) {
			 channelId="CN020";
		}else if (channelName.equals("wandoujia")) {
			channelId="CN021";
		}else if (channelName.equals("hiapk")) {
			 channelId="CN022";
		}else if (channelName.equals("anzhi")) {
			channelId="CN023";
		}else if (channelName.equals("appchina")) {
			 channelId="CN024";
		}else if (channelName.equals("nduoa")) {
			channelId="CN025";
		}else if (channelName.equals("gfanstore")) {
			 channelId="CN026";
		}else if (channelName.equals("mumayi")) {
			channelId="CN027";
		}else if (channelName.equals("liqucn")) {
			 channelId="CN028";
		}else if (channelName.equals("anruan")) {
			channelId="CN029";
		}else if (channelName.equals("eoemarket")) {
			 channelId="CN030";
		}else if (channelName.equals("mopo")) {
			channelId="CN031";
		}else if (channelName.equals("sjapk")) {
			 channelId="CN032";
		}else if (channelName.equals("hicloud")) {
			channelId="CN046";
		}
        
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelId;
    }
    
    
    /**
     * APP打开时间
     * @param
     * @return
     */
    public static String getAppOpenTime(){
    	Date now=new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	String strDate = dateFormat.format(now);
		return strDate;
    }
    
    
    
    public static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metric);
        return metric;
    }

  
    public static int convertDipToPx(Context context, int dip) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dip + 0.5);
    }
  

    /**
     * 获取设备的语⾔言设置
     *
     * @return
     */
    public static String getPhoneLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 唯一区分用户;形式可能为第三方分配的uid,或者与mei项内容相同
     *
     * @param context
     * @return
     */
    public static String getUid(Context context) {


        return null;
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        try {
            return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }
   
    private static String getRe() {
        if (screenWidth > screenHeight) {
            return screenWidth + "*" + screenHeight;
        }
        return screenHeight + "*" + screenWidth;
    }

    /**
     * 获取系统ua
     *
     * @return
     */
    private static String uAinit() {
        String ua = null;
        try {
            ua = URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (Exception e) {
            ua = USER_AGENT;
        }
        return ua.toLowerCase(Locale.getDefault());
    }
    //获取当前屏幕大小
    public static String getScreen() {
        return screenHeight + "×" + screenWidth;
    }

}
