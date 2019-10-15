// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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

public class SubmitOrderFragment_ViewBinding implements Unbinder {
  private SubmitOrderFragment target;

  private View view2131296679;

  private View view2131296684;

  private View view2131296668;

  private View view2131296675;

  private View view2131296677;

  @UiThread
  public SubmitOrderFragment_ViewBinding(final SubmitOrderFragment target, View source) {
    this.target = target;

    View view;
    target.mGoodsPayNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_number_tx, "field 'mGoodsPayNumberTx'", TextView.class);
    target.mGoodsImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_img, "field 'mGoodsImg'", ImageView.class);
    target.mGoodsTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_title_img, "field 'mGoodsTitleTx'", TextView.class);
    target.mGoodsContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_content_tx, "field 'mGoodsContentTx'", TextView.class);
    target.mGoodsPriceTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_price_tx, "field 'mGoodsPriceTx'", TextView.class);
    target.mGoodPostageTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_postage_tx, "field 'mGoodPostageTx'", TextView.class);
    target.mGoodsPayAllMoneyTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_goods_pay_money_tx, "field 'mGoodsPayAllMoneyTx'", TextView.class);
    target.mAddressNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_order_name_tx, "field 'mAddressNameTx'", TextView.class);
    target.mAddressPhoneTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_order_phone_tx, "field 'mAddressPhoneTx'", TextView.class);
    target.mAddressContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_order_address_tx, "field 'mAddressContentTx'", TextView.class);
    target.mHaveAddressLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_order_have_address_ly, "field 'mHaveAddressLy'", LinearLayout.class);
    target.mNoHaceAddressLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_submit_order_no_have_address_ly, "field 'mNoHaceAddressLy'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_submit_order_back_img, "method 'toBack'");
    view2131296679 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_submit_order_submit_rl, "method 'toPayOrder'");
    view2131296684 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toPayOrder();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_submit_goods_add_number_img, "method 'toAddPayNumber'");
    view2131296668 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toAddPayNumber();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_submit_goods_remove_number_img, "method 'toRemoPayNumber'");
    view2131296675 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toRemoPayNumber();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_submit_order_address_ly, "method 'toUpdateAddressLy'");
    view2131296677 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toUpdateAddressLy();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SubmitOrderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mGoodsPayNumberTx = null;
    target.mGoodsImg = null;
    target.mGoodsTitleTx = null;
    target.mGoodsContentTx = null;
    target.mGoodsPriceTx = null;
    target.mGoodPostageTx = null;
    target.mGoodsPayAllMoneyTx = null;
    target.mAddressNameTx = null;
    target.mAddressPhoneTx = null;
    target.mAddressContentTx = null;
    target.mHaveAddressLy = null;
    target.mNoHaceAddressLy = null;

    view2131296679.setOnClickListener(null);
    view2131296679 = null;
    view2131296684.setOnClickListener(null);
    view2131296684 = null;
    view2131296668.setOnClickListener(null);
    view2131296668 = null;
    view2131296675.setOnClickListener(null);
    view2131296675 = null;
    view2131296677.setOnClickListener(null);
    view2131296677 = null;
  }
}
