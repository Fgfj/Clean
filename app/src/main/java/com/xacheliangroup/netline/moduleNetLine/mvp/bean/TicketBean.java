package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

/**
 * author:yz
 * data: 2019/9/3,14:21
 */
public class TicketBean extends BaseBean {

    /**
     * ticketid : 4
     * userid : 2
     * orderid : 4
     * fareid : 2
     * ticketno : D5615675778608234
     * ticketprice : 50.0
     * createtime : 2019-09-04 14:17:40
     * status : 1
     * updatetime : 2019-09-04 14:17:40
     * palxslfare : {"fareid":2,"userid":2,"openid":"oZGE_5fuDnpuxdbu4k9LQ1xS2lYs","createtime":"2019-09-04 14:14:49","farename":"朱攀","idcard":"612429198912025638","status":1,"mobile":"13619282611"}
     * palxslorder : {"orderid":4,"userid":2,"openid":"oZGE_5fuDnpuxdbu4k9LQ1xS2lYs","createtime":"2019-09-04 14:17:40","orderprice":0.01,"starcity":"西安","starcityid":1,"staradress":"西安市·五路口","starcoords":"34.276359,108.969331","endcity":"渭南","endcityid":2,"endaddress":"渭南市·高新幸福城","endcoords":"34.50698,109.4225","startdate":"09月07日","starttimefirst":"6:30","starttimesecond":"7:00","status":3,"type":1,"ordernumber":"CJZTC2019090414174000003","paymoney":null,"paytime":null,"updatetime":"2019-09-04 15:34:06","backmoney":null,"backpoundage":null,"lineid":null,"carid":1,"driverid":3,"ordermobile":"13619282611","waterno":null,"arrivetime":null,"hxtime":null,"remark":null,"recordid":4,"peoplenum":1,"usernames":null,"ticket":null,"palxSldriver":null,"palxSlcar":null,"comment":null,"realname":null,"mobile":null,"idcard":null,"carnumber":null}
     */

    private int ticketid;
    private int userid;
    private int orderid;
    private int fareid;
    private String ticketno;
    private double ticketprice;
    private String createtime;
    private int status;
    private String updatetime;
    private PalxslfareBean palxslfare;
    private PalxslorderBean palxslorder;

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getFareid() {
        return fareid;
    }

    public void setFareid(int fareid) {
        this.fareid = fareid;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public PalxslfareBean getPalxslfare() {
        return palxslfare;
    }

    public void setPalxslfare(PalxslfareBean palxslfare) {
        this.palxslfare = palxslfare;
    }

    public PalxslorderBean getPalxslorder() {
        return palxslorder;
    }

    public void setPalxslorder(PalxslorderBean palxslorder) {
        this.palxslorder = palxslorder;
    }

    public static class PalxslfareBean {
        /**
         * fareid : 2
         * userid : 2
         * openid : oZGE_5fuDnpuxdbu4k9LQ1xS2lYs
         * createtime : 2019-09-04 14:14:49
         * farename : 朱攀
         * idcard : 612429198912025638
         * status : 1
         * mobile : 13619282611
         */

        private int fareid;
        private int userid;
        private String openid;
        private String createtime;
        private String farename;
        private String idcard;
        private int status;
        private String mobile;

        public int getFareid() {
            return fareid;
        }

        public void setFareid(int fareid) {
            this.fareid = fareid;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getFarename() {
            return farename;
        }

        public void setFarename(String farename) {
            this.farename = farename;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public static class PalxslorderBean {
        /**
         * orderid : 4
         * userid : 2
         * openid : oZGE_5fuDnpuxdbu4k9LQ1xS2lYs
         * createtime : 2019-09-04 14:17:40
         * orderprice : 0.01
         * starcity : 西安
         * starcityid : 1
         * staradress : 西安市·五路口
         * starcoords : 34.276359,108.969331
         * endcity : 渭南
         * endcityid : 2
         * endaddress : 渭南市·高新幸福城
         * endcoords : 34.50698,109.4225
         * startdate : 09月07日
         * starttimefirst : 6:30
         * starttimesecond : 7:00
         * status : 3
         * type : 1  4包车
         * ordernumber : CJZTC2019090414174000003
         * paymoney : null
         * paytime : null
         * updatetime : 2019-09-04 15:34:06
         * backmoney : null
         * backpoundage : null
         * lineid : null
         * carid : 1
         * driverid : 3
         * ordermobile : 13619282611
         * waterno : null
         * arrivetime : null
         * hxtime : null
         * remark : null
         * recordid : 4
         * peoplenum : 1  乘坐人数
         * usernames : null
         * ticket : null
         * palxSldriver : null
         * palxSlcar : null
         * comment : null
         * realname : null
         * mobile : null
         * idcard : null
         * carnumber : null
         */

        private int orderid;
        private int userid;
        private String openid;
        private String createtime;
        private double orderprice;
        private String starcity;
        private int starcityid;
        private String staradress;
        private String starcoords;
        private String endcity;
        private int endcityid;
        private String endaddress;
        private String endcoords;
        private String startdate;
        private String starttimefirst;
        private String starttimesecond;
        private int status;
        private int type;
        private String ordernumber;
        private Object paymoney;
        private Object paytime;
        private String updatetime;
        private Object backmoney;
        private Object backpoundage;
        private Object lineid;
        private int carid;
        private int driverid;
        private String ordermobile;
        private Object waterno;
        private Object arrivetime;
        private Object hxtime;
        private String remark;
        private int recordid;
        private int peoplenum;
        private Object usernames;
        private Object ticket;
        private Object palxSldriver;
        private Object palxSlcar;
        private Object comment;
        private Object realname;
        private Object mobile;
        private Object idcard;
        private Object carnumber;

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public double getOrderprice() {
            return orderprice;
        }

        public void setOrderprice(double orderprice) {
            this.orderprice = orderprice;
        }

        public String getStarcity() {
            return starcity;
        }

        public void setStarcity(String starcity) {
            this.starcity = starcity;
        }

        public int getStarcityid() {
            return starcityid;
        }

        public void setStarcityid(int starcityid) {
            this.starcityid = starcityid;
        }

        public String getStaradress() {
            return staradress;
        }

        public void setStaradress(String staradress) {
            this.staradress = staradress;
        }

        public String getStarcoords() {
            return starcoords;
        }

        public void setStarcoords(String starcoords) {
            this.starcoords = starcoords;
        }

        public String getEndcity() {
            return endcity;
        }

        public void setEndcity(String endcity) {
            this.endcity = endcity;
        }

        public int getEndcityid() {
            return endcityid;
        }

        public void setEndcityid(int endcityid) {
            this.endcityid = endcityid;
        }

        public String getEndaddress() {
            return endaddress;
        }

        public void setEndaddress(String endaddress) {
            this.endaddress = endaddress;
        }

        public String getEndcoords() {
            return endcoords;
        }

        public void setEndcoords(String endcoords) {
            this.endcoords = endcoords;
        }

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public String getStarttimefirst() {
            return starttimefirst;
        }

        public void setStarttimefirst(String starttimefirst) {
            this.starttimefirst = starttimefirst;
        }

        public String getStarttimesecond() {
            return starttimesecond;
        }

        public void setStarttimesecond(String starttimesecond) {
            this.starttimesecond = starttimesecond;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrdernumber() {
            return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
            this.ordernumber = ordernumber;
        }

        public Object getPaymoney() {
            return paymoney;
        }

        public void setPaymoney(Object paymoney) {
            this.paymoney = paymoney;
        }

        public Object getPaytime() {
            return paytime;
        }

        public void setPaytime(Object paytime) {
            this.paytime = paytime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public Object getBackmoney() {
            return backmoney;
        }

        public void setBackmoney(Object backmoney) {
            this.backmoney = backmoney;
        }

        public Object getBackpoundage() {
            return backpoundage;
        }

        public void setBackpoundage(Object backpoundage) {
            this.backpoundage = backpoundage;
        }

        public Object getLineid() {
            return lineid;
        }

        public void setLineid(Object lineid) {
            this.lineid = lineid;
        }

        public int getCarid() {
            return carid;
        }

        public void setCarid(int carid) {
            this.carid = carid;
        }

        public int getDriverid() {
            return driverid;
        }

        public void setDriverid(int driverid) {
            this.driverid = driverid;
        }

        public String getOrdermobile() {
            return ordermobile;
        }

        public void setOrdermobile(String ordermobile) {
            this.ordermobile = ordermobile;
        }

        public Object getWaterno() {
            return waterno;
        }

        public void setWaterno(Object waterno) {
            this.waterno = waterno;
        }

        public Object getArrivetime() {
            return arrivetime;
        }

        public void setArrivetime(Object arrivetime) {
            this.arrivetime = arrivetime;
        }

        public Object getHxtime() {
            return hxtime;
        }

        public void setHxtime(Object hxtime) {
            this.hxtime = hxtime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getRecordid() {
            return recordid;
        }

        public void setRecordid(int recordid) {
            this.recordid = recordid;
        }

        public int getPeoplenum() {
            return peoplenum;
        }

        public void setPeoplenum(int peoplenum) {
            this.peoplenum = peoplenum;
        }

        public Object getUsernames() {
            return usernames;
        }

        public void setUsernames(Object usernames) {
            this.usernames = usernames;
        }

        public Object getTicket() {
            return ticket;
        }

        public void setTicket(Object ticket) {
            this.ticket = ticket;
        }

        public Object getPalxSldriver() {
            return palxSldriver;
        }

        public void setPalxSldriver(Object palxSldriver) {
            this.palxSldriver = palxSldriver;
        }

        public Object getPalxSlcar() {
            return palxSlcar;
        }

        public void setPalxSlcar(Object palxSlcar) {
            this.palxSlcar = palxSlcar;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public Object getRealname() {
            return realname;
        }

        public void setRealname(Object realname) {
            this.realname = realname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getIdcard() {
            return idcard;
        }

        public void setIdcard(Object idcard) {
            this.idcard = idcard;
        }

        public Object getCarnumber() {
            return carnumber;
        }

        public void setCarnumber(Object carnumber) {
            this.carnumber = carnumber;
        }
    }
}
