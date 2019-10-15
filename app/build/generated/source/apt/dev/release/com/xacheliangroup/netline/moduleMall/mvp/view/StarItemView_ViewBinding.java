// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.mvp.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StarItemView_ViewBinding implements Unbinder {
  private StarItemView target;

  @UiThread
  public StarItemView_ViewBinding(StarItemView target, View source) {
    this.target = target;

    target.mStarImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_rv_star_img, "field 'mStarImg'", ImageView.class);

    Context context = source.getContext();
    target.mFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mall_star_icon);
    target.mDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mall_star_defult_icon);
  }

  @Override
  @CallSuper
  public void unbind() {
    StarItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mStarImg = null;
  }
}
