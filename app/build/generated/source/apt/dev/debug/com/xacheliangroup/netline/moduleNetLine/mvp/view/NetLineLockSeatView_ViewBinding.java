// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineLockSeatView_ViewBinding implements Unbinder {
  private NetLineLockSeatView target;

  @UiThread
  public NetLineLockSeatView_ViewBinding(NetLineLockSeatView target, View source) {
    this.target = target;

    target.mTx = Utils.findRequiredViewAsType(source, R.id.lock_seat_tx, "field 'mTx'", TextView.class);
    target.mBg = Utils.findRequiredViewAsType(source, R.id.lock_seat_rl, "field 'mBg'", RelativeLayout.class);

    Context context = source.getContext();
    target.mBlue = ContextCompat.getDrawable(context, R.drawable.module_cbb_border_698eff_3);
    target.mGray = ContextCompat.getDrawable(context, R.drawable.module_cbb_border_666666_3);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineLockSeatView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTx = null;
    target.mBg = null;
  }
}
