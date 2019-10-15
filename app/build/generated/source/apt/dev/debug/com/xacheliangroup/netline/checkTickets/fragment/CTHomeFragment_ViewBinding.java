// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CTHomeFragment_ViewBinding implements Unbinder {
  private CTHomeFragment target;

  private View view2131296710;

  private View view2131296708;

  @UiThread
  public CTHomeFragment_ViewBinding(final CTHomeFragment target, View source) {
    this.target = target;

    View view;
    target.mEdt = Utils.findRequiredViewAsType(source, R.id.ct_fra_ed, "field 'mEdt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.module_ct_home_next_rl, "method 'toNext'");
    view2131296710 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toNext();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_ct_detail_back_img, "method 'toBack'");
    view2131296708 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CTHomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEdt = null;

    view2131296710.setOnClickListener(null);
    view2131296710 = null;
    view2131296708.setOnClickListener(null);
    view2131296708 = null;
  }
}
