package com.xacheliangroup.netline.moduleTest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.moduleTest.fragment.TestMainFragment;
import com.xacheliangroup.netline.moduleTest.intf.PassOnInterface;
import com.xacheliangroup.netline.utils.ToastUtils;

/**
 * author:yz
 * data: 2019/8/8,16:44
 */
public class TestMainActivity extends BaseActivity implements PassOnInterface {

    private TestMainFragment mTestMainFragment;

    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_all_activity;
    }

    @Override
    protected void onCreateInit() {
        mTestMainFragment = new TestMainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cbb_concern_report_container,mTestMainFragment).commit();
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
    public void passonVaule(String vaule) {
        ToastUtils.showToast(getContext(),vaule);
    }
}
