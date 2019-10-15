// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.moduleCarCircle.fragment.circleHomeFragmentList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.pullrefresh.RefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecommendCircleFragment_ViewBinding implements Unbinder {
  private RecommendCircleFragment target;

  @UiThread
  public RecommendCircleFragment_ViewBinding(RecommendCircleFragment target, View source) {
    this.target = target;

    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.module_Cbb_car_circle_recommend_rl, "field 'mRefreshLayout'", RefreshLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.module_Cbb_car_circle_recommend_rv, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecommendCircleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRefreshLayout = null;
    target.mRecyclerView = null;
  }
}
