package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

/**
 * author:yz
 * data: 2019/9/25,11:13
 */
public class NetLineCheckDiverTimeBean extends BaseBean {

    /**
     * msg : 证件正常
     * backtype : 0
     */

    private String msg;
    private String backtype;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBacktype() {
        return backtype;
    }

    public void setBacktype(String backtype) {
        this.backtype = backtype;
    }
}
