package com.xacheliangroup.netline.checkTickets.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.checkTickets.fragment.CTCheckFragment;
import com.xacheliangroup.netline.checkTickets.mvp.bean.CTCarListBean;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.log.CbbLogUtils;

/**
 * author:yz
 * data: 2019/5/15,17:47
 */
public class CTCheckActivity extends BaseActivity {

    CTCheckFragment ctCheckFragment;
    public static final String CAR_DETAIL_BEAN="CAR_DETAIL_BEAN";
    public static final String CAR_DETAIL_TYPE="CAR_DETAIL_TYPE";
    public static void launch(Context context, Activity activity, CTCarListBean.DataBean ctCarListBean,String type){
        Intent intent = new Intent(context, CTCheckActivity.class);
        intent.putExtra(CAR_DETAIL_BEAN,ctCarListBean);
        intent.putExtra(CAR_DETAIL_TYPE,type);
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
        ctCheckFragment=new CTCheckFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,ctCheckFragment).commit();

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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
