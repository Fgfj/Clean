// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleNetLine.mvp.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NetLineUserListView_ViewBinding implements Unbinder {
  private NetLineUserListView target;

  private View view2131296796;

  @UiThread
  public NetLineUserListView_ViewBinding(final NetLineUserListView target, View source) {
    this.target = target;

    View view;
    target.mBg = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_bg_ly, "field 'mBg'", LinearLayout.class);
    target.mTypeTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_type_tx, "field 'mTypeTx'", TextView.class);
    target.mPersonNumberTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_number_tx, "field 'mPersonNumberTx'", TextView.class);
    target.mStartStationTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_start_tx, "field 'mStartStationTx'", TextView.class);
    target.mEndStationTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_end_tx, "field 'mEndStationTx'", TextView.class);
    target.mUserNameTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_name_tx, "field 'mUserNameTx'", TextView.class);
    target.mStationTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_station_tx, "field 'mStationTx'", TextView.class);
    target.mStartImg = Utils.findRequiredViewAsType(source, R.id.module_nl_start_station_img, "field 'mStartImg'", ImageView.class);
    target.mEndImg = Utils.findRequiredViewAsType(source, R.id.module_nl_end_station_img, "field 'mEndImg'", ImageView.class);
    target.mCallImg = Utils.findRequiredViewAsType(source, R.id.ic_call_black_img, "field 'mCallImg'", ImageView.class);
    target.mSendOverTx = Utils.findRequiredViewAsType(source, R.id.module_nl_user_item_send_over_tx, "field 'mSendOverTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_nl_user_item_phone_click_ly, "method 'toCallPhone'");
    view2131296796 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toCallPhone();
      }
    });

    Context context = source.getContext();
    target.mGray = ContextCompat.getDrawable(context, R.drawable.module_nl_start_staion_gray_icon);
    target.mCD = ContextCompat.getDrawable(context, R.drawable.module_nl_start_staion_icon);
    target.mGD = ContextCompat.getDrawable(context, R.drawable.module_nl_end_staion_icon);
    target.mCallGray = ContextCompat.getDrawable(context, R.drawable.ic_call_black_gray_24dp);
    target.mCallBlack = ContextCompat.getDrawable(context, R.drawable.ic_call_black_24dp);
  }

  @Override
  @CallSuper
  public void unbind() {
    NetLineUserListView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBg = null;
    target.mTypeTx = null;
    target.mPersonNumberTx = null;
    target.mStartStationTx = null;
    target.mEndStationTx = null;
    target.mUserNameTx = null;
    target.mStationTx = null;
    target.mStartImg = null;
    target.mEndImg = null;
    target.mCallImg = null;
    target.mSendOverTx = null;

    view2131296796.setOnClickListener(null);
    view2131296796 = null;
  }
}
