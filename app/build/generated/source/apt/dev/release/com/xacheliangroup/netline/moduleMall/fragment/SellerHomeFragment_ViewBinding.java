// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SellerHomeFragment_ViewBinding implements Unbinder {
  private SellerHomeFragment target;

  private View view2131296647;

  @UiThread
  public SellerHomeFragment_ViewBinding(final SellerHomeFragment target, View source) {
    this.target = target;

    View view;
    target.mSellerTap1Rl = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_1_rl, "field 'mSellerTap1Rl'", RelativeLayout.class);
    target.mSellerTap2Rl = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_2_rl, "field 'mSellerTap2Rl'", RelativeLayout.class);
    target.mSellerTap3Rl = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_3_rl, "field 'mSellerTap3Rl'", RelativeLayout.class);
    target.mSellerTap1Tx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_1_tx, "field 'mSellerTap1Tx'", TextView.class);
    target.mSellerTap2Tx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_2_tx, "field 'mSellerTap2Tx'", TextView.class);
    target.mSellerTap3Tx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_tab_3_tx, "field 'mSellerTap3Tx'", TextView.class);
    target.mSellerDistanceTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_seller_distance_tx, "field 'mSellerDistanceTx'", TextView.class);
    target.mSellerStarTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_star_tx, "field 'mSellerStarTx'", TextView.class);
    target.mSellerTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_title_tx, "field 'mSellerTitleTx'", TextView.class);
    target.mSellerPhoneNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_phone_number_tx, "field 'mSellerPhoneNumberTx'", TextView.class);
    target.mSellerAddressTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_seller_address_tx, "field 'mSellerAddressTx'", TextView.class);
    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_top_title_tx, "field 'mTitleTx'", TextView.class);
    target.mNestedScrollView = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_ns, "field 'mNestedScrollView'", NestedScrollView.class);
    target.mBgTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_top_bg_tx, "field 'mBgTx'", TextView.class);
    target.mStarRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_star_rv, "field 'mStarRecyclerView'", RecyclerView.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_vp, "field 'mViewPager'", ViewPager.class);
    target.mRadioGroup = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_home_rg, "field 'mRadioGroup'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_seller_home_back_img, "method 'back'");
    view2131296647 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SellerHomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSellerTap1Rl = null;
    target.mSellerTap2Rl = null;
    target.mSellerTap3Rl = null;
    target.mSellerTap1Tx = null;
    target.mSellerTap2Tx = null;
    target.mSellerTap3Tx = null;
    target.mSellerDistanceTx = null;
    target.mSellerStarTx = null;
    target.mSellerTitleTx = null;
    target.mSellerPhoneNumberTx = null;
    target.mSellerAddressTx = null;
    target.mTitleTx = null;
    target.mNestedScrollView = null;
    target.mBgTx = null;
    target.mStarRecyclerView = null;
    target.mViewPager = null;
    target.mRadioGroup = null;

    view2131296647.setOnClickListener(null);
    view2131296647 = null;
  }
}
