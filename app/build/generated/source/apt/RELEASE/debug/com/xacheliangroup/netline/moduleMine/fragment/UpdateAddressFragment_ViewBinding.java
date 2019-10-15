// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateAddressFragment_ViewBinding implements Unbinder {
  private UpdateAddressFragment target;

  private View view2131296725;

  private View view2131296724;

  private View view2131296728;

  @UiThread
  public UpdateAddressFragment_ViewBinding(final UpdateAddressFragment target, View source) {
    this.target = target;

    View view;
    target.mAddressEt = Utils.findRequiredViewAsType(source, R.id.module_fra_mine_update_address_address_et, "field 'mAddressEt'", EditText.class);
    target.mPhoneEt = Utils.findRequiredViewAsType(source, R.id.module_fra_mine_update_address_phone_et, "field 'mPhoneEt'", EditText.class);
    target.mNameEt = Utils.findRequiredViewAsType(source, R.id.module_fra_mine_update_address_name_et, "field 'mNameEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.module_fra_mine_update_address_choice_img, "field 'mChoiceImg' and method 'choiceDefaultAddress'");
    target.mChoiceImg = Utils.castView(view, R.id.module_fra_mine_update_address_choice_img, "field 'mChoiceImg'", ImageView.class);
    view2131296725 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.choiceDefaultAddress();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_fra_mine_update_address_back_fl, "method 'toBack'");
    view2131296724 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_fra_mine_update_address_submit_rl, "method 'toSubmitRl'");
    view2131296728 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toSubmitRl();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateAddressFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAddressEt = null;
    target.mPhoneEt = null;
    target.mNameEt = null;
    target.mChoiceImg = null;

    view2131296725.setOnClickListener(null);
    view2131296725 = null;
    view2131296724.setOnClickListener(null);
    view2131296724 = null;
    view2131296728.setOnClickListener(null);
    view2131296728 = null;
  }
}
