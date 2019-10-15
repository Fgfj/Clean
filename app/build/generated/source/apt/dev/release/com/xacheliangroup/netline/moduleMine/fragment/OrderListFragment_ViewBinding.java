// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderListFragment_ViewBinding implements Unbinder {
  private OrderListFragment target;

  private View view2131296603;

  @UiThread
  public OrderListFragment_ViewBinding(final OrderListFragment target, View source) {
    this.target = target;

    View view;
    target.mTableLayout = Utils.findRequiredViewAsType(source, R.id.module_mine_order_list_toolbar_tab_ly, "field 'mTableLayout'", TabLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_mine_order_list_rv, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_order_list_back_fl, "method 'toBack'");
    view2131296603 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTableLayout = null;
    target.mRecyclerView = null;

    view2131296603.setOnClickListener(null);
    view2131296603 = null;
  }
}
