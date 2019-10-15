package com.xacheliangroup.netline.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.yanzhenjie.album.util.AlbumUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

/**
 * author:yz
 * data: 2019/9/19,10:19
 */
public class MyRevice extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        try {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                return;
            }
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                String string = bundle.getString(JPushInterface.EXTRA_MESSAGE);
                System.exit(0);
            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            } else {
            }
            if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
