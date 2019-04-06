package com.albenyuan.wx.sdk;

import com.albenyuan.wx.constant.SignType;
import com.albenyuan.wx.constant.TradeScene;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alben on 2017/8/28.
 */
public class WxEntity {

    protected static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    protected Map<String, String> entityMap = new HashMap();

    protected TradeScene tradeScene;
    protected SignType signType;

    protected WxEntity() {
        this.setSignType();
    }

    public Map<String, String> getEntityMap() {
        return entityMap;
    }

    public TradeScene getTradeScene() {
        return tradeScene;
    }

    /**
     * 设置通知地址（必填），支付结果通知地址
     *
     * @param notifyUrl
     */
    public void setNotifyUrl(String notifyUrl) {
        this.put("notify_url", notifyUrl);
    }

    /**
     * 设置交易场景
     *
     * @param tradeScene
     */
    public void setTradeScene(TradeScene tradeScene) {
        this.tradeScene = tradeScene;
    }

    public SignType getSignType() {
        return this.signType;
    }


    /**
     * 设置签名类型
     *
     * @param signType
     */
    public void setSignType(SignType signType) {
        if (null == signType) {
            signType = SignType.MD5;
        }
        this.signType = signType;
        this.put("sign_type", this.signType.toString());
    }


    public void setSignType() {
        this.setSignType(SignType.MD5);
    }

    public void setFee(long totalFee, String feeType) {
        this.put("fee_type", feeType);
        this.put("total_fee", "" + totalFee);
    }

    /**
     * 设置订单总金额 单位：元
     *
     * @param totalFee
     */
    public void setTotalFee(long totalFee) {
        this.setFee(totalFee, "CNY");
    }

    /**
     * 设置订单总金额 单位：元
     *
     * @param totalFee
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.setFee(convertFee(totalFee), "CNY");
    }

    protected void put(String name, String value) {
        entityMap.put(name, value);
    }

    protected long convertFee(BigDecimal fee) {
        return fee.multiply(ONE_HUNDRED).longValue();
    }

    protected long convertFee(long fee) {
        return fee * 100l;
    }
}
