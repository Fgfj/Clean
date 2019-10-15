// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

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

public class MarketingListFragment_ViewBinding implements Unbinder {
  private MarketingListFragment target;

  private View view2131296583;

  @UiThread
  public MarketingListFragment_ViewBinding(final MarketingListFragment target, View source) {
    this.target = target;

    View view;
    target.mTopTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_list_top_title_Tx, "field 'mTopTitleTx'", TextView.class);
    target.mTopDesTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_list_top_des_tx, "field 'mTopDesTx'", TextView.class);
    target.mTopImg = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_list_top_img, "field 'mTopImg'", ImageView.class);
    target.mGoodsRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_list_goods_rv, "field 'mGoodsRecyclerView'", RecyclerView.class);
    target.mSellerRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_marketing_list_seller_rv, "field 'mSellerRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_marketing_list_back_img, "method 'toBack'");
    view2131296583 = view;
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
    MarketingListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTopTitleTx = null;
    target.mTopDesTx = null;
    target.mTopImg = null;
    target.mGoodsRecyclerView = null;
    target.mSellerRecyclerView = null;

    view2131296583.setOnClickListener(null);
    view2131296583 = null;
  }
}
