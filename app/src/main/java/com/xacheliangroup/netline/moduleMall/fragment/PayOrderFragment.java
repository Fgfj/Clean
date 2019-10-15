package com.xacheliangroup.netline.moduleMall.fragment;

import android.view.View;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseFragment;

import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/2/22,11:27
 */
public class PayOrderFragment extends BaseFragment {
    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_cbb_fragment_pay_order;
    }

    @Override
    protected void onCreateViewInit(View parentView) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void PresenterGetData() {

    }
    @OnClick(R.id.module_cbb_pay_order_back_img)
    public void toBack(){
        getActivity().finish();
    }
}
