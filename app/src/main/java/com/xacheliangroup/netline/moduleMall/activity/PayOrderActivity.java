package com.xacheliangroup.netline.moduleMall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.moduleMall.fragment.PayOrderFragment;

/**
 * author:yz
 * data: 2019/2/22,11:26
 */
public class PayOrderActivity extends BaseActivity {
    PayOrderFragment mPayOrderFragment;
    public static void launch(Context context, Activity activity){
        Intent intent = new Intent(context, PayOrderActivity.class);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***PayOrderActivity***isnull");
        }
    }
    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_all_activity;
    }

    @Override
    protected void onCreateInit() {
        mPayOrderFragment=new PayOrderFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,mPayOrderFragment).commit();

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
