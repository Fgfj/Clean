package com.xacheliangroup.netline.moduleNetLine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.moduleNetLine.fragment.NetLineCheckFragment;

/**
 * author:yz
 * data: 2019/9/3,21:43
 */
public class NetLineCheckActivity extends BaseActivity {
    NetLineCheckFragment mNetLineCheckFragment;
    public static final String QR_CODE="QR_CODE";
    public static final String ORDER_ID="ORDER_ID";
    public static void launch(Context context, Activity activity,String code){
        Intent intent = new Intent(context, NetLineCheckActivity.class);
        intent.putExtra(QR_CODE,code);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***GoodsDetailActivity***isnull");
        }
    }
    public static void launchForOrderId(Context context, Activity activity,String orderId){
        Intent intent = new Intent(context, NetLineCheckActivity.class);
        intent.putExtra(ORDER_ID,orderId);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***GoodsDetailActivity***isnull");
        }
    }
    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_all_activity;
    }

    @Override
    protected void onCreateInit() {
        mNetLineCheckFragment=new NetLineCheckFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,mNetLineCheckFragment).commit();
    }

    @Override
    protected void onCreateRequestConnected() {

    }

    @Override
    protected void onCreateRequestNoConnected() {

    }

    @Override
    protected void setFullSreen() {

    }
}
