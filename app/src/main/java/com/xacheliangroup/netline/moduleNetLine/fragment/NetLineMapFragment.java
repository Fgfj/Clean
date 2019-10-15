package com.xacheliangroup.netline.moduleNetLine.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviTheme;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.xacheliangroup.netline.R;
import com.xacheliangroup.netline.common.base.BaseBean;
import com.xacheliangroup.netline.common.base.BaseFragment;
import com.xacheliangroup.netline.common.eventbus.MessageEvent;
import com.xacheliangroup.netline.common.flag.Flag;
import com.xacheliangroup.netline.common.http.okhttp.IActionListener;
import com.xacheliangroup.netline.common.sharepreference.AppSharePreference;
import com.xacheliangroup.netline.moduleNetLine.activity.NetLineMapActivity;
import com.xacheliangroup.netline.moduleNetLine.mvp.NetLinePresenter;
import com.xacheliangroup.netline.moduleNetLine.mvp.bean.NetLinePointListBean;
import com.xacheliangroup.netline.utils.Measure_Utils;
import com.xacheliangroup.netline.utils.ProgressHelp;
import com.xacheliangroup.netline.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author:yz
 * data: 2019/9/2,09:13
 */
public class NetLineMapFragment extends BaseFragment implements IActionListener.ViewAction {
    final String netLineLocationString = AppSharePreference.getInstance().getNetLineLocation();
    AMap mAMap;
    @BindView(R.id.module_nl_maps2d)
    MapView mMapView;
    private Intent intent;
    private String mRid;
    NetLinePresenter mNetLinePresenter;
    private NetLinePointListBean mNetLinePointListBean;
    private int mUpOrDown = 1;//1上车2下车

    @Override
    public void showInfoView(String type, Object obj) {
        switch (type) {
            case NetLinePresenter.TO_GET_POINT_LIST:
                if (obj != null && obj instanceof NetLinePointListBean) {
                    mNetLinePointListBean = (NetLinePointListBean) obj;
                    if(mNetLinePointListBean.getDowLoaction().size()!=0&&mNetLinePointListBean.getOnLoaction().size()!=0){
                        toAddMarket();
                    }else {
                        ToastUtils.showToast(getContext(),"暂无上车人员");
//                        getActivity().finish();
                        addOneMarket(netLineLocationString, true,"");
                        mAMap.moveCamera(CameraUpdateFactory.changeLatLng(
                                new LatLng(Double.parseDouble(netLineLocationString.split(",")[0]), Double.parseDouble(netLineLocationString.split(",")[1]))
                        ));
                        mAMap.animateCamera(CameraUpdateFactory.zoomTo(14));
                    }

//                    toZoom();
                }
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getType()) {
            case Flag.NETLINE.UPDATE_MAP_LOCATION:
                mNetLinePresenter.toGetPointList(mRid);
                break;
        }
    }
    private void toZoom() {
        mAMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mAMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(Double.parseDouble(netLineLocationString.split(",")[0]),
                Double.parseDouble(netLineLocationString.split(",")[1]))));
    }

    private void toAddMarket() {
        if(mNetLinePointListBean.getDowLoaction().size()==0&&mNetLinePointListBean.getOnLoaction().size()==0){
            ToastUtils.showToast(getContext(),"暂无乘客");
            return;
        }
        mAMap.clear();
        addOneMarket(netLineLocationString, true,"");
        if (mUpOrDown == 1) {//添加上车点
            List<NetLinePointListBean.OnLoactionBean> onLoaction = mNetLinePointListBean.getOnLoaction();
            for (NetLinePointListBean.OnLoactionBean onLoactionBean : onLoaction) {
                addOneMarket(onLoactionBean.getOnLoactionweizhi(), false,onLoactionBean.getOrdermobile());

            }
            mAMap.animateCamera(
                    com.amap.api.maps.CameraUpdateFactory.newLatLngBounds(
                            createBounds(Double.parseDouble(netLineLocationString.split(",")[0]),
                                    Double.parseDouble(netLineLocationString.split(",")[1]),
                                    Double.parseDouble(onLoaction.get(0).getOnLoactionweizhi().split(",")[0]),
                                    Double.parseDouble(onLoaction.get(0).getOnLoactionweizhi().split(",")[1])),
                            Measure_Utils.dip2px(getContext(), 100)), 1000L, null);

        } else {//添加下车点
            List<NetLinePointListBean.DowLoactionBean> onLoaction = mNetLinePointListBean.getDowLoaction();
            for (NetLinePointListBean.DowLoactionBean onLoactionBean : onLoaction) {
                addOneMarket(onLoactionBean.getDowLoactionweizhi(), false,onLoactionBean.getOrdermobile());
            }
            mAMap.animateCamera(
                    com.amap.api.maps.CameraUpdateFactory.newLatLngBounds(
                            createBounds(Double.parseDouble(netLineLocationString.split(",")[0]),
                                    Double.parseDouble(netLineLocationString.split(",")[1]),
                                    Double.parseDouble(onLoaction.get(0).getDowLoactionweizhi().split(",")[0]),
                                    Double.parseDouble(onLoaction.get(0).getDowLoactionweizhi().split(",")[1])),
                            Measure_Utils.dip2px(getContext(), 100)), 1000L, null);

        }
    }

    private void addOneMarket(String location, boolean isMy,final String phone) {
        LatLng latLng = new LatLng(Double.parseDouble(location.split(",")[0]), Double.parseDouble(location.split(",")[1]));
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(latLng);
        markerOption.draggable(false);//设置Marker可拖动
        markerOption.infoWindowEnable(true);
        if (isMy) {

            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                    .decodeResource(getContext().getResources(), R.drawable.module_nl_car_icon)));
        } else {
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                    .decodeResource(getContext().getResources(), R.drawable.module_nl_user)));

        }
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        mAMap.addMarker(markerOption);
        mAMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getPosition().latitude == Double.parseDouble(netLineLocationString.split(",")[0])
                        && marker.getPosition().longitude == Double.parseDouble(netLineLocationString.split(",")[1])) {
                    marker.setTitle("  我的  ");
                    marker.showInfoWindow();
                } else {
                    marker.setTitle(phone+"-(导航)");
                    marker.showInfoWindow();
                }
                return false;
            }
        });
        mAMap.setOnInfoWindowClickListener(new AMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                LatLng endLatLng = marker.getPosition();

                LatLng startLatLng = new LatLng(Double.parseDouble(netLineLocationString.split(",")[0]),
                        Double.parseDouble(netLineLocationString.split(",")[1]));
                if(startLatLng.latitude!=endLatLng.latitude&&startLatLng.longitude!=endLatLng.longitude){
                    routeStart(getContext(), new Poi("", startLatLng, ""),
                            new Poi("", endLatLng, ""));
                }

            }
        });
    }

    @Override
    protected void onRequestConnected() {

    }

    @Override
    protected void onRequestNoConnected() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_nl_fragment_map;
    }

    @Override
    protected void onCreateViewInit(View parentView) {
        setEventBusAction();
        initMap();
        getData();
        addMarketOnclickListener();
    }

    private void addMarketOnclickListener() {
    }

    private void getData() {
        intent = getActivity().getIntent();
        if (intent != null) {
            mRid = intent.getStringExtra(NetLineMapActivity.POINT_RID);
            mNetLinePresenter.toGetPointList(mRid);
        }
    }

    private void initMap() {
        if (mAMap == null) {
            mAMap = mMapView.getMap();
        }
    }

    @Override
    protected void initPresenter() {
        mNetLinePresenter = new NetLinePresenter(getContext(), this);
        addPresenter(mNetLinePresenter);
    }

    @Override
    protected void PresenterGetData() {

    }

    @OnClick(R.id.module_nl_map_back_img)
    public void toBack() {
        getActivity().finish();
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMapView != null) {
            mMapView.onDestroy();
        }
    }

    @BindView(R.id.module_nl_up_car_fl)
    FrameLayout mUpCarFl;
    @BindView(R.id.module_nl_down_car_fl)
    FrameLayout mDownCarFl;

    @OnClick(R.id.module_nl_up_car_ly)
    public void toUpCarLocation() {
        mUpCarFl.setVisibility(View.VISIBLE);
        mDownCarFl.setVisibility(View.GONE);
        mUpOrDown = 1;
        toAddMarket();

    }

    @OnClick(R.id.module_nl_down_car_ly)
    public void toDownCarLocation() {
        mUpCarFl.setVisibility(View.GONE);
        mDownCarFl.setVisibility(View.VISIBLE);
        mUpOrDown = 2;
        toAddMarket();
    }

    public void toMyLocation(){
        if(mUpOrDown==1){
         if(mNetLinePointListBean.getOnLoaction().isEmpty()){
             toZoom();
         }
        }else {
            if(mNetLinePointListBean.getDowLoaction().isEmpty()){
                toZoom();
            }
        }
    }

    public void routeStart(final Context context, Poi startPoi, Poi endPoi) {
        setting(context, true);
        ProgressHelp.showProgress(context);
        AmapNaviParams amapNaviParams = new AmapNaviParams(startPoi, null, endPoi, AmapNaviType.DRIVER);
        amapNaviParams.setNeedCalculateRouteWhenPresent(false);//算路
        amapNaviParams.setTheme(AmapNaviTheme.WHITE);//颜色
        AmapNaviPage.getInstance().showRouteActivity(context, amapNaviParams,
                new INaviInfoCallback() {
                    @Override
                    public void onInitNaviFailure() {
                        ToastUtils.showToast(context, "导航失败");
                    }

                    @Override
                    public void onGetNavigationText(String s) {

                    }

                    @Override
                    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

                    }

                    @Override
                    public void onArriveDestination(boolean b) {

                    }

                    @Override
                    public void onStartNavi(int i) {

                    }

                    @Override
                    public void onCalculateRouteSuccess(int[] ints) {

                    }

                    @Override
                    public void onCalculateRouteFailure(int i) {

                    }

                    @Override
                    public void onStopSpeaking() {

                    }

                    @Override
                    public void onReCalculateRoute(int i) {

                    }

                    @Override
                    public void onExitPage(int i) {
                        ProgressHelp.dismissProgress();
                        setting(context, false);
                    }

                    @Override
                    public void onStrategyChanged(int i) {

                    }

                    @Override
                    public View getCustomNaviBottomView() {
                        return null;
                    }

                    @Override
                    public View getCustomNaviView() {
                        return null;
                    }

                    @Override
                    public void onArrivedWayPoint(int i) {

                    }

                    @Override
                    public void onMapTypeChanged(int i) {

                    }

                    @Override
                    public View getCustomMiddleView() {
                        return null;
                    }
                });
    }

    public void setting(Context context, boolean voice) {
        AMapNavi.getInstance(context).setUseInnerVoice(voice);
    }

    /**
     * 根据2个坐标返回一个矩形Bounds
     * 以此来智能缩放地图显示
     */
    public static LatLngBounds createBounds(Double latA, Double lngA, Double latB, Double lngB) {
        LatLng northeastLatLng;
        LatLng southwestLatLng;

        Double topLat, topLng;
        Double bottomLat, bottomLng;
        if (latA >= latB) {
            topLat = latA;
            bottomLat = latB;
        } else {
            topLat = latB;
            bottomLat = latA;
        }
        if (lngA >= lngB) {
            topLng = lngA;
            bottomLng = lngB;
        } else {
            topLng = lngB;
            bottomLng = lngA;
        }
        northeastLatLng = new LatLng(topLat, topLng);
        southwestLatLng = new LatLng(bottomLat, bottomLng);
        return new LatLngBounds(southwestLatLng, northeastLatLng);
    }
}
