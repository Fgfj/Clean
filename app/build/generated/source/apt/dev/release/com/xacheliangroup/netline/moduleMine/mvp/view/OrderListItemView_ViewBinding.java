// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.mvp.view;

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

public class OrderListItemView_ViewBinding implements Unbinder {
  private OrderListItemView target;

  @UiThread
  public OrderListItemView_ViewBinding(OrderListItemView target, View source) {
    this.target = target;

    target.mTypeTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_type_tx, "field 'mTypeTx'", TextView.class);
    target.mOnclickTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_onclick_tx, "field 'mOnclickTx'", TextView.class);
    target.mOnclickRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_onclick_rl, "field 'mOnclickRl'", RelativeLayout.class);
    target.mChangeTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_change_tx, "field 'mChangeTx'", TextView.class);
    target.mMoneyAllTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_py_money_tx, "field 'mMoneyAllTx'", TextView.class);
    target.mGoodsContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_goods_content_tx, "field 'mGoodsContentTx'", TextView.class);
    target.mGoodsNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_goods_number_tx, "field 'mGoodsNumberTx'", TextView.class);
    target.mGoodsNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_goods_name_tx, "field 'mGoodsNameTx'", TextView.class);
    target.mGoodsImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_list_item_goods_img, "field 'mGoodsImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderListItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTypeTx = null;
    target.mOnclickTx = null;
    target.mOnclickRl = null;
    target.mChangeTx = null;
    target.mMoneyAllTx = null;
    target.mGoodsContentTx = null;
    target.mGoodsNumberTx = null;
    target.mGoodsNameTx = null;
    target.mGoodsImg = null;
  }
}
