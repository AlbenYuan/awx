//package com.albenyuan.common.util;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.*;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.MultipartEntity;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.StringBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class HttpClientUtil {
//
//    private static PoolingHttpClientConnectionManager connectionManager = null;
//    private static HttpClientBuilder httpBuilder = null;
//    private static RequestConfig requestConfig;
//
//    private static int MAX_CONNECTION = 10;
//
//    private static int MAX_CONNECTION_DEFAULT = 5;
//
//    private static String IP = "cnivi.com.cn";
//    private static int PORT = 80;
//
//    private static final String CHARSET_DEFAULT = "utf-8";
//
//    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
//
//
////    static {
////        //设置http的状态参数
////        requestConfig = RequestConfig.custom()
////                .setSocketTimeout(5000)
////                .setConnectTimeout(5000)
////                .setConnectionRequestTimeout(5000)
////                .setRedirectsEnabled(true)
////                .build();
////
////        HttpHost target = new HttpHost(IP, PORT);
////        connectionManager = new PoolingHttpClientConnectionManager();
////        connectionManager.setMaxTotal(MAX_CONNECTION);//客户端总并行链接最大数
////        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTION_DEFAULT);//每个主机的最大并行链接数
////        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
////        httpBuilder = HttpClients.custom();
////        httpBuilder.setConnectionManager(connectionManager);
////    }
//
//    public static boolean isHTTPS(String url) {
//        return StringUtils.isNotEmpty(url) && url.toUpperCase().startsWith("HTTPS");
//    }
//
//
//    public static HttpEntity get(String url, Map<String, Object> parameters, Map<String, Object> headers) {
//        boolean isHttps = isHTTPS(url);
//        CloseableHttpClient client = getClient(isHttps);
//        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response = null;
//        List<BasicNameValuePair> query = getParameters(parameters);
//        setHeaders(httpGet, headers);
//        httpGet.setConfig(requestConfig);
//        try {
//            response = client.execute(httpGet);
//            return response.getEntity();
//        } catch (IOException e) {
//            logger.warn("get error; url={},parameters={},headers={}", url, parameters, headers);
//        } finally {
//            CloseableUtil.close(client);
//        }
//        return null;
//    }
//
//    public static HttpEntity get(String url, Map<String, Object> parameters) {
//        return get(url, parameters, null);
//    }
//
//    public static HttpEntity get(String url) {
//        return get(url, null, null);
//    }
//
//
//    public static byte[] getBytes(String url) throws IOException {
//        HttpEntity entity = get(url);
//        return null == entity ? null : EntityUtils.toByteArray(entity);
//    }
//
//    public static String getString(String url) throws IOException {
//        HttpEntity entity = get(url);
//        return entity == null ? null : EntityUtils.toString(entity, CHARSET_DEFAULT);
//    }
//
//
//    public static HttpEntity post(String url, Map<String, Object> params, Map<String, Object> headers) {
//        boolean isHttps = isHTTPS(url);
//        CloseableHttpClient httpclient = getClient(isHttps);
//        CloseableHttpResponse response = null;
//        try {
//            HttpPost httppost = new HttpPost(url);
//            setHeaders(httppost, headers);
//            httppost.setEntity(new StringEntity(params.toString(), "utf-8"));
//            response = httpclient.execute(httppost);
//            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
//                HttpEntity entity = response.getEntity();
//                return entity;
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            CloseableUtil.close(httpclient, response);
//        }
//        return null;
//    }
//
//    public static HttpEntity post(String url, Map<String, Object> parameters) throws IOException {
//        return post(url, parameters, null);
//    }
//
//    public static String postBody(String url, Map<String, Object> params) throws IOException {
//        HttpEntity entity = post(url, params);
//        return null == entity ? "" : EntityUtils.toString(entity);
//    }
//
//    public static String postUploadFile(String url, Map params, List<File> files) {
//        String result = "";
//        HttpClient httpclient = HttpClients.createDefault();
//        HttpResponse response;
//        try {
//            MultipartEntity multipartEntity = new MultipartEntity();
//
//            List<BasicNameValuePair> list = getParameters(params);
//            for (BasicNameValuePair data : list) {
//                multipartEntity.addPart(
//                        data.getName(),
//                        new StringBody(data.getValue(), "text/plain",
//                                Charset.forName(CHARSET_DEFAULT)));
//            }
//            for (File file : files) {
//                multipartEntity.addPart("media", new FileBody(file));
//            }
//            HttpPost httppost = new HttpPost(url);
//            httppost.setEntity(multipartEntity);
//            response = httpclient.execute(httppost);
//            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
//                result = EntityUtils.toString(response.getEntity(), CHARSET_DEFAULT);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                httpclient.getConnectionManager().shutdown();
//            } catch (Exception ignore) {
//            }
//        }
//        return result;
//    }
//
//    /**
//     * use SSL
//     *
//     * @param httpClient
//     * @return
//     */
//    private static CloseableHttpClient useTrustingTrustManager(HttpClient httpClient) {
//        try {
//            // First create a trust manager that won't care.
//            X509TrustManager trustManager = new X509TrustManager() {
//                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                    // Don't do anything.
//                }
//
//                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                    // Don't do anything.
//                }
//
//                public X509Certificate[] getAcceptedIssuers() {// Don't do anything.
//                    return null;
//                }
//            };
//
//            // Now put the trust manager into an SSLContext.
//            SSLContext sslcontext = SSLContext.getInstance("TLS");
//            sslcontext.init(null, new TrustManager[]{trustManager}, null);
//
//            // Use the above SSLContext to create your socket factory
//            // (I found trying to extend the factory a bit difficult due to a
//            // call to createSocket with no arguments, a method which doesn't
//            // exist anywhere I can find, but hey-ho).
//            SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
//            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//
//            // If you want a thread safe client, use the ThreadSafeConManager,
//            // but
//            // otherwise just grab the one from the current client, and get hold
//            // of its
//            // schema registry. THIS IS THE KEY THING.
//            ClientConnectionManager ccm = httpClient.getConnectionManager();
//            SchemeRegistry schemeRegistry = ccm.getSchemeRegistry();
//
//            // Register our new socket factory with the typical SSL port and the
//            // correct protocol name.
//            schemeRegistry.register(new Scheme("https", sf, 443));
//
//            // Finally, apply the ClientConnectionManager to the Http Client
//            // or, as in this example, create a new one.
//            return new DefaultHttpClient(ccm, httpClient.getParams());
//        } catch (Throwable t) {
//            // AND NEVER EVER EVER DO THIS, IT IS LAZY AND ALMOST ALWAYS WRONG!
//            t.printStackTrace();
//            return null;
//        }
//    }
//
//
//    /**
//     * @param parameters
//     * @return
//     */
//    private static List<BasicNameValuePair> getParameters(Map<String, Object> parameters) {
//        List<BasicNameValuePair> list = new ArrayList<>();
//        if (parameters != null) {
//            Iterator it = parameters.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry entry = (Map.Entry) it.next();
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                list.add(new BasicNameValuePair(String.valueOf(key), String.valueOf(value)));
//            }
//        }
//        return list;
//    }
//
//    private static void setHeaders(HttpRequestBase http, Map<String, Object> headers) {
//        if (headers != null) {
//            for (Object key : headers.keySet()) {
//                http.setHeader((String) key, (String) headers.get(key));
//            }
//        }
//    }
//
//    private static CloseableHttpClient getClient(boolean isHttps) {
//        CloseableHttpClient client = HttpClients.createDefault();
//        if (isHttps) {
//            client = useTrustingTrustManager(client);
//        }
//        return client;
//    }
//
//    public static void main(String[] args) throws IOException {
//        logger.info("www.baidu.com:{}", EntityUtils.toString(get("http://www.baidu.com")));
//    }
//}
