// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineHomeUiView_ViewBinding implements Unbinder {
  private MineHomeUiView target;

  @UiThread
  public MineHomeUiView_ViewBinding(MineHomeUiView target, View source) {
    this.target = target;

    target.mImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_ui_item_img, "field 'mImg'", ImageView.class);
    target.mTopTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_ui_item_top_tx, "field 'mTopTx'", TextView.class);
    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_ui_item_title_tx, "field 'mTitleTx'", TextView.class);
    target.mLineTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_ui_item_line_tx, "field 'mLineTx'", TextView.class);
    target.mRedImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_ui_item_red_img, "field 'mRedImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MineHomeUiView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImg = null;
    target.mTopTx = null;
    target.mTitleTx = null;
    target.mLineTx = null;
    target.mRedImg = null;
  }
}
