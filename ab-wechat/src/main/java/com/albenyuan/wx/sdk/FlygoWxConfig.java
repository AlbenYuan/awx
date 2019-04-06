package com.albenyuan.wx.sdk;

import com.albenyuan.wx.WxPayDomainImpl;
import com.albenyuan.wx.constant.TradeScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by alben on 2017/8/25.
 */
public class FlygoWxConfig extends WxPayConfig {

    private static Logger logger = LoggerFactory.getLogger(FlygoWxConfig.class);
    private byte[] certData;
    private String appId;
    private String mchId;
    private String key;
    private TradeScene tradeScene;

    private FlygoWxConfig(TradeScene tradeScene) throws IOException {
//        if (null == configManager) {
//            ApplicationContext applicationContext = ServiceBean.getSpringContext();
//            configManager = applicationContext.getBean(ConfigManager.class);
//        }
//        switch (tradeScene) {
//            case APP:
//                this.appId = getStringFromConfig(Constant.WX_APP_PAY_APP_ID);
//                this.mchId = getStringFromConfig(Constant.WX_APP_MCH_ID);
//                this.key = getStringFromConfig(Constant.WX_APP_KEY);
//                this.loadByFile(getStringFromConfig(Constant.WX_APP_CERT_PATH));
//                break;
//            case JSAPI:
//                this.appId = getStringFromConfig(Constant.WX_JSAPI_PAY_APP_ID);
//                this.mchId = getStringFromConfig(Constant.WX_JSAPI_MCH_ID);
//                this.key = getStringFromConfig(Constant.WX_JSAPI_KEY);
//                this.loadByFile(getStringFromConfig(Constant.WX_JSAPI_CERT_PATH));
//                break;
//            case WXA:
//                this.appId = getStringFromConfig(Constant.WX_WXA_PAY_APP_ID);
//                this.mchId = getStringFromConfig(Constant.WX_WXA_MCH_ID);
//                this.key = getStringFromConfig(Constant.WX_WXA_KEY);
//                this.loadByFile(getStringFromConfig(Constant.WX_WXA_CERT_PATH));
//                break;
//        }
//        this.tradeScene = tradeScene;
    }

    public static FlygoWxConfig getInstance(TradeScene tradeScene) throws IOException {
        return new FlygoWxConfig(tradeScene);
    }


    public TradeScene getTradeScene() {
        return this.tradeScene;
    }

    public String getAppID() {
        return this.appId;
    }

    public String getMchID() {
        return this.mchId;
    }

    public String getKey() {
        return this.key;
    }

    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    IWxPayDomain getWXPayDomain() {
        return WxPayDomainImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }


    private String getStringFromConfig(String key) {
//        logger.info(key + ":{}" + configManager.getString(key, ""));
//        return configManager.getString(key, "");
        return key;
    }

    private void loadByFile(String path) throws IOException {
        File file = new File(path);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

}
