// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineListView_ViewBinding implements Unbinder {
  private NetLineListView target;

  @UiThread
  public NetLineListView_ViewBinding(NetLineListView target, View source) {
    this.target = target;

    target.mStartTx = Utils.findRequiredViewAsType(source, R.id.his_item_start_tx, "field 'mStartTx'", TextView.class);
    target.mEndTx = Utils.findRequiredViewAsType(source, R.id.his_item_end_tx, "field 'mEndTx'", TextView.class);
    target.mTimeTx = Utils.findRequiredViewAsType(source, R.id.his_item_time_tx, "field 'mTimeTx'", TextView.class);
    target.mHumanNumTx = Utils.findRequiredViewAsType(source, R.id.his_item_human_num_tx, "field 'mHumanNumTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineListView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mStartTx = null;
    target.mEndTx = null;
    target.mTimeTx = null;
    target.mHumanNumTx = null;
  }
}
