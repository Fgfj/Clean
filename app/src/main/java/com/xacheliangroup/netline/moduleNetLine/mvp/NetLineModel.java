package com.xacheliangroup.netline.moduleNetLine.mvp;

import com.xacheliangroup.netline.moduleMine.mvp.bean.AddressItemBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.CarStatusBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.ChangeCarTypeBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.CheckTicketBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LockSeatRepBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.LoginBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineCarListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineCheckDiverTimeBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineHistoryBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLinePersonBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLinePointListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUpdateBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLineUserListBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.PostCarBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.QrCodeBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.TicketBean;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.TicketListBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * author:yz
 * data: 2019/9/2,16:43
 */
public interface NetLineModel {
    /**
     * 登录
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSldriverJson/land")
    Observable<LoginBean> toGetAddressListData(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);

    /**
     * 绑定车辆
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlcarJson/bindingCar")
    Observable<LoginBean.CarsBean> toBindCar(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 获取用户列表
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/intransit")
    Observable<NetLineUserListBean> toGetUserList(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 获取坐标点集合
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlorderJson/findfareLoaction")
    Observable<NetLinePointListBean> toGetPointList(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 扫描二维码获取信息
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlticketJson/ticketdetails")
    Observable<TicketBean> toTicketInfo(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 检票上车
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlticketJson/writeoff")
    Observable<Object> toCheck(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);

    /**
     * 线路查询
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSllineJson/findAllLine")
    Observable<List<NetLineCarListBean>> toSelectLineList(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 报班
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/newspaper")
    Observable<PostCarBean> toPostCar(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);

    /**
     * 出发送达
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/updatetransrecord")
    Observable<CarStatusBean> toGoAndSendOver(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 司机报修，休息，退出登录接口
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlcarJson/updateCarStauts")
    Observable<ChangeCarTypeBean> toChangeCarType(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);



    /**
     * 记录查询
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/list")
    Observable<List<NetLineListBean>> toSelectHistory(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);

    /**
     * 上车
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlorderJson/DriverArrive")
    Observable<Object> toUpCar(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 查询车辆信息
     * @param queryMap
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlcarJson/findcar")
    Observable<LoginBean.CarsBean> toGetCarDetail(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);



    /**
     * 获取补票二维码
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/getwxacodeunlimit")
    Observable<QrCodeBean> toQrCodeData(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);




    /**
     * 版本跟新
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSleditionJson/findedition")
    Observable<NetLineUpdateBean> toNetLineUpdate(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 上传车辆坐标
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSllocationJson/updatelocation")
    Observable<Object> toUpdateLocation(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);



    /**
     * 两单一怔
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSldriverJson/Certificate_verificationCar")
    Observable<NetLineCheckDiverTimeBean> toCheckDiverData(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);


    /**
     * 锁定座位
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/driveraddbusnumber")
    Observable<LockSeatRepBean> toLockSeat(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);



    /**
     * 事故
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlaccidentJson/add")
    Observable<Object> toSafeQuestionPost(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);

    /**
     * 单人送达
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlorderJson/updateService")
    Observable<Object> toSendOver(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 取消报班
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/cancelTransrecord")
    Observable<Object> toCancelLine(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 更具订单id查询票列表
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSlorderJson/orderdetails")
    Observable<TicketListBean> toGetTicketListDataForOrderId(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
    /**
     * 更具订单id查询票列表
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("intfaceJson/PalxSltransrecordJson/PersonalCenter")
    Observable<NetLinePersonBean> toGetPersonData(@QueryMap Map<String, Object> queryMap, @FieldMap Map<String, String> map);
}
