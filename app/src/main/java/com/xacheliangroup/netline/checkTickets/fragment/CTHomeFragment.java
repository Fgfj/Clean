package com.xacheliangroup.netline.checkTickets.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.checkTickets.activity.CTCarDetailActivity;
import com.xacheliangroup.netline.checkTickets.download.CommonIntentService;
import com.xacheliangroup.netline.checkTickets.download.InstallUtil;
import com.xacheliangroup.netline.checkTickets.mvp.CTPresenter;
import com.xacheliangroup.netline.checkTickets.mvp.bean.CTVersionBean;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.utils.ProgressHelp;
import com.xacheliangroup.netline.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/5/15,15:23
 */
public class CTHomeFragment extends BaseFragment implements IActionListener.ViewAction {



    @BindView(R.id.ct_fra_ed)
    EditText mEdt;

    private String inputIdCardNo;

    CTPresenter mCtPresenter;

    /**
     * 权限
     */
    private static final int REQUEST_CODE_PERMISSION = 0x01; // 权限请求码
    private boolean hasRequestPermission = false;
    private static final String[] PERMISSIONS = new String[] {
            Manifest.permission.VIBRATE,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECEIVE_BOOT_COMPLETED,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };
    @Override
    public void showInfoView(String type, Object obj) {
        ProgressHelp.dismissProgress();
        switch (type){
            case CTPresenter.TO_GET_APP_VERSION:
                if(obj!=null&&obj instanceof CTVersionBean){
                    CTVersionBean ctVersionBean= (CTVersionBean) obj;
                    if(!TextUtils.equals(ctVersionBean.getEditionCode(), InstallUtil.getVersionCode(getContext())+"")){
                        CommonIntentService.startActionUpdate(getContext(),ctVersionBean.getEditionUrl());
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
        return R.layout.module_ct_fragment_cthome;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
//        init(Constants.RFCard.DEVICE_INNER);获取身份证uid初始化
    }

    private void startNfcIdCard() {
    }

    @Override
    protected void initPresenter() {
        mCtPresenter=new CTPresenter(getContext(),this);
        addPresenter(mCtPresenter);
    }

    @Override
    protected void PresenterGetData() {
        ProgressHelp.showProgress(getContext());
        mCtPresenter.toGetVersion();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!hasRequestPermission) {
            hasRequestPermission = true;
            requestPermissions();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }




    @OnClick(R.id.module_ct_home_next_rl)
    public void toNext() {

////        searchCard();获取身份证uid
        inputIdCardNo = mEdt.getText().toString();
        if(TextUtils.equals(inputIdCardNo,"0609")){
            toCarDetailAct(inputIdCardNo);
        }else {
            if(TextUtils.isEmpty(inputIdCardNo)){
                ToastUtils.showToast(getContext(),"请输入正确的证件号码");
                return;
            }
            if(inputIdCardNo.length()==18&&isIDNumber(inputIdCardNo)){
                toCarDetailAct(inputIdCardNo);
            }else if(inputIdCardNo.length()==7||inputIdCardNo.length()==8){
                toCarDetailAct(inputIdCardNo);
            }else {
                ToastUtils.showToast(getContext(),"请输入正确的证件号码");
            }
        }


    }

    private void toCarDetailAct(String idCardNo) {
        CTCarDetailActivity.launch(getContext(), getActivity(),idCardNo);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void requestPermissions() {

            List<String> permissions = getNeedPermission();
            if (permissions != null && !permissions.isEmpty()) {
                int size = permissions.size();
                ActivityCompat.requestPermissions(getActivity(), (String[]) permissions.toArray(new String[size]), REQUEST_CODE_PERMISSION);
            }

    }

    private List<String> getNeedPermission() {
        List<String> permissions = null;
        for (String perm : PERMISSIONS) {
            int result = ContextCompat.checkSelfPermission(getContext(), perm);
            if (result != PackageManager.PERMISSION_GRANTED) {
                if (permissions == null) {
                    permissions = new ArrayList<>();
                }
                permissions.add(perm);
            }
        }
        return permissions;
    }
    @OnClick(R.id.module_ct_detail_back_img)
    public void toBack(){
        getActivity().finish();
    }
    private   boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾
        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }

        }
        return matches;
    }

}
