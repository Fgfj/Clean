// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.common;

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

public class AdvertActivity_ViewBinding implements Unbinder {
  private AdvertActivity target;

  @UiThread
  public AdvertActivity_ViewBinding(AdvertActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AdvertActivity_ViewBinding(AdvertActivity target, View source) {
    this.target = target;

    target.mImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_advert_act_img, "field 'mImg'", ImageView.class);
    target.mNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_advert_act_text, "field 'mNumberTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdvertActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImg = null;
    target.mNumberTx = null;
  }
}
