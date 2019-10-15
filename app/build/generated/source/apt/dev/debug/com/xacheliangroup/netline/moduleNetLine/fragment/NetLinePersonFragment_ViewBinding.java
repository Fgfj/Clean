// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

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

public class NetLinePersonFragment_ViewBinding implements Unbinder {
  private NetLinePersonFragment target;

  private View view2131296784;

  private View view2131296743;

  private View view2131296732;

  @UiThread
  public NetLinePersonFragment_ViewBinding(final NetLinePersonFragment target, View source) {
    this.target = target;

    View view;
    target.mNameTx = Utils.findRequiredViewAsType(source, R.id.module_net_line_car_name_tx, "field 'mNameTx'", TextView.class);
    target.mNum1Tx = Utils.findRequiredViewAsType(source, R.id.module_net_line_car_num1_tx, "field 'mNum1Tx'", TextView.class);
    target.mNum2Tx = Utils.findRequiredViewAsType(source, R.id.module_net_line_car_num2_tx, "field 'mNum2Tx'", TextView.class);
    target.mNum3Tx = Utils.findRequiredViewAsType(source, R.id.module_net_line_car_num3_tx, "field 'mNum3Tx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_person_back_img, "method 'toBack'");
    view2131296784 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_netline_car_his_ly, "method 'toGetCarHis'");
    view2131296743 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetCarHis();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_net_line_call_phone_ly, "method 'toCallPhone'");
    view2131296732 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCallPhone();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLinePersonFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTx = null;
    target.mNum1Tx = null;
    target.mNum2Tx = null;
    target.mNum3Tx = null;

    view2131296784.setOnClickListener(null);
    view2131296784 = null;
    view2131296743.setOnClickListener(null);
    view2131296743 = null;
    view2131296732.setOnClickListener(null);
    view2131296732 = null;
  }
}
