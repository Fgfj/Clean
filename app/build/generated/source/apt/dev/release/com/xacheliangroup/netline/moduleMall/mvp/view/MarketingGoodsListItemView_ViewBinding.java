// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.mvp.view;

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

public class MarketingGoodsListItemView_ViewBinding implements Unbinder {
  private MarketingGoodsListItemView target;

  @UiThread
  public MarketingGoodsListItemView_ViewBinding(MarketingGoodsListItemView target, View source) {
    this.target = target;

    target.mImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_goods_list_item_img, "field 'mImg'", ImageView.class);
    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_goods_list_item_title_tx, "field 'mTitleTx'", TextView.class);
    target.mPriceTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_goods_list_item_price_tx, "field 'mPriceTx'", TextView.class);
    target.mContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_goods_list_item_content_tx, "field 'mContentTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MarketingGoodsListItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImg = null;
    target.mTitleTx = null;
    target.mPriceTx = null;
    target.mContentTx = null;
  }
}
