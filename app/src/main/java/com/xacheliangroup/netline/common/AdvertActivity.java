package com.xacheliangroup.netline.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.xacheliangroup.netline.CbbMainActivity;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseActivity;
import com.xacheliangroup.netline.common.glide.GlideUtils;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.log.CbbLogUtils;
import com.xacheliangroup.netline.common.mvp.UtilsPresenter;
import com.xacheliangroup.netline.common.mvp.bean.AdverBean;

import butterknife.BindView;

/**
 * author:yz
 * data: 2018/12/18,09:50
 */
public class AdvertActivity extends BaseActivity implements IActionListener.ViewAction{

    private CountDownTimer mCountDownTimer;
    UtilsPresenter mUtilsPresenter;
    @BindView(R.id.module_cbb_advert_act_img)
    ImageView mImg;
    @BindView(R.id.module_cbb_advert_act_text)
    TextView mNumberTx;
    private int mWidth;
    private int mHeight;

    public static void launch(Context context, Activity activity){
        Intent intent = new Intent(context, AdvertActivity.class);
        context.startActivity(intent);
        if(activity!=null){
            activity.overridePendingTransition(R.anim.act_anim_in, R.anim.act_anim_out);
        }else {
            CbbLogUtils.debugLog("launch***AdvertActivity***isnull");
        }
    }

    @Override
    public void showInfoView(String type, Object obj) {
        switch (type) {
            case UtilsPresenter.TO_GET_ADVERT_DATA:
                if (obj != null && obj instanceof AdverBean) {
                    AdverBean adverBean = (AdverBean) obj;
                    GlideUtils.loadImageForWHForAdvert(getContext(),adverBean.getPic(),
                            mImg,mWidth,mHeight);
                }
                break;
        }
    }
    @Override
    protected int getContentViewId() {
        return R.layout.module_cbb_advert_activity;
    }

    @Override
    protected void onCreateInit() {

        mUtilsPresenter=new UtilsPresenter(getContext(),this);
        addPresenter(mUtilsPresenter);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        mWidth = wm.getDefaultDisplay().getWidth();
        mHeight = wm.getDefaultDisplay().getHeight();
        mUtilsPresenter.toGetAdvertData();
        mCountDownTimer = new CountDownTimer(3 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mNumberTx.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                CbbMainActivity.launch(AdvertActivity.this,AdvertActivity.this);
                finish();
            }
        }.start();
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
    public void toCancelTimer(){
        if(mCountDownTimer!=null){
            mCountDownTimer.cancel();
            mCountDownTimer=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toCancelTimer();
    }

}
