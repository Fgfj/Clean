package com.xacheliangroup.netline.moduleMall.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.flag.ViewItemType;

/**
 * author:yz
 * data: 2019/2/19,11:09
 */
public class StarItemBean extends BaseBean {
    @Override
    public int getViewType() {
        return ViewItemType.STAR_ITEM_VIEW;
    }
    public boolean isLight;

    public StarItemBean(boolean isLight) {
        this.isLight = isLight;
    }

    public boolean isLight() {
        return isLight;
    }

    public void setLight(boolean light) {
        isLight = light;
    }
}
