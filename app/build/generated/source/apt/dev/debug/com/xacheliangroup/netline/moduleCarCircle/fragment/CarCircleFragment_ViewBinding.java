// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleCarCircle.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarCircleFragment_ViewBinding implements Unbinder {
  private CarCircleFragment target;

  @UiThread
  public CarCircleFragment_ViewBinding(CarCircleFragment target, View source) {
    this.target = target;

    target.mTableLayout = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_home_tl, "field 'mTableLayout'", TabLayout.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_home_vp, "field 'mViewPager'", ViewPager.class);
    target.mStatusBarTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_status_bar_tx, "field 'mStatusBarTx'", TextView.class);
    target.mAppbarLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_car_circle_app_bar_ly, "field 'mAppbarLy'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CarCircleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTableLayout = null;
    target.mViewPager = null;
    target.mStatusBarTx = null;
    target.mAppbarLy = null;
  }
}
