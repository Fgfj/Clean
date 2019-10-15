package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.base.holder.ViewSugar;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LockSeatBean;

import butterknife.BindDrawable;
import butterknife.BindView;

/**
 * author:yz
 * data: 2019/9/26,10:13
 */
public class NetLineLockSeatView extends ViewSugar {
    @BindView(R.id.lock_seat_tx)
    TextView mTx;

    @BindDrawable(R.drawable.module_cbb_border_698eff_3)
    Drawable mBlue;
    @BindDrawable(R.drawable.module_cbb_border_666666_3)
    Drawable mGray;
    @BindView(R.id.lock_seat_rl)
    RelativeLayout mBg;
    public static ViewSugar getInstance(Context context,ViewGroup parent){
        return new NetLineLockSeatView(context,parent);
    }
    public NetLineLockSeatView(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module_net_line_item_lock_rv;
    }

    @Override
    public <T extends BaseBean> void bind(T obj) {
        if(obj!=null&&obj instanceof LockSeatBean){
            LockSeatBean lockSeatBean= (LockSeatBean) obj;
            mTx.setText(lockSeatBean.getSetNum());
            if(lockSeatBean.isShowBlue()){
                mTx.setTextColor(Color.parseColor("#698EFF"));
                mBg.setBackground(mBlue);
            }else {
                mTx.setTextColor(Color.parseColor("#666666"));
                mBg.setBackground(mGray);
            }
        }
    }
}
