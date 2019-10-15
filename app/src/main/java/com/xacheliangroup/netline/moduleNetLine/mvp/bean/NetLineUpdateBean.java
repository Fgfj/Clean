package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

/**
 * author:yz
 * data: 2019/9/5,14:37
 */
public class NetLineUpdateBean extends BaseBean {

    /**
     * editionid : 4
     * addtime : 2018-10-01 11:57:52
     * url : www.baidu.com
     * editioncode : 1.0.0.2
     * forces : 2
     */

    private int editionid;
    private String addtime;
    private String url;
    private String editioncode;
    private int forces;

    public int getEditionid() {
        return editionid;
    }

    public void setEditionid(int editionid) {
        this.editionid = editionid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEditioncode() {
        return editioncode;
    }

    public void setEditioncode(String editioncode) {
        this.editioncode = editioncode;
    }

    public int getForces() {
        return forces;
    }

    public void setForces(int forces) {
        this.forces = forces;
    }
}
