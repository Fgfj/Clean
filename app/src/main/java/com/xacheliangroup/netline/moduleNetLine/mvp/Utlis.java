package com.xacheliangroup.netline.moduleNetLine.mvp;

import android.app.Activity;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * author:yz
 * data: 2019/9/24,14:23
 */
public class Utlis {
    public static String getImei(Activity activity){
        TelephonyManager TelephonyMgr =(TelephonyManager)activity.getSystemService(TELEPHONY_SERVICE);//need user permission
        String imei = TelephonyMgr.getDeviceId();
        return imei;
    }
}
