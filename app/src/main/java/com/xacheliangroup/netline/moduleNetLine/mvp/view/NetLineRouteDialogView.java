package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.base.holder.ViewSugar;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineCarListBean;

import butterknife.BindView;

/**
 * author:yz
 * data: 2019/9/3,18:03
 */
public class NetLineRouteDialogView extends ViewSugar {
    @BindView(R.id.route_start_station_tx)
    TextView mStartTx;
    @BindView(R.id.route_end_station_tx)
    TextView mEndTx;
    public static ViewSugar getInstance(Context context,ViewGroup parent){
        return new NetLineRouteDialogView(context,parent);
    }
    public NetLineRouteDialogView(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module_nl_line_route_list_dailog_item;
    }

    @Override
    public <T extends BaseBean> void bind(T obj) {
        if(obj!=null&&obj instanceof NetLineCarListBean){
            NetLineCarListBean netLineCarListBean= (NetLineCarListBean) obj;
            mStartTx.setText(netLineCarListBean.getStartcity());
            mEndTx.setText(netLineCarListBean.getEndcity());
        }
    }
}
