// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment target;

  private View view2131296620;

  @UiThread
  public MineFragment_ViewBinding(final MineFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_user_icon_img, "field 'mUserIconImg' and method 'toUserIConOnClick'");
    target.mUserIconImg = Utils.castView(view, R.id.module_cbb_mine_user_icon_img, "field 'mUserIconImg'", ImageView.class);
    view2131296620 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUserIConOnClick();
      }
    });
    target.mUserNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_user_name_tx, "field 'mUserNameTx'", TextView.class);
    target.mUserSignTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_user_sign_tx, "field 'mUserSignTx'", TextView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_rv, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserIconImg = null;
    target.mUserNameTx = null;
    target.mUserSignTx = null;
    target.mRecyclerView = null;

    view2131296620.setOnClickListener(null);
    view2131296620 = null;
  }
}
