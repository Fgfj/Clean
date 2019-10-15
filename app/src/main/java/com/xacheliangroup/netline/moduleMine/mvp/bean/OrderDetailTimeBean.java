package com.xacheliangroup.netline.moduleMine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.flag.ViewItemType;

/**
 * author:yz
 * data: 2019/2/28,16:17
 */
public class OrderDetailTimeBean extends BaseBean {
    @Override
    public int getViewType() {
        return ViewItemType.ORDER_DETAIL_TIME_ITEM_VIEW;
    }
    private String title;
    private boolean isShowLine;

    public OrderDetailTimeBean(String title,  boolean isShowLine) {
        this.title = title;
        this.isShowLine = isShowLine;
    }

    public boolean isShowLine() {
        return isShowLine;
    }

    public void setShowLine(boolean showLine) {
        isShowLine = showLine;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
