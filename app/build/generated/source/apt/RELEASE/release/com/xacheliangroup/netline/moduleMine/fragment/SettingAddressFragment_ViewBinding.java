// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingAddressFragment_ViewBinding implements Unbinder {
  private SettingAddressFragment target;

  private View view2131296719;

  private View view2131296722;

  @UiThread
  public SettingAddressFragment_ViewBinding(final SettingAddressFragment target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_fra_mine_setting_address_rv, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.module_fra_mine_setting_address_back_fl, "method 'toBack'");
    view2131296719 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_fra_mine_to_update_address_rl, "method 'toUpdateAddress'");
    view2131296722 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUpdateAddress();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingAddressFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;

    view2131296719.setOnClickListener(null);
    view2131296719 = null;
    view2131296722.setOnClickListener(null);
    view2131296722 = null;
  }
}
