// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleCarCircle.mvp.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarCircleItemView_ViewBinding implements Unbinder {
  private CarCircleItemView target;

  @UiThread
  public CarCircleItemView_ViewBinding(CarCircleItemView target, View source) {
    this.target = target;

    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_item_title_tx, "field 'mTitleTx'", TextView.class);
    target.mImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_item_img, "field 'mImg'", ImageView.class);
    target.mUserImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_user_img, "field 'mUserImg'", ImageView.class);
    target.mUserNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_user_name_tx, "field 'mUserNameTx'", TextView.class);
    target.mAddThumbTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_add_thumb_tx, "field 'mAddThumbTx'", TextView.class);
    target.mThumbStatusImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_add_thumb_img, "field 'mThumbStatusImg'", ImageView.class);

    Context context = source.getContext();
    target.mDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_thumb_white_icon);
    target.mFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_thumb_red_icon);
  }

  @Override
  @CallSuper
  public void unbind() {
    CarCircleItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitleTx = null;
    target.mImg = null;
    target.mUserImg = null;
    target.mUserNameTx = null;
    target.mAddThumbTx = null;
    target.mThumbStatusImg = null;
  }
}
