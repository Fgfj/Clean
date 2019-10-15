// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CheckTicketsUserListView_ViewBinding implements Unbinder {
  private CheckTicketsUserListView target;

  @UiThread
  public CheckTicketsUserListView_ViewBinding(CheckTicketsUserListView target, View source) {
    this.target = target;

    target.mBackTicketsRl = Utils.findRequiredViewAsType(source, R.id.item_checked_user_list_back_rl, "field 'mBackTicketsRl'", RelativeLayout.class);
    target.mTicketBillTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_bill_tx, "field 'mTicketBillTx'", TextView.class);
    target.mTicketMoneyTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_money_tx, "field 'mTicketMoneyTx'", TextView.class);
    target.mTicketTimeTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_time_tx, "field 'mTicketTimeTx'", TextView.class);
    target.mEndStationTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_end_station_tx, "field 'mEndStationTx'", TextView.class);
    target.mUserNameTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_user_name_tx, "field 'mUserNameTx'", TextView.class);
    target.mUserIdCardTx = Utils.findRequiredViewAsType(source, R.id.item_ticket_detail_user_id_tx, "field 'mUserIdCardTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CheckTicketsUserListView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackTicketsRl = null;
    target.mTicketBillTx = null;
    target.mTicketMoneyTx = null;
    target.mTicketTimeTx = null;
    target.mEndStationTx = null;
    target.mUserNameTx = null;
    target.mUserIdCardTx = null;
  }
}
