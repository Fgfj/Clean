// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PayOrderFragment_ViewBinding implements Unbinder {
  private PayOrderFragment target;

  private View view2131296644;

  @UiThread
  public PayOrderFragment_ViewBinding(final PayOrderFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.module_cbb_pay_order_back_img, "method 'toBack'");
    view2131296644 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296644.setOnClickListener(null);
    view2131296644 = null;
  }
}
