package com.xacheliangroup.netline.moduleNetLine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.moduleNetLine.fragment.NetLineListFragment;
import com.xacheliangroup.netline.moduleNetLine.fragment.NetLinePersonFragment;

/**
 * author:yz
 * data: 2019/10/15,15:48
 */
public class NetLinePersonActivity extends BaseActivity {

    NetLinePersonFragment netLinePersonFragment;
    public static final String CAR_ID="CAR_ID";
    public static final String DIVER_ID="DIVER_ID";
    public static void launch(Context context, Activity activity, int cId, int dId){
        Intent intent = new Intent(context, NetLinePersonActivity.class);
        intent.putExtra(CAR_ID,cId);
        intent.putExtra(DIVER_ID,dId);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***NetLinePersonActivity***isnull");
        }
    }
    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_all_activity;
    }

    @Override
    protected void onCreateInit() {
        netLinePersonFragment=new NetLinePersonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,netLinePersonFragment).commit();

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
