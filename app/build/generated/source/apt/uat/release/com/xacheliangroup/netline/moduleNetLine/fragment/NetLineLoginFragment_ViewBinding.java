// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineLoginFragment_ViewBinding implements Unbinder {
  private NetLineLoginFragment target;

  private View view2131296766;

  @UiThread
  public NetLineLoginFragment_ViewBinding(final NetLineLoginFragment target, View source) {
    this.target = target;

    View view;
    target.mPhoneEt = Utils.findRequiredViewAsType(source, R.id.module_nl_phone_et, "field 'mPhoneEt'", EditText.class);
    target.mPasswrod = Utils.findRequiredViewAsType(source, R.id.module_nl_ps_et, "field 'mPasswrod'", EditText.class);
    target.mTx = Utils.findRequiredViewAsType(source, R.id.module_nl_title_num_tx, "field 'mTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_login, "method 'toLogin'");
    view2131296766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toLogin();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineLoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPhoneEt = null;
    target.mPasswrod = null;
    target.mTx = null;

    view2131296766.setOnClickListener(null);
    view2131296766 = null;
  }
}
