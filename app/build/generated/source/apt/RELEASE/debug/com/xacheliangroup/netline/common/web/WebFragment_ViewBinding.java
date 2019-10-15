// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.common.web;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebFragment_ViewBinding implements Unbinder {
  private WebFragment target;

  @UiThread
  public WebFragment_ViewBinding(WebFragment target, View source) {
    this.target = target;

    target.mWebView = Utils.findRequiredViewAsType(source, R.id.module_cbb_web_wv, "field 'mWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWebView = null;
  }
}
