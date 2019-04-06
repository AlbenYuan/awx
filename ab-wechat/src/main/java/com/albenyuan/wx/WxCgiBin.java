package com.albenyuan.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.albenyuan.common.util.HttpClientUtil;
import com.albenyuan.wx.entity.AccessToken;
import com.albenyuan.wx.exception.WxException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Author Alben Yuan
 * @Date 2017-12-06 10:30
 */
public class WxCgiBin {

    private static Logger logger = LoggerFactory.getLogger(WxCgiBin.class);

    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String URL_GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get";

    private static final String GET_MEDIA_JSSDK = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk";

    public static AccessToken getAccessToken(String appId, String appSecret) {

        StringBuffer url = new StringBuffer(URL_ACCESS_TOKEN);
        url.append("?grant_type=client_credential")
                .append("&appid=").append(appId)
                .append("&secret=").append(appSecret);
        try {
            String result = HttpClientUtil.getString(url.toString());
            return WxUtil.parseAccessToken(result);
        } catch (Exception e) {
            throw new WxException("获取微信信息异常", e);
        }


    }

    /**
     * 下载多媒体文件
     *
     * @param mediaId
     * @param token
     * @return
     */
    public static byte[] downloadMedia(String mediaId, String token) {
        try {
            StringBuffer url = new StringBuffer(URL_GET_MEDIA)
                    .append("?access_token=").append(token)
                    .append("&media_id=").append(mediaId);
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url.toString());
            HttpResponse response = client.execute(get);
            logger.info("headers:{}", response.getFirstHeader("Content-Type"));
            Header header = response.getFirstHeader("Content-Type");
            if (null != header && header.getValue().indexOf("image") > -1) {
                return EntityUtils.toByteArray(response.getEntity());
            } else {
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity, "utf-8");
                JSONObject jsonObject = JSON.parseObject(json);
                throw new WxException(jsonObject.getInteger("errcode"), json);
            }
        } catch (IOException e) {
            throw new WxException(e);
        }
    }

}
