package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.checkTickets.download.CommonIntentService;
import com.xacheliangroup.netline.checkTickets.download.InstallUtil;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.mvp.UtilsModel;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineHomeActivity;
import com.xacheliangroup.netline.moduleNetLine.mvp.NetLinePresenter;
import com.xacheliangroup.netline.moduleNetLine.mvp.Utlis;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LoginBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUpdateBean;
import com.xacheliangroup.netline.utils.ProgressHelp;
import com.xacheliangroup.netline.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/9/2,09:11
 */
public class NetLineLoginFragment extends BaseFragment implements IActionListener.ViewAction {
    NetLinePresenter mNetLinePresenter;
    @BindView(R.id.module_nl_phone_et)
    EditText mPhoneEt;
    @BindView(R.id.module_nl_ps_et)
    EditText mPasswrod;
    @BindView(R.id.module_nl_title_num_tx)
    TextView mTx;
    @Override
    public void showInfoView(String type, Object obj) {
        ProgressHelp.dismissProgress();
        switch (type){
            case NetLinePresenter.TO_GET_PHONE_NUMBER:
                if(obj!=null&&obj instanceof LoginBean){
                    LoginBean loginBean= (LoginBean) obj;
                    toHome(loginBean);
                }else {
                    String errMessage= (String) obj;
                    ToastUtils.showToast(getContext(),errMessage);
                }
                break;
            case NetLinePresenter.TO_GET_NET_LINE_UPDATE_DATA:
                if (obj != null && obj instanceof NetLineUpdateBean) {
                    NetLineUpdateBean netLineUpdateBean = (NetLineUpdateBean) obj;
                    if (!TextUtils.equals(netLineUpdateBean.getEditioncode(), InstallUtil.getVersionCode(getContext()) + "")) {
                        CommonIntentService.startActionUpdate(getContext(), netLineUpdateBean.getUrl());
                    }
                }
                break;
        }
    }
    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_nl_fragment_login;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
        mTx.setText(Utlis.getImei(getActivity()));
        isLogin();
    }

    private void isLogin() {
        if(AppSharePreference.getInstance().getNetLineIsLogin()){
            ProgressHelp.showProgress(getContext());
            mNetLinePresenter.toLogin(AppSharePreference.getInstance().getNetLinePhoneNumber(),
                    AppSharePreference.getInstance().getNetLinePassWord(),
                    Utlis.getImei(getActivity()));
        }

    }

    @Override
    protected void initPresenter() {
        mNetLinePresenter=new NetLinePresenter(getContext(),this);
        addPresenter(mNetLinePresenter);
    }

    @Override
    protected void PresenterGetData() {
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toNetLineUpdate();
    }
    @OnClick(R.id.module_nl_login)
    public void toLogin(){
        ProgressHelp.showProgress(getContext());
        mNetLinePresenter.toLogin(mPhoneEt.getText().toString(),mPasswrod.getText().toString(),
                Utlis.getImei(getActivity()));
    }
    public void toHome(LoginBean loginBean){
        AppSharePreference.getInstance().setNetLineIsLogin(true);
        if(!TextUtils.isEmpty(mPhoneEt.getText().toString())&&
                !TextUtils.isEmpty(mPasswrod.getText().toString())){
            AppSharePreference.getInstance().setNetLinePhoneNumber(mPhoneEt.getText().toString());
            AppSharePreference.getInstance().setNetLinePassWord(mPasswrod.getText().toString());
        }

        NetLineHomeActivity.launch(getContext(),getActivity(),loginBean);
    }

}
