// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppSettingFragment_ViewBinding implements Unbinder {
  private AppSettingFragment target;

  private View view2131296608;

  private View view2131296609;

  private View view2131296606;

  private View view2131296605;

  private View view2131296610;

  @UiThread
  public AppSettingFragment_ViewBinding(final AppSettingFragment target, View source) {
    this.target = target;

    View view;
    target.mSizeTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_setting_clear_size_tx, "field 'mSizeTx'", TextView.class);
    target.mVersionTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_setting_version_tx, "field 'mVersionTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_setting_list_back_fl, "method 'toBack'");
    view2131296608 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_setting_logout_ry, "method 'toLogout'");
    view2131296609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toLogout();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_setting_clear_size_ly, "method 'toClearSize'");
    view2131296606 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toClearSize();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_setting_about_us_ly, "method 'toGoAboutUsWeb'");
    view2131296605 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGoAboutUsWeb();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_setting_service_ly, "method 'toGoServiceWeb'");
    view2131296610 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGoServiceWeb();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AppSettingFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSizeTx = null;
    target.mVersionTx = null;

    view2131296608.setOnClickListener(null);
    view2131296608 = null;
    view2131296609.setOnClickListener(null);
    view2131296609 = null;
    view2131296606.setOnClickListener(null);
    view2131296606 = null;
    view2131296605.setOnClickListener(null);
    view2131296605 = null;
    view2131296610.setOnClickListener(null);
    view2131296610 = null;
  }
}
