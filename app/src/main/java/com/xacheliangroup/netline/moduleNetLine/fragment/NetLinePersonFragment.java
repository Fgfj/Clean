package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineListActivity;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLinePersonActivity;
import com.xacheliangroup.netline.moduleNetLine.mvp.NetLinePresenter;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLinePersonBean;
import com.xacheliangroup.netline.utils.ProgressHelp;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/10/15,15:48
 */
public class NetLinePersonFragment extends BaseFragment implements IActionListener.ViewAction {

    @BindView(R.id.module_net_line_car_name_tx)
    TextView mNameTx;
    @BindView(R.id.module_net_line_car_num1_tx)
    TextView mNum1Tx;
    @BindView(R.id.module_net_line_car_num2_tx)
    TextView mNum2Tx;
    @BindView(R.id.module_net_line_car_num3_tx)
    TextView mNum3Tx;
    private NetLinePresenter mNetLinePresenter;

    private int mCId;
    private int mDId;
    private NetLinePersonBean mNetLinePersonBean;

    @Override
    public void showInfoView(String type, Object obj) {
        ProgressHelp.dismissProgress();
        switch (type){
            case NetLinePresenter.TO_GET_PERSON_DATA:
                if(obj!=null&&obj instanceof NetLinePersonBean){
                    mNetLinePersonBean = (NetLinePersonBean) obj;
                    setView(mNetLinePersonBean);
                }
                break;
        }
    }

    private void setView(NetLinePersonBean netLinePersonBean) {
        mNameTx.setText(netLinePersonBean.getDrivername());
        mNum1Tx.setText(netLinePersonBean.getMonthnum()+"");
        mNum2Tx.setText(netLinePersonBean.getFareAdjustmentnum()+"");
        mNum3Tx.setText(netLinePersonBean.getDaynum()+"");
    }

    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_netline_fragment_person;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
        getData();
    }

    private void getData() {
        Intent intent = getActivity().getIntent();
        if (intent!=null){
            mCId = intent.getIntExtra(NetLinePersonActivity.CAR_ID,-1);
            mDId = intent.getIntExtra(NetLinePersonActivity.DIVER_ID,-1);
            ProgressHelp.showProgress(getContext());
            mNetLinePresenter.toGetPersonData(mDId+"");
        }
    }

    @Override
    protected void initPresenter() {
        mNetLinePresenter=new NetLinePresenter(getContext(),this);
        addPresenter(mNetLinePresenter);
    }

    @Override
    protected void PresenterGetData() {
         }
    @OnClick(R.id.module_nl_person_back_img)
    public void toBack(){
      getActivity().finish();
    }
    @OnClick(R.id.module_netline_car_his_ly)
    public void toGetCarHis(){
        NetLineListActivity.launch(getContext(), getActivity(),mCId,mDId);

    }
    @OnClick(R.id.module_net_line_call_phone_ly)
    public void toCallPhone(){
        callPhone(mNetLinePersonBean.getServiceMobile());
    }
    private void callPhone(String phoneNumber) {
        Intent intent = new Intent();
        //设置拨打电话的动作
        intent.setAction(Intent.ACTION_CALL);
        //设置拨打电话的号码
        intent.setData(Uri.parse("tel:" + phoneNumber));
        //开启打电话的意图
        startActivity(intent);

    }
}
