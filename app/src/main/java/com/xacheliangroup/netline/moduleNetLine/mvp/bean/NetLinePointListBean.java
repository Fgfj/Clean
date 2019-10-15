package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

import java.util.List;

/**
 * author:yz
 * data: 2019/9/3,11:02
 */
public class NetLinePointListBean extends BaseBean {


    private List<OnLoactionBean> onLoaction;
    private List<DowLoactionBean> dowLoaction;

    public List<OnLoactionBean> getOnLoaction() {
        return onLoaction;
    }

    public void setOnLoaction(List<OnLoactionBean> onLoaction) {
        this.onLoaction = onLoaction;
    }

    public List<DowLoactionBean> getDowLoaction() {
        return dowLoaction;
    }

    public void setDowLoaction(List<DowLoactionBean> dowLoaction) {
        this.dowLoaction = dowLoaction;
    }

    public static class OnLoactionBean extends BaseBean{
        private String ordermobile;

        public String getOrdermobile() {
            return ordermobile;
        }

        public void setOrdermobile(String ordermobile) {
            this.ordermobile = ordermobile;
        }

        /**
         * onLoactionweizhi : 34.283494,108.969122
         */

        private String onLoactionweizhi;

        public String getOnLoactionweizhi() {
            return onLoactionweizhi;
        }

        public void setOnLoactionweizhi(String onLoactionweizhi) {
            this.onLoactionweizhi = onLoactionweizhi;
        }
    }

    public static class DowLoactionBean extends BaseBean{
        /**
         * dowLoactionweizhi : 34.509144,109.505081
         */

        private String dowLoactionweizhi;
        private String ordermobile;

        public String getOrdermobile() {
            return ordermobile;
        }

        public void setOrdermobile(String ordermobile) {
            this.ordermobile = ordermobile;
        }

        public String getDowLoactionweizhi() {
            return dowLoactionweizhi;
        }

        public void setDowLoactionweizhi(String dowLoactionweizhi) {
            this.dowLoactionweizhi = dowLoactionweizhi;
        }
    }
}
