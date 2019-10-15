package com.xacheliangroup.netline.moduleTest.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.google.gson.Gson;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.CbbApplication;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.http.okSocket.PulseData;
import com.xacheliangroup.netline.common.http.okSocket.TestSendData;
import com.xacheliangroup.netline.common.http.websocket.EchoWebSocketListener;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.common.log.LogUtils;
import com.xacheliangroup.netline.greenDao.DaoSession;
import com.xacheliangroup.netline.moduleTest.greenDao.User;
import com.xacheliangroup.netline.moduleTest.intf.PassOnInterface;
import com.xacheliangroup.netline.utils.ToastUtils;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.client.sdk.OkSocket;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.action.SocketActionAdapter;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * author:yz
 * data: 2019/8/8,16:45
 */
public class TestMainFragment extends BaseFragment {

    AMap mAMap;
    @BindView(R.id.maps2d)
    MapView mMapView;
    @BindView(R.id.zxingview)
    ZXingView mZXingView;
    private PassOnInterface mPassOnInterface;
    private DaoSession daoSession;

    boolean isBooleOpenFlashlight=false;
    private IConnectionManager manager;


    private long sendTime = 0L;
    // 发送心跳包
    private Handler mHandler = new Handler();
    // 每隔2秒发送一次心跳包，检测连接没有断开
    private static final long HEART_BEAT_RATE = 2 * 1000;
    private WebSocket mSocket;


    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_cbb_fragment_test_mian;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
//        initDaoData();
        initQrcode();
        initMap();
    }

    private void initMap() {
        if(mAMap==null){
            mAMap=mMapView.getMap();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mZXingView.changeToScanBarcodeStyle(); // 切换成扫描条码样式
        mZXingView.setType(BarcodeType.ONE_DIMENSION, null); // 只识别一维条码

        mZXingView.startCamera();//打开相机


        mZXingView.startSpotAndShowRect(); // 显示扫描框，并开始识别

//        mZXingView.showScanRect();//显示扫描框
//        mZXingView.startSpot();//开始识别二维码


    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        mZXingView.stopCamera();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mZXingView.onDestroy();
        super.onDestroy();
        if(mMapView!=null){
             mMapView.onDestroy();
        }
    }

    private void initQrcode() {
        mZXingView.setDelegate(new QRCodeView.Delegate() {
            @Override
            public void onScanQRCodeSuccess(String result) {
                ToastUtils.showToast(getContext(),result);
            }

            @Override
            public void onCameraAmbientBrightnessChanged(boolean isDark) {
                CbbLogUtils.debugLog(isDark+"----");
                if(isDark){
                    if(!isBooleOpenFlashlight){
                        mZXingView.openFlashlight();
                        isBooleOpenFlashlight=true;
                    }

                }
            }

            @Override
            public void onScanQRCodeOpenCameraError() {

            }
        });
    }

    private void initDaoData() {
        User user=new User(null,"name","23");
        daoSession = ((CbbApplication)getActivity().getApplication()).getDaoSession();
        daoSession.insertOrReplace(user);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void PresenterGetData() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            if(activity instanceof PassOnInterface){
                mPassOnInterface= (PassOnInterface) activity;
                CbbLogUtils.debugLog("mPassOnInterface activity");
            }else {
                throw new RuntimeException(activity.toString()+ " must implement PassonInterface");
            }
        }
    }

//    SDK API<23时，onAttach(Context)不执行，需要使用onAttach(Activity)。Fragment自身的Bug，v4的没有此问题
    @Override
    public void onAttach(Context context) {
        if(context instanceof PassOnInterface){
            mPassOnInterface = (PassOnInterface) context;
            CbbLogUtils.debugLog("mPassOnInterface context");
        }else {
            throw new RuntimeException(context.toString()+ " must implement PassonInterface");
        }
        super.onAttach(context);
    }
    @OnClick(R.id.main_test_tv)
    public void toBtnOnclick(){
        mPassOnInterface.passonVaule("你好");
        daoSession.insertOrReplace(new User(null,"yy","1111"));
        List<User> userLists= daoSession.loadAll(User.class);
        for (int i=0;i<userLists.size();i++){
            User user=userLists.get(i);
            CbbLogUtils.debugLog("user"+user.getId()+user.getName()+user.getAge());
        }
    }
    private PulseData mPulseData = new PulseData();
    @OnClick(R.id.socket_btn)
    public void socket(){
//连接参数设置(IP,端口号),这也是一个连接的唯一标识,不同连接,该参数中的两个值至少有其一不一样
        ConnectionInfo info = new ConnectionInfo("192.168.0.253", 9898);
//调用OkSocket,开启这次连接的通道,拿到通道Manager
        manager = OkSocket.open(info);

        OkSocketOptions options= manager.getOption();

        //设置自定义解析头
        OkSocketOptions.Builder okOptionsBuilder = new OkSocketOptions.Builder(options);
        okOptionsBuilder.setReaderProtocol(new IReaderProtocol() {
            @Override
            public int getHeaderLength() {
//        / *
//         * 返回不能为零或负数的报文头长度(字节数)。
//         * 您返回的值应符合服务器文档中的报文头的固定长度值(字节数),可能需要与后台同学商定
//                / *固定报文头的长度(字节数)* /
                return 64;
            }

            @Override
            public int getBodyLength(byte[] header, ByteOrder byteOrder) {
//     / *
//         * 体长也称为有效载荷长度，
//         * 该值应从作为函数输入参数的header中读取。
//         * 从报文头数据header中解析有效负载长度时，最好注意参数中的byteOrder。
//         * 我们强烈建议您使用java.nio.ByteBuffer来做到这一点。
//         * 你需要返回有效载荷的长度,并且返回的长度中不应该包含报文头的固定长度
//                        * /
                /*有效负载长度(字节数)，固定报文头长度(字节数)除外*/;
                return 64;
            }
        });
//将新的修改后的参配设置给连接管理器
//        manager.option(okOptionsBuilder.build());
//注册Socket行为监听器,SocketActionAdapter是回调的Simple类,其他回调方法请参阅类文档
        manager.registerReceiver(new SocketActionAdapter(){
            @Override
            public void onSocketConnectionSuccess(ConnectionInfo info, String action) {
                CbbLogUtils.debugLog("socket链接成功");
                OkSocket.open(info)
                        .send(new TestSendData());
                OkSocket.open(info)
                        .getPulseManager()
                        .setPulseSendable(mPulseData)//只需要设置一次,下一次可以直接调用pulse()
                        .pulse();//开始心跳,开始心跳后,心跳管理器会自动进行心跳触发
            }

            @Override
            public void onSocketReadResponse(ConnectionInfo info, String action, OriginalData data) {
                super.onSocketReadResponse(info, action, data);
                CbbLogUtils.debugLog("接受的数据"+data.getBodyBytes()+data.getHeadBytes());
                if(manager != null ){//是否是心跳返回包,需要解析服务器返回的数据才可知道
                    //喂狗操作
                    manager.getPulseManager().feed();
                }
            }
        });
//调用通道进行连接
        manager.connect();

    }

    @OnClick(R.id.web_socket_btn)
    public void webSocket(){
        setListener();
    }
    private void setListener() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(3, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(3, TimeUnit.SECONDS)//设置连接超时时间
                .build();
//        ws://192.168.0.253:8080/websocket/openid/565654
        Request request = new Request.Builder().url("ws://192.168.0.253:8080/websocket/"+"13683498647"+"/565654").build();
        EchoWebSocketListener socketListener = new EchoWebSocketListener(mSocket,getActivity(),mHandler);

        // 刚进入界面，就开启心跳检测
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (System.currentTimeMillis() - sendTime >= HEART_BEAT_RATE) {
//                    boolean isSuccess = mSocket.send("1");//发送一个空消息给服务器，通过发送消息的成功失败来判断长连接的连接状态
//                    if (!isSuccess) {//长连接已断开
//                        mHandler.removeCallbacks(this);
//                        mSocket.cancel();//取消掉以前的长连接
//                        CbbLogUtils.debugLog("长连接已断开");
//                    } else {//长连接处于连接状态
//                        CbbLogUtils.debugLog("长连接处于连接状态");
//                    }
//                    sendTime = System.currentTimeMillis();
//                }
            }
        }, HEART_BEAT_RATE);




        mOkHttpClient.newWebSocket(request, socketListener);
        mOkHttpClient.dispatcher().executorService().shutdown();

    }
    public  static String buildRequestParams(Object params){
        Gson gson=new Gson();
        String jsonStr=gson.toJson(params);
        return jsonStr;
    }


}
