// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SellerItemView_ViewBinding implements Unbinder {
  private SellerItemView target;

  @UiThread
  public SellerItemView_ViewBinding(SellerItemView target, View source) {
    this.target = target;

    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_name_tx, "field 'mTitleTx'", TextView.class);
    target.mSellerImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_seller_img, "field 'mSellerImg'", ImageView.class);
    target.mStarNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_star_number_tx, "field 'mStarNumberTx'", TextView.class);
    target.mSellNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_sell_number_tx, "field 'mSellNumberTx'", TextView.class);
    target.mAddressTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_address_tx, "field 'mAddressTx'", TextView.class);
    target.mDistanceTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_distance_tx, "field 'mDistanceTx'", TextView.class);
    target.mLabelOneRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label1_rl, "field 'mLabelOneRl'", RelativeLayout.class);
    target.mLabelTwoRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label2_rl, "field 'mLabelTwoRl'", RelativeLayout.class);
    target.mLabelThreeRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label3_rl, "field 'mLabelThreeRl'", RelativeLayout.class);
    target.mLabelOneTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label1_tx, "field 'mLabelOneTx'", TextView.class);
    target.mLabelTwoTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label2_tx, "field 'mLabelTwoTx'", TextView.class);
    target.mLabelThreeTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_seller_item_label3_tx, "field 'mLabelThreeTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SellerItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitleTx = null;
    target.mSellerImg = null;
    target.mStarNumberTx = null;
    target.mSellNumberTx = null;
    target.mAddressTx = null;
    target.mDistanceTx = null;
    target.mLabelOneRl = null;
    target.mLabelTwoRl = null;
    target.mLabelThreeRl = null;
    target.mLabelOneTx = null;
    target.mLabelTwoTx = null;
    target.mLabelThreeTx = null;
  }
}
