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

public class OrderDetailTimeView_ViewBinding implements Unbinder {
  private OrderDetailTimeView target;

  @UiThread
  public OrderDetailTimeView_ViewBinding(OrderDetailTimeView target, View source) {
    this.target = target;

    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_time_title_tx, "field 'mTitleTx'", TextView.class);
    target.mLineTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_time_line_tx, "field 'mLineTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderDetailTimeView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitleTx = null;
    target.mLineTx = null;
  }
}
