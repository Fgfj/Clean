package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.flag.ViewItemType;

import java.util.List;

/**
 * author:yz
 * data: 2019/10/15,11:20
 */
public class TicketListBean extends BaseBean {
    /**
     * orderid : 50
     * userid : 1
     * openid : oZGE_5fndXGSI1cBP33fimBqTsng
     * createtime : 2019-09-25 15:18:04
     * orderprice : 0.01
     * starcity : 西安
     * starcityid : 1
     * staradress : 西安市·北大街
     * starcoords : 34.276388,108.953543
     * endcity : 渭南
     * endcityid : 2
     * endaddress : 渭南市·宏通中寄联校
     * endcoords : 34.509552,109.522675
     * startdate : 09月25日
     * starttimefirst : 16:00
     * starttimesecond : 16:30
     * status : 5
     * type : 4
     * ordernumber : CJZTC2019092515180400000
     * paymoney : null
     * paytime : null
     * updatetime : null
     * backmoney : null
     * backpoundage : null
     * lineid : 2
     * carid : null
     * driverid : null
     * ordermobile : 17681552082
     * waterno : null
     * arrivetime : null
     * hxtime : null
     * remark : null
     * recordid : null
     * peoplenum : 1
     * usernames : null
     * ticket : [{"ticketid":9,"userid":1,"orderid":50,"fareid":1,"ticketno":"D3015693958842288","ticketprice":50,"createtime":"2019-09-25 15:18:04","status":1,"updatetime":"2019-09-25 15:18:04","palxslfare":{"fareid":1,"userid":null,"openid":null,"createtime":null,"farename":"姚琪","idcard":"612525199410175614","status":null,"mobile":"17681552082"},"palxslorder":null}]
     * palxSldriver : null
     * palxSlcar : null
     * commentid : null
     * realname : null
     * mobile : null
     * idcard : null
     * carnumber : null
     * orderdiscount : 100
     * ifchildren : null
     * ifservice : null
     * pdid : null
     * ifcoupons : null
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
    private Object updatetime;
    private Object backmoney;
    private Object backpoundage;
    private int lineid;
    private Object carid;
    private Object driverid;
    private String ordermobile;
    private Object waterno;
    private Object arrivetime;
    private Object hxtime;
    private String remark;
    private Object recordid;
    private int peoplenum;
    private Object usernames;
    private Object palxSldriver;
    private Object palxSlcar;
    private Object commentid;
    private Object realname;
    private Object mobile;
    private Object idcard;
    private Object carnumber;
    private int orderdiscount;
    private Object ifchildren;
    private Object ifservice;
    private Object pdid;
    private Object ifcoupons;
    private List<TicketBean> ticket;



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

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Object updatetime) {
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

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public Object getCarid() {
        return carid;
    }

    public void setCarid(Object carid) {
        this.carid = carid;
    }

    public Object getDriverid() {
        return driverid;
    }

    public void setDriverid(Object driverid) {
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

    public Object getRecordid() {
        return recordid;
    }

    public void setRecordid(Object recordid) {
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

    public Object getCommentid() {
        return commentid;
    }

    public void setCommentid(Object commentid) {
        this.commentid = commentid;
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

    public int getOrderdiscount() {
        return orderdiscount;
    }

    public void setOrderdiscount(int orderdiscount) {
        this.orderdiscount = orderdiscount;
    }

    public Object getIfchildren() {
        return ifchildren;
    }

    public void setIfchildren(Object ifchildren) {
        this.ifchildren = ifchildren;
    }

    public Object getIfservice() {
        return ifservice;
    }

    public void setIfservice(Object ifservice) {
        this.ifservice = ifservice;
    }

    public Object getPdid() {
        return pdid;
    }

    public void setPdid(Object pdid) {
        this.pdid = pdid;
    }

    public Object getIfcoupons() {
        return ifcoupons;
    }

    public void setIfcoupons(Object ifcoupons) {
        this.ifcoupons = ifcoupons;
    }

    public List<TicketBean> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketBean> ticket) {
        this.ticket = ticket;
    }

    public static class TicketBean  extends BaseBean{
        @Override
        public int getViewType() {
            return ViewItemType.NET_LINE_TICKET_LIST;
        }
        /**
         * ticketid : 9
         * userid : 1
         * orderid : 50
         * fareid : 1
         * ticketno : D3015693958842288
         * ticketprice : 50
         * createtime : 2019-09-25 15:18:04
         * status : 1
         * updatetime : 2019-09-25 15:18:04
         * palxslfare : {"fareid":1,"userid":null,"openid":null,"createtime":null,"farename":"姚琪","idcard":"612525199410175614","status":null,"mobile":"17681552082"}
         * palxslorder : null
         */

        private int ticketid;
        private int userid;
        private int orderid;
        private int fareid;
        private String ticketno;
        private int ticketprice;
        private String createtime;
        private int status;
        private String updatetime;
        private PalxslfareBean palxslfare;
        private Object palxslorder;

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

        public int getTicketprice() {
            return ticketprice;
        }

        public void setTicketprice(int ticketprice) {
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

        public Object getPalxslorder() {
            return palxslorder;
        }

        public void setPalxslorder(Object palxslorder) {
            this.palxslorder = palxslorder;
        }

        public static class PalxslfareBean {
            /**
             * fareid : 1
             * userid : null
             * openid : null
             * createtime : null
             * farename : 姚琪
             * idcard : 612525199410175614
             * status : null
             * mobile : 17681552082
             */

            private int fareid;
            private Object userid;
            private Object openid;
            private Object createtime;
            private String farename;
            private String idcard;
            private Object status;
            private String mobile;

            public int getFareid() {
                return fareid;
            }

            public void setFareid(int fareid) {
                this.fareid = fareid;
            }

            public Object getUserid() {
                return userid;
            }

            public void setUserid(Object userid) {
                this.userid = userid;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public Object getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Object createtime) {
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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
    }
}
