package com.xacheliangroup.netline.common.flag;

/**
 * Created by Afra55 on 2017/10/10.
 * Smile is the best name card.
 */

public interface Flag {
    interface SHAREPREFERENCE{
        String TEST="TEST";
        String APP_USER_ID="APP_USER_ID";
        String APP_USER_NAME="APP_USER_NAME";
        String APP_USER_SIGN="APP_USER_SIGN";
        String APP_USER_ICON="APP_USER_ICON";

        String APP_HTTP_RUL="APP_HTTP_RUL";
    }
    interface HTTP{
        int code_success = 200;
    }

    interface DefaultData {
        int none = -1;
    }
    interface MALL{
        String MALL_TEST="MALL_TEST";
    }
    interface EVENT{
        String LOGIN_SUCCESS="LOGIN_SUCCESS";
        String LOGIN_OUT="LOGIN_OUT";
        String UPDATE_ADDRESS="UPDATE_ADDRESS";//修改或者添加地址
        String PAY_GOODS_CHOICE_ADDRESS="PAY_GOODS_CHOICE_ADDRESS";//购买商品选择地址
    }
    interface CHECK{
        String BACK_TICKETS="BACK_TICKETS";//退件
        String UPDATE_CAR_LIST="UPDATE_CAR_LIST";//刷新班次列表
    }
    interface IDCARD{
        String LOGIN_ADDRESS = "http://service.unimarspay.com:20080/decsrv/login";
        String MD5_KEY = "9EAABA7493C981A1513B326C8B6ACBB7";
    }
    interface NETLINE{
        String CALL_PHONE="CALL_PHONE";
        String QR_CODE="QR_CODE";
        String UP_CAR="UP_CAR";
        String UPDATE_UP_CAR_SOCKET="UPDATE_UP_CAR_SOCKET";
        String SOCKET_CONNECT_SUCCESS="SOCKET_CONNECT_SUCCESS";
        String TO_CHECK_SUCCESS="TO_CHECK_SUCCESS";
        String UPDATE_UP_CAR_BACK_MONEY_SOCKET="UPDATE_UP_CAR_BACK_MONEY_SOCKET";
        String TO_SEND_OVER="TO_SEND_OVER";
        String UPDATE_MAP_LOCATION="UPDATE_MAP_LOCATION";
        String SUBMIT_UP_CAR_FOR_TICKET_LIST="SUBMIT_UP_CAR_FOR_TICKET_LIST";
    }
}
