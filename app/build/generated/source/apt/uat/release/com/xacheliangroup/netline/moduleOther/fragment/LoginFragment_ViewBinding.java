// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleOther.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  private View view2131296537;

  private View view2131296528;

  private View view2131296532;

  private View view2131296531;

  @UiThread
  public LoginFragment_ViewBinding(final LoginFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.module_cbb_login_user_agreement_tx, "field 'mAgreementTx' and method 'toShowUserAgreement'");
    target.mAgreementTx = Utils.castView(view, R.id.module_cbb_login_user_agreement_tx, "field 'mAgreementTx'", TextView.class);
    view2131296537 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toShowUserAgreement();
      }
    });
    target.mStatusBarTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_login_status_bar_rl, "field 'mStatusBarTx'", TextView.class);
    target.mAppBarRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_login_app_bar_rl, "field 'mAppBarRl'", RelativeLayout.class);
    target.mPhoneEt = Utils.findRequiredViewAsType(source, R.id.module_cbb_login_phone_number_et, "field 'mPhoneEt'", EditText.class);
    target.mCodeEt = Utils.findRequiredViewAsType(source, R.id.module_cbb_login_phone_code_et, "field 'mCodeEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_login_bottom_login_rl, "field 'mLoginRl' and method 'toLogin'");
    target.mLoginRl = Utils.castView(view, R.id.module_cbb_login_bottom_login_rl, "field 'mLoginRl'", RelativeLayout.class);
    view2131296528 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toLogin();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_login_get_phone_code_tx, "field 'mGetPhoneCodeTx' and method 'toGetPhoneCodeTx'");
    target.mGetPhoneCodeTx = Utils.castView(view, R.id.module_cbb_login_get_phone_code_tx, "field 'mGetPhoneCodeTx'", TextView.class);
    view2131296532 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetPhoneCodeTx();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_login_close_img, "method 'toBack'");
    view2131296531 = view;
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
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAgreementTx = null;
    target.mStatusBarTx = null;
    target.mAppBarRl = null;
    target.mPhoneEt = null;
    target.mCodeEt = null;
    target.mLoginRl = null;
    target.mGetPhoneCodeTx = null;

    view2131296537.setOnClickListener(null);
    view2131296537 = null;
    view2131296528.setOnClickListener(null);
    view2131296528 = null;
    view2131296532.setOnClickListener(null);
    view2131296532 = null;
    view2131296531.setOnClickListener(null);
    view2131296531 = null;
  }
}
