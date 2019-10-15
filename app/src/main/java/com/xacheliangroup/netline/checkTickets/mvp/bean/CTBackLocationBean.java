package com.xacheliangroup.netline.checkTickets.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

/**
 * author:yz
 * data: 2019/6/12,14:54
 */
public class CTBackLocationBean extends BaseBean {

    /**
     * opertype : 1
     * success : true
     */

    private String opertype;
    private String success;

    public String getOpertype() {
        return opertype;
    }

    public void setOpertype(String opertype) {
        this.opertype = opertype;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
