package com.albenyuan.wx.sdk;

/**
 * 小程序 统一下单参数 对象
 * Created by alben on 2017/8/23.
 */
public class WxaPayEntity extends PayEntity {

    public WxaPayEntity(String openId) {
        this();
        this.setOpenId(openId);
    }

    public WxaPayEntity() {
        super.setTradeScene(WxPayConstants.TradeScene.WXA);
        super.setDeviceInfo("WEB");
    }

    public void setOpenId(String openId) {
        super.put("openid", openId);
    }
}
