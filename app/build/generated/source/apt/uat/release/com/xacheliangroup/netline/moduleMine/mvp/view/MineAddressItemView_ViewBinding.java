// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineAddressItemView_ViewBinding implements Unbinder {
  private MineAddressItemView target;

  @UiThread
  public MineAddressItemView_ViewBinding(MineAddressItemView target, View source) {
    this.target = target;

    target.mNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_address_item_name_tx, "field 'mNameTx'", TextView.class);
    target.mPhoenTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_address_item_phone_tx, "field 'mPhoenTx'", TextView.class);
    target.mAddressTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_address_item_address_tx, "field 'mAddressTx'", TextView.class);
    target.mDefaultRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_address_item_default_rl, "field 'mDefaultRl'", RelativeLayout.class);
    target.mUpdateImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_address_item_update_img, "field 'mUpdateImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineAddressItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTx = null;
    target.mPhoenTx = null;
    target.mAddressTx = null;
    target.mDefaultRl = null;
    target.mUpdateImg = null;
  }
}
