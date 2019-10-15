package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.flag.ViewItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * author:yz
 * data: 2019/9/26,10:12
 */
public class LockSeatBean extends BaseBean {
    public static List<LockSeatBean> getLockSeatBean(String[] a){
        List<LockSeatBean> lockSeatBeans=new ArrayList<>();
        for(String s :a){
            lockSeatBeans.add(new LockSeatBean(s));
        }
        return lockSeatBeans;
    }
    public static List<LockSeatBean> setBlue(List<LockSeatBean> lockSeatBeans,int postion ){
        for(LockSeatBean lockSeatBean :lockSeatBeans){
            lockSeatBean.setShowBlue(false);
        }
        lockSeatBeans.get(postion).setShowBlue(true);
        return lockSeatBeans;
    }


    public LockSeatBean(String setNum) {
        this.setNum = setNum;
        this.isShowBlue=false;
    }

    @Override
    public int getViewType() {
        return ViewItemType.NET_LINE_LOCK_SEAT;
    }
    private String setNum;
    private  boolean isShowBlue;

    public boolean isShowBlue() {
        return isShowBlue;
    }

    public void setShowBlue(boolean showBlue) {
        isShowBlue = showBlue;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }
}
