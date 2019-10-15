package com.xacheliangroup.netline.moduleNetLine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.moduleNetLine.fragment.NetLineQrCodeFragment;

/**
 * author:yz
 * data: 2019/9/2,14:55
 */
public class NetLineQrCodeActivity extends BaseActivity {
    NetLineQrCodeFragment mNetLineQrCodeFragment;
    public static void launch(Context context, Activity activity){
        Intent intent = new Intent(context, NetLineQrCodeActivity.class);
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
        mNetLineQrCodeFragment=new NetLineQrCodeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,mNetLineQrCodeFragment).commit();

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
