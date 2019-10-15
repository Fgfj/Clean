// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.mvp.view;

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

public class NetLineTicketListView_ViewBinding implements Unbinder {
  private NetLineTicketListView target;

  @UiThread
  public NetLineTicketListView_ViewBinding(NetLineTicketListView target, View source) {
    this.target = target;

    target.mUpCatTx = Utils.findRequiredViewAsType(source, R.id.module_nl_qr_up_car_tx, "field 'mUpCatTx'", TextView.class);
    target.mNameTx = Utils.findRequiredViewAsType(source, R.id.module_net_line_ticket_list_name_tx, "field 'mNameTx'", TextView.class);
    target.mIdTx = Utils.findRequiredViewAsType(source, R.id.module_net_line_ticket_list_id_tx, "field 'mIdTx'", TextView.class);
    target.mSubmitRl = Utils.findRequiredViewAsType(source, R.id.module_nl_qr_up_car_submit_rl, "field 'mSubmitRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineTicketListView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUpCatTx = null;
    target.mNameTx = null;
    target.mIdTx = null;
    target.mSubmitRl = null;
  }
}
