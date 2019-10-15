// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineQrCodeFragment_ViewBinding implements Unbinder {
  private NetLineQrCodeFragment target;

  @UiThread
  public NetLineQrCodeFragment_ViewBinding(NetLineQrCodeFragment target, View source) {
    this.target = target;

    target.mZXingView = Utils.findRequiredViewAsType(source, R.id.module_nl_zxingview, "field 'mZXingView'", ZXingView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineQrCodeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mZXingView = null;
  }
}
