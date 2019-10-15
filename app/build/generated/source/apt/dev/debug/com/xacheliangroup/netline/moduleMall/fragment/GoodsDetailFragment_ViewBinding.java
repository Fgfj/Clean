// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GoodsDetailFragment_ViewBinding implements Unbinder {
  private GoodsDetailFragment target;

  private View view2131296500;

  private View view2131296503;

  @UiThread
  public GoodsDetailFragment_ViewBinding(final GoodsDetailFragment target, View source) {
    this.target = target;

    View view;
    target.mGoodsContentTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_content_tx, "field 'mGoodsContentTx'", TextView.class);
    target.mGoodsNameTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_title_tx, "field 'mGoodsNameTx'", TextView.class);
    target.mGoodsPriceTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_price_tx, "field 'mGoodsPriceTx'", TextView.class);
    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_top_title_tx, "field 'mTitleTx'", TextView.class);
    target.mBgTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_top_bg_tx, "field 'mBgTx'", TextView.class);
    target.mNestedScrollView = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_ns, "field 'mNestedScrollView'", NestedScrollView.class);
    target.mWebView = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_wv, "field 'mWebView'", WebView.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_vp, "field 'mViewPager'", ViewPager.class);
    target.mRadioGroup = Utils.findRequiredViewAsType(source, R.id.module_cbb_goods_detail_rg, "field 'mRadioGroup'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_goods_detail_back_img, "method 'toBack'");
    view2131296500 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_goods_detail_submit_rl, "method 'toSubmit'");
    view2131296503 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toSubmit();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    GoodsDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mGoodsContentTx = null;
    target.mGoodsNameTx = null;
    target.mGoodsPriceTx = null;
    target.mTitleTx = null;
    target.mBgTx = null;
    target.mNestedScrollView = null;
    target.mWebView = null;
    target.mViewPager = null;
    target.mRadioGroup = null;

    view2131296500.setOnClickListener(null);
    view2131296500 = null;
    view2131296503.setOnClickListener(null);
    view2131296503 = null;
  }
}
