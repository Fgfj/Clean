// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderDetailMoneyView_ViewBinding implements Unbinder {
  private OrderDetailMoneyView target;

  @UiThread
  public OrderDetailMoneyView_ViewBinding(OrderDetailMoneyView target, View source) {
    this.target = target;

    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_item_money_order_detail_title_tx, "field 'mTitleTx'", TextView.class);
    target.mMoneyTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_item_money_order_detail_money_tx, "field 'mMoneyTx'", TextView.class);
    target.mLineTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_item_money_order_detail_line_tx, "field 'mLineTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderDetailMoneyView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitleTx = null;
    target.mMoneyTx = null;
    target.mLineTx = null;
  }
}
