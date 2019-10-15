package com.xacheliangroup.netline.moduleNetLine.mvp.bean;

import com.xacheliangroup.netline.common.base.BaseBean;

import java.util.List;

/**
 * author:yz
 * data: 2019/10/15,16:44
 */
public class NetLinePersonBean extends BaseBean {

    /**
     * drivername : 于宙
     * parkandhotel : {"hotelList":[{"hotecode":"34.273246,108.874363"}],"parkList":[{"parkocde":"34.274178,108.874531"}]}
     * serviceMobile : 0913-813-2222
     * monthnum : 5
     * fareAdjustmentnum : 3
     * daynum : 1
     */

    private String drivername;
    private ParkandhotelBean parkandhotel;
    private String serviceMobile;
    private int monthnum;
    private int fareAdjustmentnum;
    private int daynum;

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public ParkandhotelBean getParkandhotel() {
        return parkandhotel;
    }

    public void setParkandhotel(ParkandhotelBean parkandhotel) {
        this.parkandhotel = parkandhotel;
    }

    public String getServiceMobile() {
        return serviceMobile;
    }

    public void setServiceMobile(String serviceMobile) {
        this.serviceMobile = serviceMobile;
    }

    public int getMonthnum() {
        return monthnum;
    }

    public void setMonthnum(int monthnum) {
        this.monthnum = monthnum;
    }

    public int getFareAdjustmentnum() {
        return fareAdjustmentnum;
    }

    public void setFareAdjustmentnum(int fareAdjustmentnum) {
        this.fareAdjustmentnum = fareAdjustmentnum;
    }

    public int getDaynum() {
        return daynum;
    }

    public void setDaynum(int daynum) {
        this.daynum = daynum;
    }

    public static class ParkandhotelBean {
        private List<HotelListBean> hotelList;
        private List<ParkListBean> parkList;

        public List<HotelListBean> getHotelList() {
            return hotelList;
        }

        public void setHotelList(List<HotelListBean> hotelList) {
            this.hotelList = hotelList;
        }

        public List<ParkListBean> getParkList() {
            return parkList;
        }

        public void setParkList(List<ParkListBean> parkList) {
            this.parkList = parkList;
        }

        public static class HotelListBean {
            /**
             * hotecode : 34.273246,108.874363
             */

            private String hotecode;

            public String getHotecode() {
                return hotecode;
            }

            public void setHotecode(String hotecode) {
                this.hotecode = hotecode;
            }
        }

        public static class ParkListBean {
            /**
             * parkocde : 34.274178,108.874531
             */

            private String parkocde;

            public String getParkocde() {
                return parkocde;
            }

            public void setParkocde(String parkocde) {
                this.parkocde = parkocde;
            }
        }
    }
}
