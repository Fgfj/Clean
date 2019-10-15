// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineMapFragment_ViewBinding implements Unbinder {
  private NetLineMapFragment target;

  private View view2131296767;

  private View view2131296789;

  private View view2131296757;

  @UiThread
  public NetLineMapFragment_ViewBinding(final NetLineMapFragment target, View source) {
    this.target = target;

    View view;
    target.mMapView = Utils.findRequiredViewAsType(source, R.id.module_nl_maps2d, "field 'mMapView'", MapView.class);
    target.mUpCarFl = Utils.findRequiredViewAsType(source, R.id.module_nl_up_car_fl, "field 'mUpCarFl'", FrameLayout.class);
    target.mDownCarFl = Utils.findRequiredViewAsType(source, R.id.module_nl_down_car_fl, "field 'mDownCarFl'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.module_nl_map_back_img, "method 'toBack'");
    view2131296767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_up_car_ly, "method 'toUpCarLocation'");
    view2131296789 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUpCarLocation();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_nl_down_car_ly, "method 'toDownCarLocation'");
    view2131296757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toDownCarLocation();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineMapFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMapView = null;
    target.mUpCarFl = null;
    target.mDownCarFl = null;

    view2131296767.setOnClickListener(null);
    view2131296767 = null;
    view2131296789.setOnClickListener(null);
    view2131296789 = null;
    view2131296757.setOnClickListener(null);
    view2131296757 = null;
  }
}
