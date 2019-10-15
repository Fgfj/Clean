package com.xacheliangroup.netline.moduleNetLine.mvp;

import android.content.Context;

import com.xacheliangroup.netline.common.http.okhttp.BaseDisposableObserver;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.http.okhttp.RequestField;
import com.xacheliangroup.netline.common.http.okhttp.RequestQuery;
import com.xacheliangroup.netline.common.http.okhttp.RetrofitHelper;
import com.xacheliangroup.netline.common.http.okhttp.RxPresenter;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleMine.mvp.MineModel;
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

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.PUT;

/**
 * author:yz
 * data: 2019/9/2,16:43
 */
public class NetLinePresenter extends RxPresenter {

    NetLineModel model;
    public static final String TO_GET_PHONE_NUMBER="TO_GET_PHONE_NUMBER";

    public static final String TO_BIND_CAR="TO_BIND_CAR";

    public static final String TO_GET_USER_LIST="TO_GET_USER_LIST";

    public static final String TO_GET_POINT_LIST="TO_GET_POINT_LIST";

    public static final String TO_GET_TICKET_INFO="TO_GET_TICKET_INFO";

    public static final String TO_CHECK="TO_CHECK";

    public static final String TO_GET_CAR_LINE_LIST="TO_GET_CAR_LINE_LIST";

    public static final String TO_POST_CAR="TO_POST_CAR";

    public static final String TO_GO_ADN_SEND_OVER="TO_GO_ADN_SEND_OVER";

    public static final String TO_CHANGE_CAR_TYPE="TO_CHANGE_CAR_TYPE";

    public static final String TO_SELECT_HISTORY="TO_SELECT_HISTORY";

    public static final String TO_UP_CAR="TO_UP_CAR";

    public static final String TO_GET_CAR_DETAIL="TO_GET_CAR_DETAIL";

    public static final String TO_GET_QR_CODE="TO_GET_QR_CODE";

    public static final String TO_GET_NET_LINE_UPDATE_DATA="TO_GET_NET_LINE_UPDATE_DATA";

    public static final String TO_UPDATE_LOCATION="TO_UPDATE_LOCATION";

    public static final String TO_CHECK_DIVER_TIME_DATA="TO_CHECK_DIVER_TIME_DATA";

    public static final String TO_LOCK_SEAT="TO_LOCK_SEAT";

    public static final String TO_SAFE_QUESTION_POST="TO_SAFE_QUESTION_POST";

    public static final String TO_SEND_OVER="TO_SEND_OVER";

    public static final String TO_CANCEL_LINE="TO_CANCEL_LINE";

    public static final String TO_GET_TICKET_LIST_DATA="TO_GET_TICKET_LIST_DATA";

    public static final String TO_GET_PERSON_DATA="TO_GET_PERSON_DATA";
    public NetLinePresenter(Context context, IActionListener.ViewAction view) {
        super(context, view);
        model= RetrofitHelper.createService(NetLineModel.class);
    }
    public void toLogin(String phoneNumber,String passWord,String imei){
        model.toGetAddressListData(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("mobile", phoneNumber)
                        .withParam("passwd", passWord)
                        .withParam("imei", imei)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<LoginBean>() {

                    @Override
                    public void onSuccess(LoginBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_PHONE_NUMBER, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_PHONE_NUMBER, errorMsg);
                        }
                    }
                }));
    }
    public void toBindCar(String carNumber,int dId){
        model.toBindCar(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carnumber", carNumber)
                        .withParam("driverid", dId)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<LoginBean.CarsBean>() {

                    @Override
                    public void onSuccess(LoginBean.CarsBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_BIND_CAR, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_BIND_CAR, errorMsg);
                        }
                    }
                }));
    }

    public void toGetUserList(int carid,int driverid){
        model.toGetUserList(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", carid)
                        .withParam("driverid", driverid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<NetLineUserListBean>() {

                    @Override
                    public void onSuccess(NetLineUserListBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_USER_LIST, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_USER_LIST, errorMsg);
                        }
                    }
                }));
    }
    public void toGetPointList(String rid){
        model.toGetPointList(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("recordid", rid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<NetLinePointListBean>() {

                    @Override
                    public void onSuccess(NetLinePointListBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_POINT_LIST, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_POINT_LIST, null);
                        }
                    }
                }));
    }
    public void toTicketInfo(String code){
        model.toTicketInfo(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("ticketno", code)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<TicketBean>() {

                    @Override
                    public void onSuccess(TicketBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_TICKET_INFO, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_TICKET_INFO, null);
                        }
                    }
                }));
    }

    public void toCheck(String ticketid,String recordid){
        model.toCheck(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("ticketid", ticketid)
                        .withParam("recordid", recordid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHECK, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHECK, null);
                        }
                    }
                }));
    }
    public void toSelectLineList(){
        model.toSelectLineList(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<List<NetLineCarListBean>>() {

                    @Override
                    public void onSuccess(List<NetLineCarListBean> bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_CAR_LINE_LIST, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_CAR_LINE_LIST, null);
                        }
                    }
                }));
    }
    public void toPostCar(int cId,int dId,int lineId){
        model.toPostCar(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", cId)
                        .withParam("driverid", dId)
                        .withParam("lineid", lineId)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<PostCarBean>() {

                    @Override
                    public void onSuccess(PostCarBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_POST_CAR, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_POST_CAR, null);
                        }
                    }
                }));
    }
    public void toGoAndSendOver(int rId,String status,int cId){
        model.toGoAndSendOver(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("recordid", rId)
                        .withParam("status", status)
                        .withParam("carid", cId)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<CarStatusBean>() {

                    @Override
                    public void onSuccess(CarStatusBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GO_ADN_SEND_OVER, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GO_ADN_SEND_OVER, errorMsg);
                        }
                    }
                }));
    }
    public void toChangeCarType(int  cId,String type){
        model.toChangeCarType(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", cId)
                        .withParam("status", type)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<ChangeCarTypeBean>() {

                    @Override
                    public void onSuccess(ChangeCarTypeBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHANGE_CAR_TYPE, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHANGE_CAR_TYPE, errorMsg);
                        }
                    }
                }));
    }

    public void toSelectHistory(int cId,int dId,String mdate){
        model.toSelectHistory(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", cId)
                        .withParam("driverid", dId)
                        .withParam("mdate", mdate)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<List<NetLineListBean>>() {

                    @Override
                    public void onSuccess(List<NetLineListBean> bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SELECT_HISTORY, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SELECT_HISTORY, null);
                        }
                    }
                }));
    }
    public void toUpCar(String orderId){
        model.toUpCar(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("orderid", orderId)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_UP_CAR, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_UP_CAR, null);
                        }
                    }
                }));
    }
    public void toGetCarDetail(String cId){
        model.toGetCarDetail(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", cId)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<LoginBean.CarsBean>() {

                    @Override
                    public void onSuccess(LoginBean.CarsBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_CAR_DETAIL, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_CAR_DETAIL, null);
                        }
                    }
                }));
    }
    public void toQrCodeData(String rid,String nums){
        model.toQrCodeData(RequestQuery.getBuildInstance()
                        .withParam("recordid", rid)
                        .withParam("nums", nums)
                        .build()
                , RequestField.getBuilderInstance()
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<QrCodeBean>() {

                    @Override
                    public void onSuccess(QrCodeBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_QR_CODE, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_QR_CODE, null);
                        }
                    }
                }));
    }
    public void toNetLineUpdate(){
        model.toNetLineUpdate(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<NetLineUpdateBean>() {

                    @Override
                    public void onSuccess(NetLineUpdateBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_NET_LINE_UPDATE_DATA, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_NET_LINE_UPDATE_DATA, null);
                        }
                    }
                }));
    }
    public void toUpdateLocation(String carid,String location,String address){
        model.toUpdateLocation(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", carid)
                        .withParam("coords", location)
                        .withParam("address", address)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_UPDATE_LOCATION, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_UPDATE_LOCATION, null);
                        }
                    }
                }));
    }

    public void toCheckDiverData(String driverid,String carid){
        model.toCheckDiverData(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("driverid", driverid)
                        .withParam("carid", carid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<NetLineCheckDiverTimeBean>() {

                    @Override
                    public void onSuccess(NetLineCheckDiverTimeBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHECK_DIVER_TIME_DATA, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CHECK_DIVER_TIME_DATA, null);
                        }
                    }
                }));
    }

    public void toLockSeat(String recordid,String types,String nums){
        model.toLockSeat(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("recordid", recordid)
                        .withParam("types", types)
                        .withParam("nums", nums)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<LockSeatRepBean>() {

                    @Override
                    public void onSuccess(LockSeatRepBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_LOCK_SEAT, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_LOCK_SEAT, null);
                        }
                    }
                }));
    }
    public void toSafeQuestionPost(String carid,String recordid,String driverid){
        model.toSafeQuestionPost(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("carid", carid)
                        .withParam("recordid", recordid)
                        .withParam("driverid", driverid)
                        .withParam("remark", "1")
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SAFE_QUESTION_POST, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SAFE_QUESTION_POST, null);
                        }
                    }
                }));
    }
    public void toSendOver(String orderid){
        model.toSendOver(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("orderid", orderid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SEND_OVER, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_SEND_OVER, null);
                        }
                    }
                }));
    }

    public void toCancelLine(String recordid){
        model.toCancelLine(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("recordid", recordid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CANCEL_LINE, "SUCCESS");
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_CANCEL_LINE, null);
                        }
                    }
                }));
    }
    public void toGetTicketListDataForOrderId(String orderid){
        model.toGetTicketListDataForOrderId(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("orderid", orderid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<Object>() {

                    @Override
                    public void onSuccess(Object bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_TICKET_LIST_DATA, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_TICKET_LIST_DATA, null);
                        }
                    }
                }));
    }
    public void toGetPersonData(String driverid){
        model.toGetPersonData(RequestQuery.getBuildInstance()
                        .build()
                , RequestField.getBuilderInstance()
                        .withParam("driverid", driverid)
                        .build().getMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(addSubscriber(new BaseDisposableObserver<NetLinePersonBean>() {

                    @Override
                    public void onSuccess(NetLinePersonBean bean) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_PERSON_DATA, bean);
                        }
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        if (viewAction != null) {
                            viewAction.showInfoView(TO_GET_PERSON_DATA, null);
                        }
                    }
                }));
    }
}
