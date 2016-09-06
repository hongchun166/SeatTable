package com.thc.myapplication.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by TianHongChun on 2016/9/6.
 */
public class MNetWorkUtil {

    static MNetWorkUtil netWorkUtil;
    public static MNetWorkUtil getInstant() {
        if (netWorkUtil == null)
            netWorkUtil = new MNetWorkUtil();
        return netWorkUtil;
    }
    /**
     * 请求服务器返回数据
     *
     * @param params
     *            参数
     * @param path
     *            请求地址
     * @return
     */
    public String httpSubmitPostData(String path, HashMap<String, String> params) {
        byte[] data = getRequestData(params, "utf-8").toString().getBytes();
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url
                    .openConnection();
            httpURLConnection.setConnectTimeout(15000);
//			httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length",
                    String.valueOf(data.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);
            int response = httpURLConnection.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                InputStream inptStream = httpURLConnection.getInputStream();
                String contentEncodeing = httpURLConnection
                        .getContentEncoding();
                if (contentEncodeing != null
                        && contentEncodeing.equalsIgnoreCase("gzip")) {
                    inptStream = new GZIPInputStream(new BufferedInputStream(
                            inptStream));
                }
                String res=dealResponseResult(inptStream);
                outputStream.close();
                inptStream.close();
                return res;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * inputStream转字符串
     *
     * @param inputStream
     * @return
     * @throws UnsupportedEncodingException
     */
    private String dealResponseResult(InputStream inputStream)
            throws UnsupportedEncodingException {
        String resultData = null; // 存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray(), "utf-8");
        return resultData;
    }


    private String getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey()).append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // return
            // "input="+URLEncoder.encode(Coder.make(stringBuffer.toString()),"utf-8");
            return stringBuffer.toString();
        } catch (Exception ex) {
            return "";
        }
    }
}
