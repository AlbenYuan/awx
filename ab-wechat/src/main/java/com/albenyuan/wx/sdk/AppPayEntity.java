package com.albenyuan.wx.sdk;

/**
 * app支付 统一下单 参数对象
 * Created by alben on 2017/8/24.
 */
public class AppPayEntity extends PayEntity {

    public AppPayEntity() {
        super.setTradeScene(WxPayConstants.TradeScene.APP);
    }

}
