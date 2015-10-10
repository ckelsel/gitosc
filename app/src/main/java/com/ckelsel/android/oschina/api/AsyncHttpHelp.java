package com.ckelsel.android.oschina.api;

import android.util.Log;

import com.ckelsel.android.oschina.AppContext;
import com.ckelsel.android.oschina.common.CyptoUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;



import org.apache.http.protocol.HTTP;


public class AsyncHttpHelp {
    public final static String PRIVATE_TOKEN = "private_token";
    public final static String GITOSC_PRIVATE_TOKEN = "git@osc_token";

    public final static int TIMEOUT_CONNECTION = 20000;// ���ӳ�ʱʱ��
    public final static int TIMEOUT_SOCKET = 20000;// socket��ʱ

    public static AsyncHttpClient getHttpClient() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader(HTTP.USER_AGENT, getUserAgent());
        client.setTimeout(TIMEOUT_CONNECTION);
        client.setResponseTimeout(TIMEOUT_SOCKET);
        String private_token = AppContext.getInstance().getProperty(PRIVATE_TOKEN);
        private_token = CyptoUtils.decode(GITOSC_PRIVATE_TOKEN, private_token);
        client.addHeader("private-token", private_token);
        return client;
    }

    public static void get(String url, AsyncHttpResponseHandler handler) {
        getHttpClient().get(url, handler);
        log(new StringBuilder("GET ").append(url).toString());
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        getHttpClient().get(url, params, handler);
        log(new StringBuilder("GET ").append(url).append("?").append(params).toString());
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        getHttpClient().post(url, params, handler);
        log(new StringBuilder("POST ").append(url).append("?").append(params).toString());
    }

    public static void post(String url, AsyncHttpResponseHandler handler) {
        getHttpClient().post(url, handler);
        log(new StringBuilder("POST ").append(url).append("?").toString());
    }

    /**
     * ���UserAgent
     *
     * @return
     */
    private static String getUserAgent() {
        AppContext appContext = AppContext.getInstance();
        StringBuilder ua = new StringBuilder("Git@OSC.NET");
        ua.append('/' + appContext.getPackageInfo().versionName + '_' + appContext.getPackageInfo().versionCode);//App�汾
        ua.append("/Android");//�ֻ�ϵͳƽ̨
        ua.append("/" + android.os.Build.VERSION.RELEASE);//�ֻ�ϵͳ�汾
        ua.append("/" + android.os.Build.MODEL); //�ֻ��ͺ�
        ua.append("/" + AppContext.getInstance().getAppId());//�ͻ���Ψһ��ʶ
        return ua.toString();
    }

    public static RequestParams getPrivateTokenWithParams() {
        RequestParams params = new RequestParams();
        String private_token = AppContext.getInstance().getProperty(PRIVATE_TOKEN);
        private_token = CyptoUtils.decode(GITOSC_PRIVATE_TOKEN, private_token);
        params.put(PRIVATE_TOKEN, private_token);
        return params;
    }

    private static void log(String log) {
        Log.d("http", log);
    }
}
