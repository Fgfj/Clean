// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CTChoiceStationFragment_ViewBinding implements Unbinder {
  private CTChoiceStationFragment target;

  private View view2131296704;

  private View view2131296705;

  private View view2131296706;

  private View view2131296707;

  @UiThread
  public CTChoiceStationFragment_ViewBinding(final CTChoiceStationFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.module_ct_choice_station_cx_rl, "method 'toCx'");
    view2131296704 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCx();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_choice_station_fzc_rl, "method 'toFZC'");
    view2131296705 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toFZC();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_choice_station_sfw_rl, "method 'toSFW'");
    view2131296706 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toSFW();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_choice_station_yl_rl, "method 'toYl'");
    view2131296707 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toYl();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296704.setOnClickListener(null);
    view2131296704 = null;
    view2131296705.setOnClickListener(null);
    view2131296705 = null;
    view2131296706.setOnClickListener(null);
    view2131296706 = null;
    view2131296707.setOnClickListener(null);
    view2131296707 = null;
  }
}
