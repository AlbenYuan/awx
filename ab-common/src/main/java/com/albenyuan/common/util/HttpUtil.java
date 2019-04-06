package com.albenyuan.common.util;

import com.albenyuan.common.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @Author Alben Yuan
 * @Date 2018-06-12 16:53
 */
public final class HttpUtil {


    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * https
     *
     * @param url
     * @return
     */
    public static boolean isHTTPS(String url) {
        return StringUtils.isNotEmpty(url) && url.toUpperCase().startsWith("HTTPS");
    }

    private static CloseableHttpClient getClient(boolean isHttps) {
        return isHttps
//                ? HttpClients.createDefault()
                ? useTrustingTrustManager()
                : HttpClients.createDefault();
    }

    public static String get(String url) {
        return get(url, null);
    }


    public static String get(String url, Map<String, Object> headers) {

        CloseableHttpClient client = getClient(isHTTPS(url));
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        setHeaders(httpGet, headers);
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
//            logger.info(EntityUtils.toString(entity));
            return entity == null ? null : EntityUtils.toString(entity, Charsets.DEFAULT_CHARSET);
        } catch (IOException e) {
            logger.warn("get error; url={}, headers={}", url, headers);
            logger.error("error", e);
        } finally {
            CloseableUtil.close(response, client);
        }
        return null;
    }


    private static void setHeaders(HttpRequestBase http, Map<String, Object> headers) {
        if (headers != null) {
            for (Object key : headers.keySet()) {
                http.setHeader((String) key, (String) headers.get(key));
            }
        }
    }

    private HttpUtil() {
    }

    private static CloseableHttpClient useTrustingTrustManager() {
        try {
            // First create a trust manager that won't care.
            X509TrustManager trustManager = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            // Now put the trust manager into an SSLContext.
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[]{"TLSv1"},
                    null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            return HttpClients.custom().setSSLSocketFactory(sslSF).build();
        } catch (Throwable t) {
            // AND NEVER EVER EVER DO THIS, IT IS LAZY AND ALMOST ALWAYS WRONG!
            t.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {

        logger.info("get https :{}", get("https://www.baidu.com"));
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            HttpGet httpget = new HttpGet("https://www.baidu.com");
//
//            System.out.println("Executing request " + httpget.getRequestLine());
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            try {
//                System.out.println("----------------------------------------");
//                System.out.println(response.getStatusLine());
//
//                // Get hold of the response entity
//                HttpEntity entity = response.getEntity();
//
//                // If the response does not enclose an entity, there is no need
//                // to bother about connection release
//                if (entity != null) {
//                    InputStream instream = entity.getContent();
//                    try {
//                        instream.read();
//                        System.out.println(IOUtils.toString(instream));
//                        // do something useful with the response
//                    } catch (IOException ex) {
//                        // In case of an IOException the connection will be released
//                        // back to the connection manager automatically
//                        throw ex;
//                    } finally {
//                        // Closing the input stream will trigger connection release
//                        instream.close();
//                    }
//                }
//            } finally {
//                response.close();
//            }
//        } finally {
//            httpclient.close();
//        }
    }
}
