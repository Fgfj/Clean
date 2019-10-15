// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleCarComment.mvp.view;

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

public class CarCommentView_ViewBinding implements Unbinder {
  private CarCommentView target;

  @UiThread
  public CarCommentView_ViewBinding(CarCommentView target, View source) {
    this.target = target;

    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.item_car_comment_tx, "field 'mTitleTx'", TextView.class);
    target.mTopImg = Utils.findRequiredViewAsType(source, R.id.item_car_comment_top_img, "field 'mTopImg'", ImageView.class);
    target.mTypeImg = Utils.findRequiredViewAsType(source, R.id.item_car_comment_type_im, "field 'mTypeImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CarCommentView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitleTx = null;
    target.mTopImg = null;
    target.mTypeImg = null;
  }
}
