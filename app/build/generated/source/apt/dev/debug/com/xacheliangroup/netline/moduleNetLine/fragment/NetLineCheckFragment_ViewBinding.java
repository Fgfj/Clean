// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.fragment;

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

public class NetLineCheckFragment_ViewBinding implements Unbinder {
  private NetLineCheckFragment target;

  private View view2131296753;

  private View view2131296747;

  @UiThread
  public NetLineCheckFragment_ViewBinding(final NetLineCheckFragment target, View source) {
    this.target = target;

    View view;
    target.mRvNumTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_rv_num_tx, "field 'mRvNumTx'", TextView.class);
    target.mRvNumLy = Utils.findRequiredViewAsType(source, R.id.module_nl_check_rv_num_ly, "field 'mRvNumLy'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.module_nl_check_rl, "field 'mBottomCheckRl' and method 'toCheck'");
    target.mBottomCheckRl = Utils.castView(view, R.id.module_nl_check_rl, "field 'mBottomCheckRl'", RelativeLayout.class);
    view2131296753 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCheck();
      }
    });
    target.mTopUserInfoLy = Utils.findRequiredViewAsType(source, R.id.module_nl_check_top_fl, "field 'mTopUserInfoLy'", LinearLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_nl_check_rv, "field 'mRecyclerView'", RecyclerView.class);
    target.mBTitleLy = Utils.findRequiredViewAsType(source, R.id.module_nl_check_toolbar_top_fl, "field 'mBTitleLy'", LinearLayout.class);
    target.mBNumberLy = Utils.findRequiredViewAsType(source, R.id.module_nl_check_toolbar_num_fl, "field 'mBNumberLy'", LinearLayout.class);
    target.mBNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_toolbar_num_tx, "field 'mBNumberTx'", TextView.class);
    target.mNameTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_name_tx, "field 'mNameTx'", TextView.class);
    target.mNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_phone_tx, "field 'mNumberTx'", TextView.class);
    target.mIdTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_id_tx, "field 'mIdTx'", TextView.class);
    target.mTimeTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_time_tx, "field 'mTimeTx'", TextView.class);
    target.mOrderTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_order_tx, "field 'mOrderTx'", TextView.class);
    target.mStartTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_start_tx, "field 'mStartTx'", TextView.class);
    target.mEndTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_end_tx, "field 'mEndTx'", TextView.class);
    target.mStartTimeTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_start_time_tx, "field 'mStartTimeTx'", TextView.class);
    target.mBzTx = Utils.findRequiredViewAsType(source, R.id.module_nl_check_start_bz_tx, "field 'mBzTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_check_back_img, "method 'toBack'");
    view2131296747 = view;
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
    NetLineCheckFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRvNumTx = null;
    target.mRvNumLy = null;
    target.mBottomCheckRl = null;
    target.mTopUserInfoLy = null;
    target.mRecyclerView = null;
    target.mBTitleLy = null;
    target.mBNumberLy = null;
    target.mBNumberTx = null;
    target.mNameTx = null;
    target.mNumberTx = null;
    target.mIdTx = null;
    target.mTimeTx = null;
    target.mOrderTx = null;
    target.mStartTx = null;
    target.mEndTx = null;
    target.mStartTimeTx = null;
    target.mBzTx = null;

    view2131296753.setOnClickListener(null);
    view2131296753 = null;
    view2131296747.setOnClickListener(null);
    view2131296747 = null;
  }
}
