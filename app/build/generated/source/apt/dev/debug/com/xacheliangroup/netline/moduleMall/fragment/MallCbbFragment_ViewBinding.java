// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleMall.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.superluo.textbannerlibrary.TextBannerView;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MallCbbFragment_ViewBinding implements Unbinder {
  private MallCbbFragment target;

  private View view2131296540;

  private View view2131296541;

  private View view2131296542;

  private View view2131296543;

  private View view2131296544;

  private View view2131296545;

  private View view2131296546;

  private View view2131296547;

  private View view2131296548;

  private View view2131296549;

  @UiThread
  public MallCbbFragment_ViewBinding(final MallCbbFragment target, View source) {
    this.target = target;

    View view;
    target.mFourFunRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_four_fun_rv, "field 'mFourFunRecyclerView'", RecyclerView.class);
    target.mTopLineTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_line_tx, "field 'mTopLineTx'", TextView.class);
    target.mTopBlackGradientTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_black_gradient_rl, "field 'mTopBlackGradientTx'", TextView.class);
    target.mTopFilterLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_filter_ly, "field 'mTopFilterLy'", LinearLayout.class);
    target.mScrollFilterLy = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_filter_sc_ly, "field 'mScrollFilterLy'", LinearLayout.class);
    target.mGoodsRadioGroup = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_goods_rg, "field 'mGoodsRadioGroup'", RadioGroup.class);
    target.mGoodsViewPage = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_goods_vp, "field 'mGoodsViewPage'", ViewPager.class);
    target.mTxBannerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_news_tbv, "field 'mTxBannerView'", TextBannerView.class);
    target.mTitleTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_title_tx, "field 'mTitleTx'", TextView.class);
    target.mNestedScrollView = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_ns, "field 'mNestedScrollView'", NestedScrollView.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_vp, "field 'mViewPager'", ViewPager.class);
    target.mRadioGroup = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_rg, "field 'mRadioGroup'", RadioGroup.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_rv, "field 'mRecyclerView'", RecyclerView.class);
    target.mBgTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_bg_tx, "field 'mBgTx'", TextView.class);
    target.mStatusBarTx = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_top_status_Bar_tx, "field 'mStatusBarTx'", TextView.class);
    target.mAppBarRl = Utils.findRequiredViewAsType(source, R.id.module_cbb_mall_home_appbar_rl, "field 'mAppBarRl'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_1_Tx, "field 'mFilter1Tx' and method 'toGetFilter1Data'");
    target.mFilter1Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_1_Tx, "field 'mFilter1Tx'", TextView.class);
    view2131296540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter1Data();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_2_Tx, "field 'mFilter2Tx' and method 'toGetFilter2Data'");
    target.mFilter2Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_2_Tx, "field 'mFilter2Tx'", TextView.class);
    view2131296541 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter2Data();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_3_Tx, "field 'mFilter3Tx' and method 'toGetFilter3Data'");
    target.mFilter3Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_3_Tx, "field 'mFilter3Tx'", TextView.class);
    view2131296542 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter3Data();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_4_Tx, "field 'mFilter4Tx' and method 'toGetFilter4Data'");
    target.mFilter4Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_4_Tx, "field 'mFilter4Tx'", TextView.class);
    view2131296543 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter4Data();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_5_Tx, "field 'mFilter5Tx' and method 'toGetFilter5ata'");
    target.mFilter5Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_5_Tx, "field 'mFilter5Tx'", TextView.class);
    view2131296544 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter5ata();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_top_1_Tx, "field 'mFilterTop1Tx' and method 'toGetFilter1DataTop'");
    target.mFilterTop1Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_top_1_Tx, "field 'mFilterTop1Tx'", TextView.class);
    view2131296545 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter1DataTop();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_top_2_Tx, "field 'mFilterTop2Tx' and method 'toGetFilter2DataTop'");
    target.mFilterTop2Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_top_2_Tx, "field 'mFilterTop2Tx'", TextView.class);
    view2131296546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter2DataTop();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_top_3_Tx, "field 'mFilterTop3Tx' and method 'toGetFilter3DataTop'");
    target.mFilterTop3Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_top_3_Tx, "field 'mFilterTop3Tx'", TextView.class);
    view2131296547 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter3DataTop();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_top_4_Tx, "field 'mFilterTop4Tx' and method 'toGetFilter4DataTop'");
    target.mFilterTop4Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_top_4_Tx, "field 'mFilterTop4Tx'", TextView.class);
    view2131296548 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter4DataTop();
      }
    });
    view = Utils.findRequiredView(source, R.id.module_cbb_mall_home_filter_top_5_Tx, "field 'mFilterTop5Tx' and method 'toGetFilter5ataTop'");
    target.mFilterTop5Tx = Utils.castView(view, R.id.module_cbb_mall_home_filter_top_5_Tx, "field 'mFilterTop5Tx'", TextView.class);
    view2131296549 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toGetFilter5ataTop();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MallCbbFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFourFunRecyclerView = null;
    target.mTopLineTx = null;
    target.mTopBlackGradientTx = null;
    target.mTopFilterLy = null;
    target.mScrollFilterLy = null;
    target.mGoodsRadioGroup = null;
    target.mGoodsViewPage = null;
    target.mTxBannerView = null;
    target.mTitleTx = null;
    target.mNestedScrollView = null;
    target.mViewPager = null;
    target.mRadioGroup = null;
    target.mRecyclerView = null;
    target.mBgTx = null;
    target.mStatusBarTx = null;
    target.mAppBarRl = null;
    target.mFilter1Tx = null;
    target.mFilter2Tx = null;
    target.mFilter3Tx = null;
    target.mFilter4Tx = null;
    target.mFilter5Tx = null;
    target.mFilterTop1Tx = null;
    target.mFilterTop2Tx = null;
    target.mFilterTop3Tx = null;
    target.mFilterTop4Tx = null;
    target.mFilterTop5Tx = null;

    view2131296540.setOnClickListener(null);
    view2131296540 = null;
    view2131296541.setOnClickListener(null);
    view2131296541 = null;
    view2131296542.setOnClickListener(null);
    view2131296542 = null;
    view2131296543.setOnClickListener(null);
    view2131296543 = null;
    view2131296544.setOnClickListener(null);
    view2131296544 = null;
    view2131296545.setOnClickListener(null);
    view2131296545 = null;
    view2131296546.setOnClickListener(null);
    view2131296546 = null;
    view2131296547.setOnClickListener(null);
    view2131296547 = null;
    view2131296548.setOnClickListener(null);
    view2131296548 = null;
    view2131296549.setOnClickListener(null);
    view2131296549 = null;
  }
}
