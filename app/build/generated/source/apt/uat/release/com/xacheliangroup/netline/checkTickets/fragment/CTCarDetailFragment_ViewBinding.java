// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CTCarDetailFragment_ViewBinding implements Unbinder {
  private CTCarDetailFragment target;

  private View view2131296691;

  private View view2131296715;

  private View view2131296713;

  @UiThread
  public CTCarDetailFragment_ViewBinding(final CTCarDetailFragment target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_ctt_car_detail_rv, "field 'mRecyclerView'", RecyclerView.class);
    target.mUpCicrelFl = Utils.findRequiredViewAsType(source, R.id.module_ct_up_car_fl, "field 'mUpCicrelFl'", FrameLayout.class);
    target.mLiveCicrelFl = Utils.findRequiredViewAsType(source, R.id.module_ct_live_car_fl, "field 'mLiveCicrelFl'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.module_ct_car_detail_back_img, "method 'toBack'");
    view2131296691 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_up_car_ly, "method 'toUpCarOnClick'");
    view2131296715 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUpCarOnClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_live_car_ly, "method 'toLiveCarOnclick'");
    view2131296713 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toLiveCarOnclick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CTCarDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mUpCicrelFl = null;
    target.mLiveCicrelFl = null;

    view2131296691.setOnClickListener(null);
    view2131296691 = null;
    view2131296715.setOnClickListener(null);
    view2131296715 = null;
    view2131296713.setOnClickListener(null);
    view2131296713 = null;
  }
}
