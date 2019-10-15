package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.base.BaseRecycler.BaseRecyclerAdapter;
import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineCheckActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineQrCodeActivity;
import com.xacheliangroup.netline.moduleNetLine.mvp.NetLinePresenter;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.CheckTicketBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.TicketBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.TicketListBean;
import com.xacheliangroup.netline.utils.ProgressHelp;
import com.xacheliangroup.netline.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/9/3,21:43
 */
public class NetLineCheckFragment extends BaseFragment implements IActionListener.ViewAction {
    @BindView(R.id.module_nl_check_rv_num_tx)
    TextView mRvNumTx;
    @BindView(R.id.module_nl_check_rv_num_ly)
    LinearLayout mRvNumLy;
    @BindView(R.id.module_nl_check_rl)
    RelativeLayout mBottomCheckRl;
    @BindView(R.id.module_nl_check_top_fl)
    LinearLayout mTopUserInfoLy;
    BaseRecyclerAdapter<TicketListBean.TicketBean> mBaseRecyclerAdapter;
    @BindView(R.id.module_nl_check_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.module_nl_check_toolbar_top_fl)
    LinearLayout mBTitleLy;
    @BindView(R.id.module_nl_check_toolbar_num_fl)
    LinearLayout mBNumberLy;
    @BindView(R.id.module_nl_check_toolbar_num_tx)
    TextView mBNumberTx;
    NetLinePresenter mNetLinePresenter;
    @BindView(R.id.module_nl_check_name_tx)
    TextView mNameTx;
    @BindView(R.id.module_nl_check_phone_tx)
    TextView mNumberTx;
    @BindView(R.id.module_nl_check_id_tx)
    TextView mIdTx;
    @BindView(R.id.module_nl_check_time_tx)
    TextView mTimeTx;
    @BindView(R.id.module_nl_check_order_tx)
    TextView mOrderTx;
    @BindView(R.id.module_nl_check_start_tx)
    TextView mStartTx;
    @BindView(R.id.module_nl_check_end_tx)
    TextView mEndTx;
    @BindView(R.id.module_nl_check_start_time_tx)
    TextView mStartTimeTx;
    @BindView(R.id.module_nl_check_start_bz_tx)
    TextView mBzTx;
    private String mCode;
    private TicketBean mTicketBean;
    private String mOrderId;
    private int mType=1;//1二维码 2订单进来



    @Override
    public void showInfoView(String type, Object obj) {
        ProgressHelp.dismissProgress();
        switch (type) {
            case NetLinePresenter.TO_GET_TICKET_INFO:
                if (obj != null && obj instanceof TicketBean) {
                    mTicketBean = (TicketBean) obj;
                    setView(mTicketBean);
                }else {
                    ToastUtils.showToast(getContext(),"查无此票");
                }
                break;
            case NetLinePresenter.TO_CHECK:
                if (obj != null) {
                    if(mType==1){
                        toQrCodeAct();
                    }else {
                        ProgressHelp.showProgress(getContext());
                        toGetTicketListInfo(mOrderId);
                    }
                    EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.TO_CHECK_SUCCESS,null));
                }else {
                    ToastUtils.showToast(getContext(),"检票失败");
                }
                break;
            case NetLinePresenter.TO_GET_TICKET_LIST_DATA:
                if(obj!=null&&obj instanceof TicketListBean){
                    TicketListBean ticketListBean= (TicketListBean) obj;
                    changeViewForOrder(ticketListBean);
                    mBaseRecyclerAdapter.init(ticketListBean.getTicket());
                    mBaseRecyclerAdapter.notifyDataSetChanged();

                }
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getType()) {
            case Flag.NETLINE.SUBMIT_UP_CAR_FOR_TICKET_LIST:
                if (event.getObject() != null && event.getObject() instanceof TicketListBean.TicketBean) {
                    TicketListBean.TicketBean ticketBean= (TicketListBean.TicketBean) event.getObject();
                    ProgressHelp.showProgress(getContext());
                    mNetLinePresenter.toCheck(ticketBean.getTicketid()+"",AppSharePreference.getInstance().getRId());
                }
                break;
        }
    }
    private void changeViewForOrder(TicketListBean ticketListBean) {
        mTimeTx.setText(ticketListBean.getCreatetime());
        mOrderTx.setText(ticketListBean.getOrdernumber());
        mStartTx.setText(ticketListBean.getStaradress());
        mEndTx.setText(ticketListBean.getEndaddress());
        mStartTimeTx.setText("出发时间段： "+ticketListBean.getStartdate()+
                ticketListBean.getStarttimefirst()+"----"+ticketListBean.getStarttimesecond());
        mBzTx.setText(ticketListBean.getRemark());
        mRvNumTx.setText(ticketListBean.getTicket().size()+"人");
    }

    private void setView(TicketBean mTicketBean) {
        if(mTicketBean.getPalxslorder().getType()==4){// 已经核销了
            mBTitleLy.setVisibility(View.VISIBLE);
            mBNumberLy.setVisibility(View.VISIBLE);
            mBNumberTx.setText(mTicketBean.getPalxslorder().getPeoplenum()+"");
        }else {
            mBTitleLy.setVisibility(View.GONE);
            mBNumberLy.setVisibility(View.GONE);
        }

        mNameTx.setText(mTicketBean.getPalxslfare().getFarename());
        mNumberTx.setText(mTicketBean.getPalxslfare().getMobile());

        if(!TextUtils.isEmpty(mTicketBean.getPalxslfare().getIdcard())&&mTicketBean.getPalxslfare().getIdcard().length()>=18){
            String id=mTicketBean.getPalxslfare().getIdcard();
            mIdTx.setText("身份证号："+id.substring(0, 3) + "********" + id.substring(11));
        }else {
            mIdTx.setText(mTicketBean.getPalxslfare().getIdcard());
        }
        mTimeTx.setText(mTicketBean.getPalxslorder().getCreatetime());
        mOrderTx.setText(mTicketBean.getPalxslorder().getOrdernumber());
        mStartTx.setText(mTicketBean.getPalxslorder().getStaradress());
        mEndTx.setText(mTicketBean.getPalxslorder().getEndaddress());
        mStartTimeTx.setText("出发时间段： "+mTicketBean.getPalxslorder().getStartdate()+
                mTicketBean.getPalxslorder().getStarttimefirst()+"----"+mTicketBean.getPalxslorder().getStarttimesecond());
        mBzTx.setText(mTicketBean.getPalxslorder().getRemark());
    }

    private void toQrCodeAct() {
        NetLineQrCodeActivity.launch(getContext(), getActivity());
        getActivity().finish();
    }

    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_nl_fragment_check;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
        setEventBusAction();
        getData();
    }

    private void getData() {
        Intent intent = getActivity().getIntent();
        if (intent != null&&intent.hasExtra(NetLineCheckActivity.QR_CODE)) {
            mCode = intent.getStringExtra(NetLineCheckActivity.QR_CODE);
            mType=1;
            toGetTicketInfo(mCode);
        }
        if (intent != null&&intent.hasExtra(NetLineCheckActivity.ORDER_ID)) {
            mType=2;
            mOrderId = intent.getStringExtra(NetLineCheckActivity.ORDER_ID);
            toGetTicketListInfo(mOrderId);
        }
        changeView(mType);
    }

    private void changeView(int mType) {
        if(mType==1){
            mTopUserInfoLy.setVisibility(View.VISIBLE);
            mBottomCheckRl.setVisibility(View.VISIBLE);
        }else if(mType==2){
            mRecyclerView.setVisibility(View.VISIBLE);
            mRvNumLy.setVisibility(View.VISIBLE);
        }

    }

    private void toGetTicketListInfo(String mOrderId) {
        initRecyclerView();
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toGetTicketListDataForOrderId(mOrderId);
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBaseRecyclerAdapter = new BaseRecyclerAdapter<>(getContext());
        mRecyclerView.setAdapter(mBaseRecyclerAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    private void toGetTicketInfo(String mCode) {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toTicketInfo(mCode);
    }

    @Override
    protected void initPresenter() {
        mNetLinePresenter = new NetLinePresenter(getContext(), this);
        addPresenter(mNetLinePresenter);
    }

    @Override
    protected void PresenterGetData() {

    }

    @OnClick(R.id.module_nl_check_back_img)
    public void toBack() {
        getActivity().finish();
    }

    @OnClick(R.id.module_nl_check_rl)
    public void toCheck() {
        if(mTicketBean.getStatus()==1){
            ProgressHelp.showProgress(getContext());
            mNetLinePresenter.toCheck(mTicketBean.getTicketid() + "", AppSharePreference.getInstance().getRId());
        }else {
            ToastUtils.showToast(getContext(),"此票已经被核销");
        }

    }

}
