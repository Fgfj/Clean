package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.checkTickets.download.CommonIntentService;
import com.xacheliangroup.netline.checkTickets.download.InstallUtil;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.base.BaseRecycler.BaseRecyclerAdapter;
import com.xacheliangroup.netline.common.base.BaseRecycler.OnItemClickListener;
import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.common.glide.GlideUtils;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.http.websocket.EchoWebSocketListener;
import com.xacheliangroup.netline.common.http.websocket.WebSocketConnectListener;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineCheckActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineHomeActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineListActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineMapActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLinePersonActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineQrCodeActivity;
import com.xacheliangroup.netline.moduleNetLine.mvp.NetLinePresenter;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.CarStatusBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.ChangeCarTypeBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LockSeatBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LockSeatRepBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LoginBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineCarListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineCheckDiverTimeBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUpdateBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUserListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.PostCarBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.QrCodeBean;
import com.xacheliangroup.netline.utils.BitmapUtlis;
import com.xacheliangroup.netline.utils.DialogUtils;
import com.xacheliangroup.netline.utils.ProgressHelp;
import com.xacheliangroup.netline.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * author:yz
 * data: 2019/9/2,09:12
 */
public class NetLineHomeFragment extends BaseFragment implements IActionListener.ViewAction {
    String mTitleHintTx;
    @BindView(R.id.module_nl_home_top_title_tx)
    TextView mTopTitleTx;
    @BindView(R.id.module_nl_drawer_layout)
    DrawerLayout mDrawerLayout;
    NetLinePresenter mNetLinePresenter;
    @BindView(R.id.module_nl_driver_name_tx)
    TextView mDiverNameTx;
    @BindView(R.id.module_nl_driver_number_tx)
    TextView mDiverPhoneNumberTx;
    @BindView(R.id.module_nl_top_car_num_tx)
    TextView mCarNumberTx;
    @BindView(R.id.module_nl_top_car_human_num_tx)
    TextView mCarHumanNumberTx;
    @BindView(R.id.module_nl_top_car_type_num_tx)
    TextView mCarTypeTx;
    @BindView(R.id.module_nl_bind_ly)
    LinearLayout mBindLy;
    @BindView(R.id.module_nl_bind_over_ly)
    LinearLayout mBindOverLy;
    @BindView(R.id.module_nl_nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.module_nl_post_car_tx)
    TextView mUpCarTx;
    BaseRecyclerAdapter<NetLineUserListBean.PalxSlorderListBean> mBaseRecyclerAdapter;
    @BindView(R.id.module_nl_user_list_rcv)
    RecyclerView mRecyclerView;
    private LoginBean mLoginBean;

    private int mRId = -1;//运输记录Id
    private int mDId;

    private int mListSize =0;

    private boolean isBind=true;//是否绑定车辆
    private boolean isUpCar;//是否报班
    private LoginBean.CarsBean mNowCarsBean;
    private NetLineUserListBean mNetLineUserListBean;
    private Dialog mLineDialog;
    private RecyclerView mLineRecyclerView;
    private BaseRecyclerAdapter<NetLineCarListBean> mLineBaseRecyclerAdapter;
    private Dialog mInputCarNumDiyDialog;
    private Dialog mQrCodeDiyDialog;
    private ImageView mQrCodeImg;
    private Timer mTimer;

    private MediaPlayer mMediaPlayer;
    private MediaPlayer mMediaCancelPlayer;
    private Dialog mCheckDiverDialog;
    private TextView mCheckDialogDiverTx;
    private Dialog mLockDialog;
    private int mLockSeatNum;//已经占座位总数
    private int mLockIngSeatNum;//可以释放的座位数
    private int mVerSeatNum;//核销数量
    private TextView mLockDialogTitleTx;
    private LockSeatBean mOnClickSeatBean;//解锁占锁bean
    private TextView mDialogSureTitle;
    private Dialog mDialogSure;
    private String mBottomOnclickType="1";//1满员已出发 2全部送达 3取消报班

    @Override
    public void showInfoView(String type, Object obj) {
        ProgressHelp.dismissProgress();
        switch (type) {
            case NetLinePresenter.TO_GET_CAR_DETAIL:
                if (obj != null && obj instanceof LoginBean.CarsBean) {
                    LoginBean.CarsBean carsBean = (LoginBean.CarsBean) obj;
                    initView(carsBean);
                    setTopView(carsBean);
                } else {
                    ToastUtils.showToast(getContext(), "获取车辆信息失败");
                }
                break;
            case NetLinePresenter.TO_BIND_CAR:
                if (obj != null && obj instanceof LoginBean.CarsBean) {
                    LoginBean.CarsBean carsBean = (LoginBean.CarsBean) obj;
                    initView(carsBean);
                    setTopView(carsBean);
                } else {
                    ToastUtils.showToast(getContext(), (String)obj);
                }
                break;
            case NetLinePresenter.TO_GET_USER_LIST:
                if (obj != null && obj instanceof NetLineUserListBean) {
                    mNetLineUserListBean = (NetLineUserListBean) obj;

                    mLockSeatNum =mNetLineUserListBean.getBusnumber();
                    mVerSeatNum =mNetLineUserListBean.getVerifynumber();
                    mLockIngSeatNum=mNetLineUserListBean.getLocknumber();

                    if(mNetLineUserListBean.getPalxSlorderList().size()!=0&&mNetLineUserListBean.getPalxSlorderList().size()!=AppSharePreference.getInstance().getNetLineUserListSize()){
//                        boolean isSend = mSocket.send("isSocketConnectForHttp");
//                        if(!isSend){
//                            TaoastUtils.showToast(getContext(),"socket链接失败");
//                            mMediaPlayer.start();
//                        }else {
//                            ToastUtils.showToast(getContext(),"socket链接正常");
//                        }
                        mMediaPlayer.start();
                    }

                    mCarHumanNumberTx.setText(mNetLineUserListBean.getVerifynumber()+"/"+mNetLineUserListBean.getBusnumber());
                    mBaseRecyclerAdapter.init(mNetLineUserListBean.getPalxSlorderList());
                    mBaseRecyclerAdapter.notifyDataSetChanged();
                    AppSharePreference.getInstance().setNetLineUserListSize(mNetLineUserListBean.getPalxSlorderList().size());
                    if(mNetLineUserListBean.getPalxSlorderList().isEmpty()){
                        mRecyclerView.setVisibility(View.GONE);
                    }else {
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }
                } else {
                    ToastUtils.showToast(getContext(), "获取用户数据失败");
                }
                break;
            case NetLinePresenter.TO_GET_CAR_LINE_LIST:
                if (obj != null && obj instanceof List) {
                    List<NetLineCarListBean> lineCarListBeans = (List<NetLineCarListBean>) obj;
                    mLineBaseRecyclerAdapter.init(lineCarListBeans);
                    mLineBaseRecyclerAdapter.notifyDataSetChanged();
                    mLineDialog.show();
                    mLineBaseRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClicked(int position, Object obj) {
                            if (obj != null && obj instanceof NetLineCarListBean) {
                                NetLineCarListBean netLineCarListBean = (NetLineCarListBean) obj;
                                mTitleHintTx=netLineCarListBean.getLinename();
                                ProgressHelp.showProgress(getContext());
                                mNetLinePresenter.toPostCar(mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid(), netLineCarListBean.getLineid());
                                mLineDialog.dismiss();
                            }
                        }

                        @Override
                        public boolean onItemLongClicked(int position, Object obj) {
                            return false;
                        }
                    });


                } else {
                    ToastUtils.showToast(getContext(), "暂无线路数据");
                }
                break;
            case NetLinePresenter.TO_POST_CAR:
                if (obj != null && obj instanceof PostCarBean) {
                    PostCarBean mPostCarBean = (PostCarBean) obj;
                    mRId = mPostCarBean.getRecordid();
                    AppSharePreference.getInstance().setRId(mRId+"");
                    isUpCar = true;
                    mUpCarTx.setText("取消报班");
                    ToastUtils.showToast(getContext(), "报班成功");
                    mTopTitleTx.setText(mTitleHintTx);
                    AppSharePreference.getInstance().setNetLineName(mTitleHintTx);
                    toGetUserList();
                    toGetCarDetail();
                    initLocation();
                } else {
                    ToastUtils.showToast(getContext(), "报班失败");
                }
                break;
            case NetLinePresenter.TO_GO_ADN_SEND_OVER:
                if (obj != null && obj instanceof CarStatusBean) {
                    CarStatusBean carStatusBean = (CarStatusBean) obj;
//                    1,接单中2，已出发 3全部到达已完成，必填参数
                    switch (carStatusBean.getStatus()) {
                        case 2:
                            ToastUtils.showToast(getContext(), "出发成功");
                            toGetCarDetail();
                            break;
                        case 3:
                            ToastUtils.showToast(getContext(), "全部到达成功");
                            isUpCar=false;
                            toGetCarDetail();
                            toStopLocation();
                            ChangeCarMethod();
                            toGetUserList();
                            mTopTitleTx.setText("未报班");
                            break;
                    }
                } else {
                    ToastUtils.showToast(getContext(), (String) obj);
                }
                break;
            case NetLinePresenter.TO_CHANGE_CAR_TYPE:
                if (obj != null && obj instanceof ChangeCarTypeBean) {
                    ChangeCarTypeBean changeCarTypeBean = (ChangeCarTypeBean) obj;
                    switch (changeCarTypeBean.getTypes()) {
                        case 0:
                            ToastUtils.showToast(getContext(), "车辆报修中");
                            toGetCarDetail();
                            break;
                        case 5:
                            ToastUtils.showToast(getContext(), "车辆休息中");
                            toGetCarDetail();
                            break;
                        case 6:
                            toLogOut();
                            break;
                    }
                }else {
                    ToastUtils.showToast(getContext(),(String)obj);
                }
                break;
            case NetLinePresenter.TO_UP_CAR:
                ToastUtils.showToast(getContext(), "到达接送点");
                toGetUserList();
                break;
            case NetLinePresenter.TO_GET_QR_CODE:
                if (obj != null && obj instanceof QrCodeBean) {
                    QrCodeBean qrCodeBean = (QrCodeBean) obj;
                    CbbLogUtils.debugLog(qrCodeBean);
                    mQrCodeDiyDialog.show();
                    GlideUtils.toLoadBitmap(getContext(), BitmapUtlis.stringtoBitmap( qrCodeBean.getIcodes()), mQrCodeImg);
//                    getXQrCode(qrCodeBean.getAccesstoken());

                }
                break;
            case NetLinePresenter.TO_GET_NET_LINE_UPDATE_DATA:
                if (obj != null && obj instanceof NetLineUpdateBean) {
                    NetLineUpdateBean netLineUpdateBean = (NetLineUpdateBean) obj;
                    if (!TextUtils.equals(netLineUpdateBean.getEditioncode(), InstallUtil.getVersionCode(getContext()) + "")) {
                        CommonIntentService.startActionUpdate(getContext(), netLineUpdateBean.getUrl());
                    }
                }
                break;
            case NetLinePresenter.TO_UPDATE_LOCATION:
                if(obj!=null){
//                    ToastUtils.showToast(getContext(),"上传成功");
                }else {
                    ToastUtils.showToast(getContext(),"上传位置失败");
                }
                break;
            case NetLinePresenter.TO_CHECK_DIVER_TIME_DATA:
                if(obj!=null&& obj instanceof NetLineCheckDiverTimeBean){
                    NetLineCheckDiverTimeBean netLineCheckDiverTimeBea= (NetLineCheckDiverTimeBean) obj;
                    if(TextUtils.equals(netLineCheckDiverTimeBea.getBacktype(),"0")){
                        mNetLinePresenter.toSelectLineList();
                    }else {
                        mCheckDiverDialog.show();
                        mCheckDialogDiverTx.setText(netLineCheckDiverTimeBea.getMsg());
                    }
                }
                break;
            case NetLinePresenter.TO_LOCK_SEAT:
                if(obj!=null&&obj instanceof LockSeatRepBean){
                    LockSeatRepBean lockSeatRepBean= (LockSeatRepBean) obj;
                    toGetUserList();
                    ToastUtils.showToast(getContext(),"座位操作成");
                    mLockDialog.dismiss();
                    toGetQrCode(lockSeatRepBean.getNums()+"");
                }
                break;
            case NetLinePresenter.TO_SAFE_QUESTION_POST:
                if(obj!=null){
                    ToastUtils.showToast(getContext(),"紧急维修上报成功");
                    toGetCarDetail();
                }
                break;
            case NetLinePresenter.TO_SEND_OVER:
                if(obj!=null){
                    toGetUserList();
                }
                break;
            case NetLinePresenter.TO_CANCEL_LINE:
                if(obj!=null){
                    isUpCar = false;
                    mTopTitleTx.setText("未报班");
                    mUpCarTx.setText("未报班");
                    toGetCarDetail();
                }
                break;
        }

    }


    private void toLogOut() {
        AppSharePreference.getInstance().setNetLineUserListSize(0);
        AppSharePreference.getInstance().setNetLineIsLogin(false);
        ToastUtils.showToast(getContext(), "退出登录");
        getActivity().finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getType()) {
            case Flag.NETLINE.CALL_PHONE:
                if (event.getObject() != null && event.getObject() instanceof String) {
                    String phoneNumber = (String) event.getObject();
                    callPhone(phoneNumber);
                }
                break;
            case Flag.NETLINE.QR_CODE:
                if (event.getObject() != null && event.getObject() instanceof String) {
                    String code = (String) event.getObject();
                    toCheckQrCode(code);
                }
                break;
            case Flag.NETLINE.UP_CAR:
                if (event.getObject() != null && event.getObject() instanceof NetLineUserListBean.PalxSlorderListBean) {
                    NetLineUserListBean.PalxSlorderListBean palxSlorderListBean = (NetLineUserListBean.PalxSlorderListBean) event.getObject();
                    toUpCar(palxSlorderListBean);
                }
                break;
            case Flag.NETLINE.UPDATE_UP_CAR_SOCKET:
                mMediaPlayer.start();
                EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.UPDATE_MAP_LOCATION,null));
                if(isBind&&isUpCar&&mNowCarsBean.getStatus()==2){
                    mNetLinePresenter.toGetUserList(mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid());

                }
               toGetCarDetail();
                break;
            case Flag.NETLINE.UPDATE_UP_CAR_BACK_MONEY_SOCKET:
                mMediaCancelPlayer.start();
                if(isBind&&isUpCar&&mNowCarsBean.getStatus()==2){
                    mNetLinePresenter.toGetUserList(mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid());
                }
                toGetCarDetail();
                break;
            case Flag.NETLINE.SOCKET_CONNECT_SUCCESS:
                isSocketDown=false;
                break;
            case Flag.NETLINE.TO_CHECK_SUCCESS:
                toGetUserList();
                break;
            case Flag.NETLINE.TO_SEND_OVER:
                if (event.getObject() != null && event.getObject() instanceof NetLineUserListBean.PalxSlorderListBean) {
                    NetLineUserListBean.PalxSlorderListBean palxSlorderListBean = (NetLineUserListBean.PalxSlorderListBean) event.getObject();
                    ProgressHelp.showProgress(getContext());
                    mNetLinePresenter.toSendOver(palxSlorderListBean.getOrderid()+"");
                }
                break;
        }
    }

    private void toUpCar(NetLineUserListBean.PalxSlorderListBean palxSlorderListBean) {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toUpCar(palxSlorderListBean.getOrderid() + "");

    }

    private void toCheckQrCode(String code) {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toTicketInfo(code);
    }

    private void callPhone(String phoneNumber) {
        Intent intent = new Intent();
        //设置拨打电话的动作
        intent.setAction(Intent.ACTION_CALL);
        //设置拨打电话的号码
        intent.setData(Uri.parse("tel:" + phoneNumber));
        //开启打电话的意图
        startActivity(intent);

    }

    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_nl_fragment_home;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
        setEventBusAction();
        initRecyclerView();
        getData();
        initDialog();
        mMediaPlayer=MediaPlayer.create(getContext(),R.raw.notice);
        mMediaCancelPlayer=MediaPlayer.create(getContext(),R.raw.success);
//        状态 1空闲 2接乘客中 3满员 4已出发 5 休息 0报修中 6 退出登录 必填
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_list:
                        NetLinePersonActivity.launch(getContext(),getActivity(),mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid());
                        break;
                    case R.id.push_fix:
                        if (isBind&&!isUpCar) {
                            toChangeCarType("0");
                        } else {
                            ToastUtils.showToast(getContext(), "请先绑定车辆或者全部送达");
                        }

                        break;
                    case R.id.push_rest:
                        if (isBind&&!isUpCar) {
                            toChangeCarType("5");
                        } else {
                            ToastUtils.showToast(getContext(), "请先绑定车辆或者全部送达");
                        }
                        break;
                    case R.id.nav_logout:
                        if (isBind) {
                            toChangeCarType("6");

                        } else {
                            getActivity().finish();
                        }
                        break;
                    case R.id.safe_q_post:

                        ProgressHelp.showProgress(getContext());
                        mNetLinePresenter.toSafeQuestionPost(mNowCarsBean.getCarid()+"",mRId+"",mDId+"");
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView);
                return true;
            }
        });
        addSocket();
        initTimer();
    }
    private long sendTime = 0L;
    // 发送心跳包
    private Handler mHandler = new Handler();
    // 每隔2秒发送一次心跳包，检测连接没有断开
    private static final long HEART_BEAT_RATE = 2 * 1000;
    private WebSocket mSocket;
    private void addSocket() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(3, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(3, TimeUnit.SECONDS)//设置连接超时时间
                .build();
//        ws://192.168.0.253:8080/websocket/openid/565654
//        Request request = new Request.Builder().url("ws://192.168.0.253:8080/websocket/"+"13683498647"+"/2").build();
        Request request = new Request.Builder().url("ws://cjztc.sxpalx.com:21002/cjztc//websocket/"+AppSharePreference .getInstance().getNetLinePhoneNumber()+"/2").build();
        EchoWebSocketListener socketListener = new EchoWebSocketListener(mSocket, getActivity(), mHandler, new WebSocketConnectListener() {
            @Override
            public void connect() {
                if(mSocket!=null){
                    addSocketConnect();
                }
            }
        });
        mOkHttpClient.newWebSocket(request, socketListener);
        mOkHttpClient.dispatcher().executorService().shutdown();
    }
    private Timer mSocketConnectTimer;
    private boolean isSocketDown;
    private void addSocketConnect(){
        isSocketDown=true;
        mSocketConnectTimer=new Timer();
        TimerTask mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(isSocketDown){
                    CbbLogUtils.debugLog("进行重连中---");
                    addSocket();
                }else {
                    stopSocketTimer();
                }
            }
        };
        mSocketConnectTimer.schedule(mTimerTask,1000*30,2*60*1000);

    }
    private void initTimer() {
        mTimer = new Timer();
        TimerTask mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(isBind&&isUpCar&&mNowCarsBean.getStatus()==2){
                    mNetLinePresenter.toGetUserList(mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid());

                }
            }
        };
        mTimer.schedule(mTimerTask,1000,10*1000);
    }

    private void stopTimer(){
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }

    }
    private void stopSocketTimer(){
        if(mSocketConnectTimer!=null){
            mSocketConnectTimer.cancel();
            mSocketConnectTimer=null;
        }
    }
    private void initDialog() {
        View mDialogSureView = View.inflate(getContext(), R.layout.module_ct_dialog_back_check_sure, null);
        mDialogSure = DialogUtils.getDiyDialog(getActivity(), getContext(), mDialogSureView, Gravity.CENTER, 0.7f);

        mDialogSureTitle = mDialogSureView.findViewById(R.id.ct_dialog_back_check_title_tx);
        RelativeLayout mDialogSureSubmitRl=mDialogSureView.findViewById(R.id.ct_dialog_back_check_setup_app_submit);
        RelativeLayout mDialogSureCancelRl=mDialogSureView.findViewById(R.id.ct_dialog_back_check_cancel);
        mDialogSureCancelRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogSure.dismiss();
            }
        });
        mDialogSureSubmitRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isUpCar) {
                    if(TextUtils.equals(mBottomOnclickType,"1")){
                        toGoAndSendOver("2");
                    }else if(TextUtils.equals(mBottomOnclickType,"2")){
                        toGoAndSendOver("3");
                    }else {
                        ProgressHelp.showProgress(getContext());
                        mNetLinePresenter.toCancelLine(mRId+"");
                    }
                } else {
                    ToastUtils.showToast(getContext(), "需要先报班");
                }

                mDialogSure.dismiss();
            }
        });

        View mLineDialogView = View.inflate(getContext(), R.layout.module_nl_dialog_line_list, null);
        mLineDialog = DialogUtils.getDiyDialog(getActivity(), getContext(), mLineDialogView, Gravity.BOTTOM, 1f);
        mLineRecyclerView = mLineDialogView.findViewById(R.id.dialog_line_list_rl);

        mLineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mLineBaseRecyclerAdapter = new BaseRecyclerAdapter<>(getContext());
        mLineRecyclerView.setAdapter(mLineBaseRecyclerAdapter);
        mLineRecyclerView.setNestedScrollingEnabled(false);

        View mInputCarNumView = View.inflate(getContext(), R.layout.module_nl_dialog_input_car_num, null);
        mInputCarNumDiyDialog = DialogUtils.getDiyDialog(getActivity(), getContext(), mInputCarNumView, Gravity.CENTER, 0.7f);
        TextView mSubmitTx = mInputCarNumView.findViewById(R.id.dialog_nl_input_submit_tx);
        TextView mCancelTx = mInputCarNumView.findViewById(R.id.dialog_nl_input_cancel_tx);
        final EditText mCarNumberEt = mInputCarNumView.findViewById(R.id.dialog_nl_input_et);
        mSubmitTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressHelp.showProgress(getContext());
                mNetLinePresenter.toBindCar(mCarNumberEt.getText().toString(), mLoginBean.getDriver().getDriverid());
                mInputCarNumDiyDialog.dismiss();
            }
        });
        mCancelTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputCarNumDiyDialog.dismiss();
            }
        });

        View mQrCodeView = View.inflate(getContext(), R.layout.module_nl_qr_code_dialog, null);
        mQrCodeDiyDialog = DialogUtils.getDiyDialog(getActivity(), getContext(), mQrCodeView, Gravity.CENTER, 0.7f);
        mQrCodeImg = mQrCodeView.findViewById(R.id.module_nl_dialog_qr_code_img);

        View mCheckDiverView = View.inflate(getContext(), R.layout.module_netline_dialog_check_diver, null);
        mCheckDiverDialog = DialogUtils.getDiyDialog(getActivity(), getContext(), mCheckDiverView, Gravity.BOTTOM, 1f);
        mCheckDialogDiverTx = mCheckDiverView.findViewById(R.id.module_dialog_check_diver_tx);
        RelativeLayout btn=mCheckDiverView.findViewById(R.id.module_dialog_check_diver_rl);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCheckDiverDialog.dismiss();
            }
        });

        View mLockDialogView=View.inflate(getContext(),R.layout.module_cbb_dialog_lock_seat,null);
        mLockDialog = DialogUtils.getDiyDialog(getActivity(),getContext(),mLockDialogView, Gravity.BOTTOM,1f);

        mLockDialogTitleTx = mLockDialogView.findViewById(R.id.module_net_line_dialog_title_tx);
        RelativeLayout mDialogLockBtnRl= mLockDialogView.findViewById(R.id.module_net_line_dialog_lock_rl);
        RelativeLayout mDialogUnLockBtnRl=mLockDialogView.findViewById(R.id.module_net_line_dialog_un_lock_rl);
        RecyclerView mLockRecyclerView=mLockDialogView.findViewById(R.id.module_net_line_dialog_check_rv);
        mLockRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        final BaseRecyclerAdapter<LockSeatBean> mLockBaseRecyclerAdapter=new BaseRecyclerAdapter<>(getActivity());
        mLockRecyclerView.setAdapter(mLockBaseRecyclerAdapter);
        mLockRecyclerView.setNestedScrollingEnabled(false);
        final String[] a={"1","2","3","4","5","6","7","8"};
        mLockBaseRecyclerAdapter.init(LockSeatBean.getLockSeatBean(a));
        mLockBaseRecyclerAdapter.notifyDataSetChanged();
        mLockBaseRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(int position, Object obj) {
                mOnClickSeatBean= (LockSeatBean) obj;
                List<LockSeatBean> lockSeatBeans = LockSeatBean.setBlue(LockSeatBean.getLockSeatBean(a), position);
                mLockBaseRecyclerAdapter.init(lockSeatBeans);
                mLockBaseRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public boolean onItemLongClicked(int position, Object obj) {
                return false;
            }
        });
        mDialogLockBtnRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(mOnClickSeatBean.getSetNum())<=(8-mLockSeatNum)){
                    ProgressHelp.showProgress(getContext());
                    mNetLinePresenter.toLockSeat(mRId+"","1",mOnClickSeatBean.getSetNum());
                }else {
                    ToastUtils.showToast(getContext(),"只剩下座位数："+(8-mLockSeatNum));
                }
            }
        });
        mDialogUnLockBtnRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(mOnClickSeatBean.getSetNum())<=mLockIngSeatNum){
                    ProgressHelp.showProgress(getContext());
                    mNetLinePresenter.toLockSeat(mRId+"","2",mOnClickSeatBean.getSetNum());
                }else {
                    ToastUtils.showToast(getContext(),"被占座位数："+mLockIngSeatNum);
                }
            }
        });
    }

    public void toChangeCarType(String type) {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toChangeCarType(mNowCarsBean.getCarid(), type);
    }

    private void getData() {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            mLoginBean = (LoginBean) intent.getSerializableExtra(NetLineHomeActivity.LOGIN_BEAN);
            mRId = mLoginBean.getRecordid();
            mDId=mLoginBean.getDriver().getDriverid();
        }
        initView(mLoginBean.getCars());
        isUpCarMethod(mLoginBean);
    }

    private void isUpCarMethod(LoginBean mLoginBean) {
        if (mLoginBean.getRecordid() == -1) {
            isUpCar = false;
            mUpCarTx.setText("未报班");
        } else {
            isUpCar = true;
            mUpCarTx.setText("取消报班");
            mTopTitleTx.setText(AppSharePreference.getInstance().getNetLineName());
            initLocation();
            AppSharePreference.getInstance().setRId(mLoginBean.getRecordid()+"");
        }
    }
    private void ChangeCarMethod(){
        if(isUpCar){
            mUpCarTx.setText("取消报班");
        }else {
            mUpCarTx.setText("未报班");
        }
    }

    private void initView(LoginBean.CarsBean carsBean) {
        CbbLogUtils.debugLog(carsBean);
        mNowCarsBean = carsBean;
        changeType(mNowCarsBean);
//        if (carsBean.getBindtype() == 2) {//2已绑定
//            mBindOverLy.setVisibility(View.VISIBLE);
//            mBindLy.setVisibility(View.GONE);
//            isBind = true;
//        } else {//1：未绑定
//            mBindLy.setVisibility(View.VISIBLE);
//            mBindOverLy.setVisibility(View.GONE);
//            isBind = false;
//        }
        setTopView(mLoginBean.getCars());
        mDiverNameTx.setText(mLoginBean.getDriver().getRealname());
        mDiverPhoneNumberTx.setText(mLoginBean.getDriver().getMobile());
    }

    private void changeType(LoginBean.CarsBean mNowCarsBean) {
        Menu menu = mNavigationView.getMenu();
        MenuItem fixItem=menu.findItem(R.id.push_fix);
        MenuItem restItem=menu.findItem(R.id.push_rest);
        switch (mNowCarsBean.getStatus()) {//status 状态1空闲 2接乘客中 3满员  4已出发 5 休息  0报修中
            case 0:
                fixItem.setTitle("报修完毕");
                restItem.setTitle("休息");
                break;
            case 1:
                fixItem.setTitle("报修");
                restItem.setTitle("休息");
                break;
            case 2:
                fixItem.setTitle("报修");
                restItem.setTitle("休息");
                break;
            case 3:
                fixItem.setTitle("报修");
                restItem.setTitle("休息");
                break;
            case 4:
                fixItem.setTitle("报修");
                restItem.setTitle("休息");
                break;
            case 5:
                fixItem.setTitle("报修");
                restItem.setTitle("取消休息");
                break;
        }
    }

    public void setTopView(LoginBean.CarsBean carsBean) {
        mCarNumberTx.setText(carsBean.getCarnumber());
        switch (carsBean.getStatus()) {//status 状态1空闲 2接乘客中 3满员  4已出发 5 休息  0报修中
            case 0:
                mCarTypeTx.setText("报修中");
                break;
            case 1:
                mCarTypeTx.setText("空闲");

                break;
            case 2:
                mCarTypeTx.setText("接乘客中");
                toGetUserList();
//                1：普通班次，2：包车班次 -1 没报班
                if(carsBean.getXltypes()==2){
                    mCarTypeTx.append("(包车)");
                }
                break;
            case 3:
                mCarTypeTx.setText("满员");

                break;
            case 4:
                mCarTypeTx.setText("已出发 ");

                break;
            case 5:
                mCarTypeTx.setText("休息");

                break;
        }
    }

    public void toGetUserList() {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toGetUserList(mNowCarsBean.getCarid(), mLoginBean.getDriver().getDriverid());
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBaseRecyclerAdapter = new BaseRecyclerAdapter<>(getContext());
        mRecyclerView.setAdapter(mBaseRecyclerAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mBaseRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(int position, Object obj) {
                if(obj!=null&&obj instanceof NetLineUserListBean.PalxSlorderListBean){
                    NetLineUserListBean.PalxSlorderListBean  palxSlorderListBean= (NetLineUserListBean.PalxSlorderListBean) obj;
                    NetLineCheckActivity.launchForOrderId(getContext(),
                            getActivity(),palxSlorderListBean.getOrderid()+"");
                }
            }

            @Override
            public boolean onItemLongClicked(int position, Object obj) {
                return false;
            }
        });
    }

    @Override
    protected void initPresenter() {
        mNetLinePresenter = new NetLinePresenter(getContext(), this);
        addPresenter(mNetLinePresenter);
    }

    @Override
    protected void PresenterGetData() {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toNetLineUpdate();
    }

    @OnClick(R.id.module_nl_home_back_img)
    public void toBack() {
        mDrawerLayout.openDrawer(mNavigationView);
    }

    @OnClick(R.id.module_nl_qr_code_ly)
    public void toQrcode() {
        if (isUpCar) {
            NetLineQrCodeActivity.launch(getContext(), getActivity());
        } else {
            ToastUtils.showToast(getContext(), "需要先报班");
        }

    }

    @OnClick(R.id.module_nl_user_map_rl)
    public void toUserMap() {
        if (isUpCar) {
            if(mNetLineUserListBean==null){
                ToastUtils.showToast(getContext(),"线路获取失败，请退出登录");
                return;

            }
            if(mNetLineUserListBean.getRecordid()!=null){
                NetLineMapActivity.launch(getContext(), getActivity(), mNetLineUserListBean.getRecordid());
            }else {
                ToastUtils.showToast(getContext(),"请报班");
            }

        } else {
            ToastUtils.showToast(getContext(), "需要先报班");
        }
    }

    @OnClick(R.id.module_nl_bind_ly)
    public void toBind() {
        mInputCarNumDiyDialog.show();
    }

    @OnClick(R.id.module_nl_post_car_tx)
    public void toPostOnclick() {
        if (!isBind) {
            ToastUtils.showToast(getContext(), "请先绑定车辆");
            return;
        }
        if (!isUpCar) {
            ProgressHelp.showProgress(getContext());
            mNetLinePresenter.toCheckDiverData(mLoginBean.getDriver().getDriverid()+"",mLoginBean.getCars().getCarid()+"");
        } else {
            mDialogSureTitle.setText("确认取消报班？");
            mBottomOnclickType="3";
            mDialogSure.show();
        }

    }

    @OnClick(R.id.module_nl_go_tx)
    public void toCarGo() {
        mDialogSureTitle.setText("确认全部出发或者满员？");
        mBottomOnclickType="1";
        mDialogSure.show();

    }

    @OnClick(R.id.module_nl_send_over_tx)
    public void toCarSendOver() {
        mBottomOnclickType="2";
        mDialogSureTitle.setText("确认全部到达已完成？");
        mDialogSure.show();
    }

    //1,接单中2，已出发 3全部到达已完成，必填参数
    public void toGoAndSendOver(String type) {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toGoAndSendOver(mRId, type, mNowCarsBean.getCarid());
    }

    @OnClick(R.id.module_nl_update_ly)
    public void toUpdate() {
        if (isBind) {
            toGetUserList();
        } else {
            ToastUtils.showToast(getContext(), "请绑定车辆");
        }
    }

    public void toGetCarDetail() {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toGetCarDetail(mNowCarsBean.getCarid() + "");
    }

    public void toGetQrCode(String num) {
        ProgressHelp.showProgress(getContext());
        if(isUpCar){
            mNetLinePresenter.toQrCodeData(mRId+"",num+"");
        }else {
            ToastUtils.showToast(getContext(),"请先报班");
        }

    }

    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;

    public void initLocation() {
        mlocationClient = new AMapLocationClient(getContext());
//初始化定位参数
        mLocationOption = new AMapLocationClientOption();
//设置定位监听
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //定位成功回调信息，设置相关消息
//                        aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                        aMapLocation.getLatitude();//获取纬度
//                        aMapLocation.getLongitude();//获取经度
//                        aMapLocation.getAccuracy();//获取精度信息
                        mNetLinePresenter.toUpdateLocation(mNowCarsBean.getCarid()+"",
                                aMapLocation.getLatitude()+","+aMapLocation.getLongitude(),
                                aMapLocation.getAddress());
                        AppSharePreference.getInstance().setNetLineLocation(aMapLocation.getLatitude()+","+aMapLocation.getLongitude());
                        CbbLogUtils.debugLog(""+aMapLocation.getLatitude()+aMapLocation.getLongitude()+aMapLocation.getAddress());
                    } else {
                        //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    }
                }
            }
        });
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(1000*60);
//设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
// 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
// 在定位结束后，在合适的生命周期调用onDestroy()方法
// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//启动定位
        mlocationClient.startLocation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toStopLocation();
        stopSocketTimer();
        stopWebSocket();
//        stopTimer();
    }

    private void stopWebSocket() {
        if (mSocket != null) {
            mSocket.close(1000, null);
        }
    }

    public void toStopLocation(){
        if(mlocationClient!=null){
        mlocationClient.stopLocation();
        }
    }
    @OnClick(R.id.module_nl_qr_lock_rl)
    public void toLockSeat(){

        if(isUpCar){
            mLockDialog.show();
            mLockDialogTitleTx.setText("已经锁定座位数："+mLockSeatNum+" 可占座位数："+(8-mLockSeatNum)+" 可释放座位数："+mLockIngSeatNum);
        }else {
            ToastUtils.showToast(getContext(),"请先报班");
        }



    }
}
