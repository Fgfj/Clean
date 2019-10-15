package com.xacheliangroup.netline.moduleMall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.moduleMall.fragment.MallCbbFragment;

/**
 * author:yz
 * data: 2018/12/14,13:51
 */
public class MallCbbActivity extends BaseActivity {
    MallCbbFragment mMallCbbFragment;
    public static void launch(Context context, Activity activity){
        Intent intent = new Intent(context, MallCbbActivity.class);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***ActActivity***isnull");
        }
    }
    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_all_activity;
    }

    @Override
    protected void onCreateInit() {
        mMallCbbFragment=new MallCbbFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,mMallCbbFragment).commit();

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
