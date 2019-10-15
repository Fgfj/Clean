// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleTest.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.amap.api.maps2d.MapView;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestMainFragment_ViewBinding implements Unbinder {
  private TestMainFragment target;

  private View view2131296459;

  private View view2131296901;

  private View view2131296955;

  @UiThread
  public TestMainFragment_ViewBinding(final TestMainFragment target, View source) {
    this.target = target;

    View view;
    target.mMapView = Utils.findRequiredViewAsType(source, R.id.maps2d, "field 'mMapView'", MapView.class);
    target.mZXingView = Utils.findRequiredViewAsType(source, R.id.zxingview, "field 'mZXingView'", ZXingView.class);
    view = Utils.findRequiredView(source, R.id.main_test_tv, "method 'toBtnOnclick'");
    view2131296459 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBtnOnclick();
      }
    });
    view = Utils.findRequiredView(source, R.id.socket_btn, "method 'socket'");
    view2131296901 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.socket();
      }
    });
    view = Utils.findRequiredView(source, R.id.web_socket_btn, "method 'webSocket'");
    view2131296955 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.webSocket();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TestMainFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMapView = null;
    target.mZXingView = null;

    view2131296459.setOnClickListener(null);
    view2131296459 = null;
    view2131296901.setOnClickListener(null);
    view2131296901 = null;
    view2131296955.setOnClickListener(null);
    view2131296955 = null;
  }
}
