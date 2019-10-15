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

public class MallFourFunView_ViewBinding implements Unbinder {
  private MallFourFunView target;

  @UiThread
  public MallFourFunView_ViewBinding(MallFourFunView target, View source) {
    this.target = target;

    target.mImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_four_fun_img, "field 'mImg'", ImageView.class);
    target.mTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_four_fun_tx, "field 'mTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MallFourFunView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImg = null;
    target.mTx = null;
  }
}
