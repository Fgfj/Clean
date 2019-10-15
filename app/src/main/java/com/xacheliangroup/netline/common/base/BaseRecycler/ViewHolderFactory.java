package com.xacheliangroup.netline.common.base.BaseRecycler;

import android.content.Context;
import android.view.ViewGroup;

import com.xacheliangroup.netline.checkTickets.mvp.view.CTCarListView;
import com.xacheliangroup.netline.checkTickets.mvp.view.CheckTicketsUserListView;
import com.xacheliangroup.netline.common.base.holder.ViewSugar;
import com.xacheliangroup.netline.common.flag.ViewItemType;
import com.xacheliangroup.netline.moduleCarCircle.mvp.view.CarCircleItemView;
import com.xacheliangroup.netline.moduleCarComment.mvp.view.CarCommentView;
import com.xacheliangroup.netline.moduleMall.mvp.view.MallFourFunView;
import com.xacheliangroup.netline.moduleMall.mvp.view.MallHeadMdseView;
import com.xacheliangroup.netline.moduleMall.mvp.view.MarketingGoodsListItemView;
import com.xacheliangroup.netline.moduleMall.mvp.view.SellerItemView;
import com.xacheliangroup.netline.moduleMall.mvp.view.StarItemView;
import com.xacheliangroup.netline.moduleMine.mvp.view.MineAddressItemView;
import com.xacheliangroup.netline.moduleMine.mvp.view.MineHomeUiView;
import com.xacheliangroup.netline.moduleMine.mvp.view.OrderListItemView;
import com.xacheliangroup.netline.moduleMine.mvp.view.OrderDetailMoneyView;
import com.xacheliangroup.netline.moduleMine.mvp.view.OrderDetailTimeView;
import com.xacheliangroup.netline.moduleNetLine.mvp.view.NetLineListView;
import com.xacheliangroup.netline.moduleNetLine.mvp.view.NetLineLockSeatView;
import com.xacheliangroup.netline.moduleNetLine.mvp.view.NetLineRouteDialogView;
import com.xacheliangroup.netline.moduleNetLine.mvp.view.NetLineTicketListView;
import com.xacheliangroup.netline.moduleNetLine.mvp.view.NetLineUserListView;


public class ViewHolderFactory {

    public static BaseViewHolder getViewHolder(Context context, ViewGroup parent, int type) {

        ViewSugar viewSugar = null;
        switch (type) {
            case ViewItemType.TEST_VIEW:
                viewSugar = MallHeadMdseView.getInstance(context, parent);
                break;
            case ViewItemType.MINE_UI_VIEW:
                viewSugar= MineHomeUiView.getInstance(context,parent);
                break;
            case ViewItemType.CAR_COMMENT_HOME_VIEW:
                viewSugar= CarCommentView.getInstance(context,parent);
                break;
            case ViewItemType.SELLER_HOME_ITEM_VIEW:
                viewSugar= SellerItemView.getInstance(context,parent);
                break;
            case ViewItemType.CAR_CIRCLE_HOME_VIEW:
                viewSugar= CarCircleItemView.getInstance(context,parent);
                break;
            case ViewItemType.STAR_ITEM_VIEW:
                viewSugar= StarItemView.getInstance(context,parent);
                break;
            case ViewItemType.MARKETING_GOODS_LIST_ITEM_VIEW:
                viewSugar= MarketingGoodsListItemView.getInstance(context,parent);
                break;
            case ViewItemType.MALL_HOME_FOUR_FUN_ITEM_VIEW:
                viewSugar= MallFourFunView.getInstance(context,parent);
                break;
            case ViewItemType.MINE_ADDRESS_ITEM_VIEW:
                viewSugar= MineAddressItemView.getInstance(context,parent);
                break;
            case ViewItemType.ORDER_LIST_ITEM_VIEW:
                viewSugar= OrderListItemView.getInstance(context,parent);
                break;
            case ViewItemType.ORDER_DETAIL_TIME_ITEM_VIEW:
                viewSugar= OrderDetailTimeView.getInstance(context,parent);
                break;
            case ViewItemType.ORDER_DETAIL_MONEY_ITEM_VIEW:
                viewSugar= OrderDetailMoneyView.getInstance(context,parent);
                break;
            case ViewItemType.CHECK_TICKETS_USER_LIST:
                viewSugar= CheckTicketsUserListView.getInstance(context,parent);
                break;
            case ViewItemType.CHECK_TICKETS_CAR_LIST:
                viewSugar= CTCarListView.getInstance(context,parent);
                break;
            case ViewItemType.NET_LINE_LIST:
                viewSugar= NetLineListView.getInstance(context,parent);
                break;
            case ViewItemType.NET_LINE_ITEM_LIST:
                viewSugar= NetLineUserListView.getInstance(context,parent);
                break;
            case ViewItemType.NET_LINE_ROUTE:
                viewSugar= NetLineRouteDialogView.getInstance(context,parent);
                break;
            case ViewItemType.NET_LINE_LOCK_SEAT:
                viewSugar= NetLineLockSeatView.getInstance(context,parent);
                break;
            case ViewItemType.NET_LINE_TICKET_LIST:
                viewSugar= NetLineTicketListView.getInstance(context,parent);
                break;
        }
        if (viewSugar != null) {
            return viewSugar.getViewHolder();
        }
        return null;
    }
}
