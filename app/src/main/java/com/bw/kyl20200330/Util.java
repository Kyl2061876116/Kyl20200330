package com.bw.kyl20200330;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
康跃龙
工具类
 */
public class Util  {
    private static void Util(){};
    private static Util util =new Util();

    public static Util getUtil() {
        return util;//调用
    }
    public boolean wlpd(Context context){
       ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        if(info==null){//判断
            return true;
        }else {
            return false;
        }
    }
    public  String getjson(String jsonlj){
        try {
            URL Url = new URL(jsonlj);
            HttpURLConnection url = (HttpURLConnection) Url.openConnection();
            url.setConnectTimeout(7000);
            url.setReadTimeout(5000);
            url.setRequestMethod("GET");//设置
            if(url.getResponseCode()==200){
                InputStream inputStream = url.getInputStream();
                int len;
                byte[] bs = new byte[1024];
                StringBuilder builder = new StringBuilder();
                while((len=inputStream.read(bs))!=-1){
                    String s = new String(bs, 0, len);
                    builder.append(s);
                }
                String json = builder.toString();
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
return null;
    }
}
