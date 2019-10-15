// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleCarComment.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.pullrefresh.RefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarCommentFragment_ViewBinding implements Unbinder {
  private CarCommentFragment target;

  @UiThread
  public CarCommentFragment_ViewBinding(CarCommentFragment target, View source) {
    this.target = target;

    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_comment_rfl, "field 'mRefreshLayout'", RefreshLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_comment_rv, "field 'mRecyclerView'", RecyclerView.class);
    target.mStatusBarTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_comment_status_bar_tx, "field 'mStatusBarTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CarCommentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRefreshLayout = null;
    target.mRecyclerView = null;
    target.mStatusBarTx = null;
  }
}
