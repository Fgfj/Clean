package com.xacheliangroup.netline.common.http;

import com.alibaba.idst.nls.internal.utils.L;
import com.xacheliangroup.netline.common.log.CbbLogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author:yz
 * data: 2019/9/9,09:11
 */
public class MyHttpUtlis {
    //超时时间
    private static final int TIMEOUT_IN_MILLIONS = 10000;

    public interface CallBack {
        void onRequestComplete(String result);

        void onRequestError(String result);
    }

    /**
     * 异步的Post请求
     *
     * @param urlStr
     * @param params
     * @param callBack
     * @throws Exception
     */
    public static void doPostAsyn(final String urlStr, final String params, final CallBack callBack) {
        new Thread() {
            public void run() {
                try {
                    String result = doPost(urlStr, params);
                    if (callBack != null) {
                        callBack.onRequestComplete(result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.onRequestError(e.toString());
                    }
                }
            }

            ;
        }.start();


    }

    /**
     *
     * @param url  向指定 URL 发送POST方法的请求
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
     * @return
     */
    public static String doPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);

            if (param != null && !param.trim().equals("")) {
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
            }
            CbbLogUtils.debugLog(param);
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            if (result.equals("{}")) {
                result = conn.getResponseCode() + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.i("http", e.toString());
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (result == null && result.equals("")) {
            L.i("http", "result为空");
        } else {
            L.i("http", result);
        }

        return result;
    }
}

