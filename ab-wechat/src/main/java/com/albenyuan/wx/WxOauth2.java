package com.albenyuan.wx;


import com.albenyuan.wx.exception.WxException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.albenyuan.common.util.HttpClientUtil;
import com.albenyuan.wx.entity.WxAccessToken;
import com.albenyuan.wx.entity.WxSessionKey;
import com.albenyuan.wx.entity.WxUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WxOauth2 {

    private static Logger logger = LoggerFactory.getLogger(WxOauth2.class);

    private static String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static String IRL_JS_CODE2_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
    private static String URL_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    private static String URL_AUTH = "https://api.weixin.qq.com/sns/auth";
    private static String URL_USERINFO = "https://api.weixin.qq.com/sns/userinfo";

    public enum SCOPE {
        BASE("snsapi_base"), USERINFO("snsapi_userinfo");
        private String code;

        SCOPE(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    /**
     * 获取授权凭证
     *
     * @param appId     应用Id
     * @param appSecret
     * @param code
     * @param scope
     */
    public static WxAccessToken getAccessToken(String appId, String appSecret, String code, SCOPE scope) {
        try {
            StringBuffer url = new StringBuffer(URL_ACCESS_TOKEN);
            url.append("?appid=").append(appId)
                    .append("&secret=").append(appSecret)
                    .append("&code=").append(code)
                    .append("&scope=").append(scope)
                    .append("&grant_type=authorization_code");
            String result = HttpClientUtil.getString(url.toString());
            return WxUtil.parseWxAccessToken(result);
        } catch (Exception e) {
            logger.error("getAccessToken", e);
            throw new WxException("获取微信信息异常", e);
        }
    }


    /**
     * 刷新token
     *
     * @param appId
     * @param refreshToken
     */
    public static WxAccessToken refreshToken(String appId, String refreshToken) {
        try {
            StringBuffer url = new StringBuffer(URL_REFRESH_TOKEN);
            url.append("?appid=").append(appId)
                    .append("&grant_type=refresh_token&refreshToken=").append(refreshToken);
            String result = HttpClientUtil.getString(url.toString());
            return WxUtil.parseWxAccessToken(result);
        } catch (Exception e) {
            throw new WxException("获取微信信息异常", e);
        }

    }

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param accessToken
     * @param openId
     */
    public static boolean auth(String accessToken, String openId) {
        try {
            StringBuffer url = new StringBuffer(URL_AUTH);
            url.append("?access_token=").append(accessToken)
                    .append("&openid=").append(openId);
            String result = HttpClientUtil.getString(url.toString());
            JSONObject jsonObject = JSON.parseObject(result);
            if (jsonObject.containsKey("errcode")) {
                String code = jsonObject.getString("errcode");
                if ("0".equals(code)) {
                    return true;
                } else if ("40003".equals(code)) {
                    return false;
                } else {
                    throw new RuntimeException(jsonObject.getString("errcode")
                            + ":" + jsonObject.getString("errmsg"));
                }
            }
            throw new WxException("微信返回数据异常: " + result, null);
        } catch (Exception e) {
            throw new WxException("获取微信信息异常", e);
        }

    }

    /**
     * 获取用户信息
     *
     * @param accessToken
     * @param openId
     */
    public static WxUserInfo getUserInfo(String accessToken, String openId) {
        try {
            StringBuffer url = new StringBuffer(URL_USERINFO);
            url.append("?access_token=").append(accessToken)
                    .append("&openid=").append(openId);
            logger.info("get user info url :{}", url);
            String result = HttpClientUtil.getString(url.toString());
            JSONObject jsonObject = JSON.parseObject(result);
            WxUtil.validateResult(jsonObject);
            WxUserInfo userInfo = new WxUserInfo();
            userInfo.setCity(jsonObject.getString("city"));
            userInfo.setOpenid(jsonObject.getString("openid"));
            userInfo.setNickname(jsonObject.getString("nickname"));
            userInfo.setSex(jsonObject.getInteger("sex"));
            userInfo.setProvince(jsonObject.getString("province"));
            userInfo.setCountry(jsonObject.getString("country"));
            userInfo.setUnionid(jsonObject.getString("unionid"));
            userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
//            userInfo.setPrivilege(jsonObject.getJSONArray("privilege").toArray(String.class));
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取微信信息异常", e);
        }
    }

    /**
     * 获取授权凭证
     *
     * @param appId     应用Id
     * @param appSecret
     * @param code
     */
    public static WxSessionKey getSessionKey(String appId, String appSecret, String code) {
        try {
            StringBuffer url = new StringBuffer(IRL_JS_CODE2_SESSION);
            url.append("?appid=").append(appId)
                    .append("&secret=").append(appSecret)
                    .append("&js_code=").append(code)
                    .append("&grant_type=authorization_code");
            String result = HttpClientUtil.getString(url.toString());
            return WxUtil.parseToSessionKey(result);
        } catch (Exception e) {
            logger.error("获取session key失败", e);
            throw new RuntimeException("获取微信信息异常", e);
        }
    }


}
