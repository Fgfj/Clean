package com.xacheliangroup.netline.checkTickets.fragment;

import android.view.View;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.checkTickets.activity.CTHomeActivity;
import com.xacheliangroup.netline.common.api.APIField;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.http.okhttp.RetrofitHelper;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.common.type.StationEnum;

import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/6/18,11:39
 */
public class CTChoiceStationFragment extends BaseFragment {
    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_ct_fragment_choice_station;
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
    @OnClick(R.id.module_ct_choice_station_cx_rl)
    public void toCx(){
        toStart(StationEnum.CX.getType());
    }
    @OnClick(R.id.module_ct_choice_station_fzc_rl)
    public void toFZC(){
        toStart(StationEnum.FZC.getType());
    }
    @OnClick(R.id.module_ct_choice_station_sfw_rl)
    public void toSFW(){
        toStart(StationEnum.SFW.getType());
    }
    @OnClick(R.id.module_ct_choice_station_yl_rl)
    public void toYl(){
        toStart(StationEnum.YL.getType());
    }

    public void toStart(String type){
        RetrofitHelper.setNull();
        AppSharePreference.getInstance().setAppHttpURl(type);
        APIField.getInstance().updateUrl();
        CTHomeActivity.launch(getContext(),getActivity());
    }
}
