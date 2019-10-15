// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineHomeFragment_ViewBinding implements Unbinder {
  private NetLineHomeFragment target;

  private View view2131296737;

  private View view2131296773;

  private View view2131296763;

  private View view2131296775;

  private View view2131296799;

  private View view2131296762;

  private View view2131296780;

  private View view2131296789;

  private View view2131296777;

  @UiThread
  public NetLineHomeFragment_ViewBinding(final NetLineHomeFragment target, View source) {
    this.target = target;

    View view;
    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.module_nl_drawer_layout, "field 'mDrawerLayout'", DrawerLayout.class);
    target.mDiverNameTx = Utils.findRequiredViewAsType(source, R.id.module_nl_driver_name_tx, "field 'mDiverNameTx'", TextView.class);
    target.mDiverPhoneNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_driver_number_tx, "field 'mDiverPhoneNumberTx'", TextView.class);
    target.mCarNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_top_car_num_tx, "field 'mCarNumberTx'", TextView.class);
    target.mCarHumanNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_top_car_human_num_tx, "field 'mCarHumanNumberTx'", TextView.class);
    target.mCarTypeTx = Utils.findRequiredViewAsType(source, R.id.module_nl_top_car_type_num_tx, "field 'mCarTypeTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_bind_ly, "field 'mBindLy' and method 'toBind'");
    target.mBindLy = Utils.castView(view, R.id.module_nl_bind_ly, "field 'mBindLy'", LinearLayout.class);
    view2131296737 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBind();
      }
    });
    target.mBindOverLy = Utils.findRequiredViewAsType(source, R.id.module_nl_bind_over_ly, "field 'mBindOverLy'", LinearLayout.class);
    target.mNavigationView = Utils.findRequiredViewAsType(source, R.id.module_nl_nav_view, "field 'mNavigationView'", NavigationView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_post_car_tx, "field 'mUpCarTx' and method 'toPostOnclick'");
    target.mUpCarTx = Utils.castView(view, R.id.module_nl_post_car_tx, "field 'mUpCarTx'", TextView.class);
    view2131296773 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toPostOnclick();
      }
    });
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_nl_user_list_rcv, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_home_back_img, "method 'toBack'");
    view2131296763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_qr_code_ly, "method 'toQrcode'");
    view2131296775 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toQrcode();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_user_map_rl, "method 'toUserMap'");
    view2131296799 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUserMap();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_go_tx, "method 'toCarGo'");
    view2131296762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCarGo();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_send_over_tx, "method 'toCarSendOver'");
    view2131296780 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCarSendOver();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_update_ly, "method 'toUpdate'");
    view2131296789 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUpdate();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_qr_lock_rl, "method 'toLockSeat'");
    view2131296777 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toLockSeat();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineHomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDrawerLayout = null;
    target.mDiverNameTx = null;
    target.mDiverPhoneNumberTx = null;
    target.mCarNumberTx = null;
    target.mCarHumanNumberTx = null;
    target.mCarTypeTx = null;
    target.mBindLy = null;
    target.mBindOverLy = null;
    target.mNavigationView = null;
    target.mUpCarTx = null;
    target.mRecyclerView = null;

    view2131296737.setOnClickListener(null);
    view2131296737 = null;
    view2131296773.setOnClickListener(null);
    view2131296773 = null;
    view2131296763.setOnClickListener(null);
    view2131296763 = null;
    view2131296775.setOnClickListener(null);
    view2131296775 = null;
    view2131296799.setOnClickListener(null);
    view2131296799 = null;
    view2131296762.setOnClickListener(null);
    view2131296762 = null;
    view2131296780.setOnClickListener(null);
    view2131296780 = null;
    view2131296789.setOnClickListener(null);
    view2131296789 = null;
    view2131296777.setOnClickListener(null);
    view2131296777 = null;
  }
}
