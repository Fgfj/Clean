// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CbbMainActivity_ViewBinding implements Unbinder {
  private CbbMainActivity target;

  private View view2131296518;

  private View view2131296511;

  private View view2131296514;

  private View view2131296521;

  @UiThread
  public CbbMainActivity_ViewBinding(CbbMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CbbMainActivity_ViewBinding(final CbbMainActivity target, View source) {
    this.target = target;

    View view;
    target.mMallTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_mall_ly_tx, "field 'mMallTx'", TextView.class);
    target.mCarCircleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_car_circle_ly_tx, "field 'mCarCircleTx'", TextView.class);
    target.mCarCommentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_car_comment_ly_tx, "field 'mCarCommentTx'", TextView.class);
    target.mMineTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_mine_ly_tx, "field 'mMineTx'", TextView.class);
    target.mMallImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_mall_ly_img, "field 'mMallImg'", ImageView.class);
    target.mCarCircleImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_car_circle_ly_img, "field 'mCarCircleImg'", ImageView.class);
    target.mCarCommentImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_car_comment_ly_img, "field 'mCarCommentImg'", ImageView.class);
    target.mMineImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_home_mine_ly_img, "field 'mMineImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_home_mall_ly, "method 'toMall'");
    view2131296518 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toMall();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_home_car_circle_ly, "method 'toCarCircle'");
    view2131296511 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCarCircle();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_home_car_comment_ly, "method 'toCarComment'");
    view2131296514 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCarComment();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_home_mine_ly, "method 'toMine'");
    view2131296521 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toMine();
      }
    });

    Context context = source.getContext();
    target.mMallDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mall_nomarl_icon);
    target.mMallFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mall_focus_icon);
    target.mCarCircleDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_car_circle_nomarl_icon);
    target.mCarCircleFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_car_circle_focus_icon);
    target.mCarCommentDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_car_comment_nomarl_icon);
    target.mCarCommentFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_car_comment_focus_icon);
    target.mMineDefaultIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mine_nomarl_icon);
    target.mMineFocusIcon = ContextCompat.getDrawable(context, R.drawable.module_cbb_home_mine_focus_icon);
  }

  @Override
  @CallSuper
  public void unbind() {
    CbbMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMallTx = null;
    target.mCarCircleTx = null;
    target.mCarCommentTx = null;
    target.mMineTx = null;
    target.mMallImg = null;
    target.mCarCircleImg = null;
    target.mCarCommentImg = null;
    target.mMineImg = null;

    view2131296518.setOnClickListener(null);
    view2131296518 = null;
    view2131296511.setOnClickListener(null);
    view2131296511 = null;
    view2131296514.setOnClickListener(null);
    view2131296514 = null;
    view2131296521.setOnClickListener(null);
    view2131296521 = null;
  }
}
