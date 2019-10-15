package com.xacheliangroup.netline.common.http.websocket;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleNetLine.mvp.Utlis;
import com.xacheliangroup.netline.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import static com.xacheliangroup.netline.moduleTest.fragment.TestMainFragment.buildRequestParams;

/**
 * author:yz
 * data: 2019/9/12,11:00
 */
public class EchoWebSocketListener extends WebSocketListener {
    private WebSocket mSocket;
    private Activity activity;
    private Handler mHandler;
    private WebSocketConnectListener webSocketConnectListener;

    public EchoWebSocketListener(WebSocket mSocket, Activity activity, Handler mHandler, WebSocketConnectListener webSocketConnectListener) {
        this.mSocket = mSocket;
        this.activity = activity;
        this.mHandler = mHandler;
        this.webSocketConnectListener = webSocketConnectListener;
    }

    public EchoWebSocketListener(WebSocket mSocket, Activity activity, Handler mHandler) {
        this.mSocket = mSocket;
        this.activity = activity;
        this.mHandler = mHandler;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        mSocket = webSocket;
            String openid = "1";
//        连接成功后，发送登录信息
            String message = sendData();
            mSocket.send(message);
        output("连接成功！");


    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        super.onMessage(webSocket, bytes);
        output("receive bytes:" + bytes.hex());
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
//        核销：111111  代表成功
//        派单：222222  派单成功
        output("服务器端发送来的信息：" + text);
        EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.SOCKET_CONNECT_SUCCESS,null));
        if(TextUtils.equals(text,"222222")){
            EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.UPDATE_UP_CAR_SOCKET,null));
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ToastUtils.showToast(activity,"进行派单刷新");
                }
            });
        }
        if(TextUtils.equals(text,"888888")){
            EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.UPDATE_UP_CAR_BACK_MONEY_SOCKET,null));
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ToastUtils.showToast(activity,"有人退单");
                }
            });
        }
        // {"msg":"付款成功","amount":"null","code":"0","qrCode":"123456","data":"cn.pay.entity.QCPOrder@3de382a5","userId":"f"}

        // 这里自己用于测试断开连接：就直接在接收到服务器发送的消息后，然后断开连接，然后清除 handler，
        //具体可以根据自己实际情况断开连接，比如点击返回键页面关闭时，执行下边逻辑
        if (!TextUtils.isEmpty(text)) {
//            if (mSocket != null) {
//                mSocket.close(1000, null);
//            }
//            if (mHandler != null) {
//                mHandler.removeCallbacksAndMessages(null);
//                mHandler = null;
//            }
        }
            //收到服务器端发送来的信息后，每隔2秒发送一次心跳包
            final String message = sendHeart();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    boolean send = mSocket.send(message);
                    if(!send){
                        CbbLogUtils.debugLog("链接断了--"+send);
                        if(webSocketConnectListener!=null){
                            webSocketConnectListener.connect();
                        }

                    }
                    CbbLogUtils.debugLog("run---"+send);
                }
            },1000*30);
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
        output("closed:" + reason);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
        output("closing:" + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        output("failure:" + t.getMessage());

    }
    private void output(final String text) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Log.e("TAG" , "text: " + text) ;
                CbbLogUtils.debugLog("TAGtext"+text);
            }
        });
    }
    private int i;
    private String sendHeart() {
        String jsonHead="";
        i++;
        Map<String,Object> mapHead=new HashMap<>();
        mapHead.put("phone",AppSharePreference.getInstance().getNetLinePhoneNumber()) ;
        mapHead.put("i",i);
        jsonHead=buildRequestParams(mapHead);
        CbbLogUtils.debugLog("sendHeart"+jsonHead);
//        Log.e("TAG" , "sendHeart：" + jsonHead) ;
        return jsonHead ;
    }
    private String sendData() {
        String jsonHead="";
        Map<String,Object> mapHead=new HashMap<>();
        mapHead.put("name", "123456") ;
        jsonHead=buildRequestParams(mapHead);
//        Log.e("TAG" , "sendData: " + jsonHead) ;
        CbbLogUtils.debugLog("sendData"+jsonHead);
        return jsonHead ;
    }
}
