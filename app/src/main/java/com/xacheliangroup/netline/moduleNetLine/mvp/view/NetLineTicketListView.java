package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.base.holder.ViewSugar;
import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.TicketListBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

/**
 * author:yz
 * data: 2019/10/15,11:25
 */
public class NetLineTicketListView extends ViewSugar {
    @BindView(R.id.module_nl_qr_up_car_tx)
    TextView mUpCatTx;
    @BindView(R.id.module_net_line_ticket_list_name_tx)
    TextView mNameTx;
    @BindView(R.id.module_net_line_ticket_list_id_tx)
    TextView mIdTx;
    @BindView(R.id.module_nl_qr_up_car_submit_rl)
    RelativeLayout mSubmitRl;
    public static ViewSugar getInstance(Context context,ViewGroup parent){
        return new NetLineTicketListView(context,parent);
    }
    public NetLineTicketListView(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.module_net_line_item_ticket_rv;
    }

    @Override
    public <T extends BaseBean> void bind(T obj) {
        if(obj!=null&&obj instanceof TicketListBean.TicketBean){
            final TicketListBean.TicketBean ticketBean= (TicketListBean.TicketBean) obj;
            mNameTx.setText(ticketBean.getPalxslfare().getFarename()+"    "+ticketBean.getPalxslfare().getMobile());
            if(!TextUtils.isEmpty(ticketBean.getPalxslfare().getIdcard())&&ticketBean.getPalxslfare().getIdcard().length()>=18){
                String id=ticketBean.getPalxslfare().getIdcard();
                mIdTx.setText("身份证号："+id.substring(0, 3) + "********" + id.substring(11));
            }else {
                mIdTx.setText(ticketBean.getPalxslfare().getIdcard());
            }
//            0 待支付 1支付  2已核销  3已超时 4已退票
            if(ticketBean.getStatus()==2){
                mUpCatTx.setVisibility(View.VISIBLE);
                mSubmitRl.setVisibility(View.GONE);
            }else {
                mUpCatTx.setVisibility(View.GONE);
                mSubmitRl.setVisibility(View.VISIBLE);
            }
            mSubmitRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new MessageEvent(Flag.NETLINE.SUBMIT_UP_CAR_FOR_TICKET_LIST,ticketBean));
                }
            });
        }
    }
}
