package com.xacheliangroup.netline.common.base.pullrefresh.core;

/**
 * Created by funnyzhao on 2017/9/25.
 */

public interface OnPullListener {

    //执行刷新
    void onRefresh();

    //执行加载更多
    void onLoadMore();
}
