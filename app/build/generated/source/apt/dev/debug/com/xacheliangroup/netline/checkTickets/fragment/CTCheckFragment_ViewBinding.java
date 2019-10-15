// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CTCheckFragment_ViewBinding implements Unbinder {
  private CTCheckFragment target;

  private View view2131296689;

  private View view2131296690;

  private View view2131296700;

  private View view2131296694;

  private View view2131296696;

  @UiThread
  public CTCheckFragment_ViewBinding(final CTCheckFragment target, View source) {
    this.target = target;

    View view;
    target.mSellNumberTx = Utils.findRequiredViewAsType(source, R.id.module_ct_check_sell_number_tx, "field 'mSellNumberTx'", TextView.class);
    target.mAllNumberTx = Utils.findRequiredViewAsType(source, R.id.module_ct_check_all_number_tx, "field 'mAllNumberTx'", TextView.class);
    target.mMoneyTx = Utils.findRequiredViewAsType(source, R.id.module_ct_check_all_money_tx, "field 'mMoneyTx'", TextView.class);
    target.mCarNoTx = Utils.findRequiredViewAsType(source, R.id.module_ct_check_car_no_tx, "field 'mCarNoTx'", TextView.class);
    target.mStationTx = Utils.findRequiredViewAsType(source, R.id.module_ct_check_station_tx, "field 'mStationTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_ct_back_location_rl, "field 'mBackLocationRl' and method 'toBackLocation'");
    target.mBackLocationRl = Utils.castView(view, R.id.module_ct_back_location_rl, "field 'mBackLocationRl'", RelativeLayout.class);
    view2131296689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBackLocation();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_cancel_back_version_rl, "field 'mCancelBackLocationRl' and method 'toCancelBackLocation'");
    target.mCancelBackLocationRl = Utils.castView(view, R.id.module_ct_cancel_back_version_rl, "field 'mCancelBackLocationRl'", RelativeLayout.class);
    view2131296690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCancelBackLocation();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_check_start_rl, "field 'mStartReadIdCardRl' and method 'toCheckStart'");
    target.mStartReadIdCardRl = Utils.castView(view, R.id.module_ct_check_start_rl, "field 'mStartReadIdCardRl'", RelativeLayout.class);
    view2131296700 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCheckStart();
      }
    });
    target.mInputImgRl = Utils.findRequiredViewAsType(source, R.id.module_ct_check_keyboard_rl, "field 'mInputImgRl'", LinearLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_ct_check_rv, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.module_ct_check_back_img, "method 'toBack'");
    view2131296694 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_check_keyboard_img, "method 'toScannerCode'");
    view2131296696 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toScannerCode();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CTCheckFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSellNumberTx = null;
    target.mAllNumberTx = null;
    target.mMoneyTx = null;
    target.mCarNoTx = null;
    target.mStationTx = null;
    target.mBackLocationRl = null;
    target.mCancelBackLocationRl = null;
    target.mStartReadIdCardRl = null;
    target.mInputImgRl = null;
    target.mRecyclerView = null;

    view2131296689.setOnClickListener(null);
    view2131296689 = null;
    view2131296690.setOnClickListener(null);
    view2131296690 = null;
    view2131296700.setOnClickListener(null);
    view2131296700 = null;
    view2131296694.setOnClickListener(null);
    view2131296694 = null;
    view2131296696.setOnClickListener(null);
    view2131296696 = null;
  }
}
