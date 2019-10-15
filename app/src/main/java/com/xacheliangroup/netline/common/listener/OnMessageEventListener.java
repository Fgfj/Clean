package com.xacheliangroup.netline.common.listener;

import com.xacheliangroup.netline.common.eventbus.MessageEvent;

import javax.annotation.Nonnull;

/**
 * author:yz
 * data: 2018/12/14,10:30
 */
public interface OnMessageEventListener {
    void onMessageEventHandle(@Nonnull MessageEvent messageEvent);
}
