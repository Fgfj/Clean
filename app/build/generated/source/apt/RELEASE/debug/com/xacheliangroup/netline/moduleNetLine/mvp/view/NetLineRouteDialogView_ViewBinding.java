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

public class NetLineRouteDialogView_ViewBinding implements Unbinder {
  private NetLineRouteDialogView target;

  @UiThread
  public NetLineRouteDialogView_ViewBinding(NetLineRouteDialogView target, View source) {
    this.target = target;

    target.mStartTx = Utils.findRequiredViewAsType(source, R.id.route_start_station_tx, "field 'mStartTx'", TextView.class);
    target.mEndTx = Utils.findRequiredViewAsType(source, R.id.route_end_station_tx, "field 'mEndTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineRouteDialogView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mStartTx = null;
    target.mEndTx = null;
  }
}
