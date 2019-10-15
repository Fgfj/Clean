// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineListFragment_ViewBinding implements Unbinder {
  private NetLineListFragment target;

  private View view2131296744;

  private View view2131296794;

  @UiThread
  public NetLineListFragment_ViewBinding(final NetLineListFragment target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_nl_rcv, "field 'mRecyclerView'", RecyclerView.class);
    target.mDateTx = Utils.findRequiredViewAsType(source, R.id.module_his_date_tx, "field 'mDateTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_back_img, "method 'toBack'");
    view2131296744 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_rl, "method 'showData'");
    view2131296794 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showData();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mDateTx = null;

    view2131296744.setOnClickListener(null);
    view2131296744 = null;
    view2131296794.setOnClickListener(null);
    view2131296794 = null;
  }
}
