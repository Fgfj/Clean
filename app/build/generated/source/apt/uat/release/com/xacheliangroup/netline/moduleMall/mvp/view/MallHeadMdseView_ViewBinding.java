// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MallHeadMdseView_ViewBinding implements Unbinder {
  private MallHeadMdseView target;

  @UiThread
  public MallHeadMdseView_ViewBinding(MallHeadMdseView target, View source) {
    this.target = target;

    target.mNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_mdse_name, "field 'mNameTx'", TextView.class);
    target.img = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_mdse_img, "field 'img'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MallHeadMdseView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameTx = null;
    target.img = null;
  }
}
