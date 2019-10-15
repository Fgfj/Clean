// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMine.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderDetailFragment_ViewBinding implements Unbinder {
  private OrderDetailFragment target;

  private View view2131296625;

  private View view2131296627;

  private View view2131296629;

  private View view2131296589;

  @UiThread
  public OrderDetailFragment_ViewBinding(final OrderDetailFragment target, View source) {
    this.target = target;

    View view;
    target.mTimeRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_time_rv, "field 'mTimeRecyclerView'", RecyclerView.class);
    target.mMoneyRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_money_rv, "field 'mMoneyRecyclerView'", RecyclerView.class);
    target.mGetGoodsNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_get_user_name_tx, "field 'mGetGoodsNameTx'", TextView.class);
    target.mGetGoodsAddressTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_get_user_address_tx, "field 'mGetGoodsAddressTx'", TextView.class);
    target.mGoodsNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_goods_name_tx, "field 'mGoodsNameTx'", TextView.class);
    target.mGoodsContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_goods_content_tx, "field 'mGoodsContentTx'", TextView.class);
    target.mGoodsImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_goods_img, "field 'mGoodsImg'", ImageView.class);
    target.mGoodsNumberTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_goods_number_tx, "field 'mGoodsNumberTx'", TextView.class);
    target.mGoodsMoneyTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_goods_money_tx, "field 'mGoodsMoneyTx'", TextView.class);
    target.mMailTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_mail_tx, "field 'mMailTx'", TextView.class);
    target.mMailLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_mail_rl, "field 'mMailLy'", LinearLayout.class);
    target.mMailTopTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_mail_top_tx, "field 'mMailTopTx'", TextView.class);
    target.mTopTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mine_order_detail_top_title_tx, "field 'mTopTitleTx'", TextView.class);
    target.mBottomAllRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_submit_all_rl, "field 'mBottomAllRl'", RelativeLayout.class);
    target.mTwoBottomLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_submit_two_rl, "field 'mTwoBottomLy'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_order_detail_submit_one_rl, "field 'mOneBottomRl' and method 'toOneBottomOnclick'");
    target.mOneBottomRl = Utils.castView(view, R.id.module_cbb_order_detail_submit_one_rl, "field 'mOneBottomRl'", RelativeLayout.class);
    view2131296625 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toOneBottomOnclick();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_order_detail_submit_two_left_rl, "field 'mTwoLeftBottomRl' and method 'toTwoBottomOnclick'");
    target.mTwoLeftBottomRl = Utils.castView(view, R.id.module_cbb_order_detail_submit_two_left_rl, "field 'mTwoLeftBottomRl'", RelativeLayout.class);
    view2131296627 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toTwoBottomOnclick();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_order_detail_submit_two_right_rl, "field 'mTwoRightBottomRl' and method 'toThreeBottomOnclick'");
    target.mTwoRightBottomRl = Utils.castView(view, R.id.module_cbb_order_detail_submit_two_right_rl, "field 'mTwoRightBottomRl'", RelativeLayout.class);
    view2131296629 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toThreeBottomOnclick();
      }
    });
    target.mOneTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_submit_one_tx, "field 'mOneTx'", TextView.class);
    target.mTwoTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_submit_two_left_tx, "field 'mTwoTx'", TextView.class);
    target.mThreeTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_order_detail_submit_two_right_tx, "field 'mThreeTx'", TextView.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_mine_order_detail_back_fl, "method 'toBack'");
    view2131296589 = view;
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
    OrderDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTimeRecyclerView = null;
    target.mMoneyRecyclerView = null;
    target.mGetGoodsNameTx = null;
    target.mGetGoodsAddressTx = null;
    target.mGoodsNameTx = null;
    target.mGoodsContentTx = null;
    target.mGoodsImg = null;
    target.mGoodsNumberTx = null;
    target.mGoodsMoneyTx = null;
    target.mMailTx = null;
    target.mMailLy = null;
    target.mMailTopTx = null;
    target.mTopTitleTx = null;
    target.mBottomAllRl = null;
    target.mTwoBottomLy = null;
    target.mOneBottomRl = null;
    target.mTwoLeftBottomRl = null;
    target.mTwoRightBottomRl = null;
    target.mOneTx = null;
    target.mTwoTx = null;
    target.mThreeTx = null;

    view2131296625.setOnClickListener(null);
    view2131296625 = null;
    view2131296627.setOnClickListener(null);
    view2131296627 = null;
    view2131296629.setOnClickListener(null);
    view2131296629 = null;
    view2131296589.setOnClickListener(null);
    view2131296589 = null;
  }
}
