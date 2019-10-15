package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.base.holder.ViewSugar;
import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUserListBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/9/2,15:51
 */
public class NetLineUserListView extends ViewSugar {
    @BindView(R.id.module_nl_user_item_bg_ly)
    LinearLayout mBg;
    @BindView(R.id.module_nl_user_item_type_tx)
    TextView mTypeTx;
    @BindView(R.id.module_nl_user_item_number_tx)
    TextView mPersonNumberTx;
    @BindView(R.id.module_nl_user_item_start_tx)
    TextView mStartStationTx;
    @BindView(R.id.module_nl_user_item_end_tx)
    TextView mEndStationTx;
    @BindView(R.id.module_nl_user_item_name_tx)
    TextView mUserNameTx;
    @BindView(R.id.module_nl_user_item_station_tx)
    TextView mStationTx;
    @BindDrawable(R.drawable.module_nl_start_staion_gray_icon)
    Drawable mGray;
    @BindView(R.id.module_nl_start_station_img)
    ImageView mStartImg;
    @BindView(R.id.module_nl_end_station_img)
    ImageView mEndImg;
    @BindDrawable(R.drawable.module_nl_start_staion_icon)
    Drawable mCD;
    @BindDrawable(R.drawable.module_nl_end_staion_icon)
    Drawable mGD;
    @BindView(R.id.ic_call_black_img)
    ImageView mCallImg;
    @BindDrawable(R.drawable.ic_call_black_gray_24dp)
    Drawable mCallGray;
    @BindDrawable(R.drawable.ic_call_black_24dp)
    Drawable mCallBlack;
    @BindView(R.id.module_nl_user_item_send_over_tx)
    TextView mSendOverTx;
    private NetLineUserListBean.PalxSlorderListBean mPalxSlorderListBean;

    public static ViewSugar getInstance(Context context,ViewGroup parent){
        return new NetLineUserListView(context,parent);
    }

    public NetLineUserListView(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module_nl_user_list_recy_item;
    }

    @Override
    public <T extends BaseBean> void bind(T obj) {
        if(obj!=null&&obj instanceof NetLineUserListBean.PalxSlorderListBean){
            mPalxSlorderListBean = (NetLineUserListBean.PalxSlorderListBean) obj;
//            mUserNameTx.setText(mPalxSlorderListBean.getUsernames()+"");
            mStartStationTx.setText(mPalxSlorderListBean.getStaradress());
            mEndStationTx.setText(mPalxSlorderListBean.getEndaddress());
            mPersonNumberTx.setText(mPalxSlorderListBean.getPeoplenum()+"人");

            if(mPalxSlorderListBean.getStatus()==4|| mPalxSlorderListBean.getStatus()==5){
//1待支付，2已支付 3已派单 4已核销 5已评价 6已退款 7已删除 8，退款中
                mTypeTx.setText("已上车");
                mTypeTx.setTextColor(Color.parseColor("#9D9D9D"));


                mBg.setBackgroundColor(Color.parseColor("#EAEAEA"));
                mPersonNumberTx.setTextColor(Color.parseColor("#9D9D9D"));
                mStartStationTx.setTextColor(Color.parseColor("#9D9D9D"));
                mEndStationTx.setTextColor(Color.parseColor("#9D9D9D"));


                mStationTx.setVisibility(View.GONE);
                mStartImg.setImageDrawable(mGray);
                mEndImg.setImageDrawable(mGray);
                mCallImg.setImageDrawable(mCallGray);

                mSendOverTx.setVisibility(View.VISIBLE);

                if(mPalxSlorderListBean.getIfservice()==1){//是否已送达乘客 1 已送达 2 未送到
                    mSendOverTx.setTextColor(Color.parseColor("#9D9D9D"));
                }else {
                    mSendOverTx.setTextColor(Color.parseColor("#3F3F3F"));
                }
            }else {
                mTypeTx.setText("未上车");
                mTypeTx.setTextColor(Color.parseColor("#3F3F3F"));


                mBg.setBackgroundColor(Color.parseColor("#ffffff"));
                mPersonNumberTx.setTextColor(Color.parseColor("#3F3F3F"));
                mStartStationTx.setTextColor(Color.parseColor("#3F3F3F"));
                mEndStationTx.setTextColor(Color.parseColor("#3F3F3F"));

                mStationTx.setVisibility(View.VISIBLE);
                mStartImg.setImageDrawable(mCD);
                mEndImg.setImageDrawable(mGD);
                mCallImg.setImageDrawable(mCallBlack);
                if(TextUtils.isEmpty(mPalxSlorderListBean.getArrivetime())){//到达接送点
                    mStationTx.setTextColor(Color.parseColor("#3F3F3F"));
                }else {
                    mStationTx.setTextColor(Color.parseColor("#9D9D9D"));
                }
                mSendOverTx.setVisibility(View.INVISIBLE);
            }

            mStationTx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(mPalxSlorderListBean.getArrivetime())){
                        EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.UP_CAR,mPalxSlorderListBean));
                    }
                }
            });
            mSendOverTx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.TO_SEND_OVER,mPalxSlorderListBean));
                }
            });
        }
    }
    @OnClick(R.id.module_nl_user_item_phone_click_ly)
    public void  toCallPhone(){
        EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.CALL_PHONE,mPalxSlorderListBean.getOrdermobile()));
    }
}
