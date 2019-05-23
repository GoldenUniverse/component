package com.ebrightmoon.retrofitrx.common;


import com.ebrightmoon.retrofitrx.util.MD5;

import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wyy on 2018/1/29.
 */

public class HttpUtils {


    private HttpUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    public static final int DEFAULT_RETRY_COUNT = 3;//默认重试次数
    public static final int DEFAULT_RETRY_DELAY_MILLIS = 3000;//默认重试间隔时间（毫秒）
    public static final int MAX_AGE_ONLINE = 60;//默认最大在线缓存时间（秒）
    public static final int MAX_AGE_OFFLINE = 24 * 60 * 60;//默认最大离线缓存时间（秒）
    public static final String dirName = "download";
    public static final String fileName = "lantern-installer.apk";
    public static final String CACHE_SP_NAME = "sp_cache";//默认SharedPreferences缓存文件名
    public static final String CACHE_DISK_DIR = "disk_cache";//默认磁盘缓存目录
    public static final String CACHE_HTTP_DIR = "http_cache";//默认HTTP缓存目录
    public static final long CACHE_NEVER_EXPIRE = -1;//永久不过期
    public static final String COOKIE_PREFS = "Cookies_Prefs";//默认Cookie缓存目录
    public static final String API_HOST = "https://www.ebrightmoon.com/";//默认API主机地址
    public static final String DEFAULT_DOWNLOAD_DIR = "download";//默认下载目录
    public static final String DEFAULT_DOWNLOAD_FILE_NAME = "download_file.tmp";//默认下载文件名称


    public static final int DEFAULT_TIMEOUT = 60;//默认超时时间（秒）
    public static final int DEFAULT_MAX_IDLE_CONNECTIONS = 5;//默认空闲连接数
    public static final long DEFAULT_KEEP_ALIVE_DURATION = 8;//默认心跳间隔时长（秒）
    public static final long CACHE_MAX_SIZE = 10 * 1024 * 1024;//默认最大缓存大小（字节）


    /**
     * 生成header相关数据
     * @param params
     * @return
     */
    public static Map<String, String> excute(Map<String, String> params) {
        String timestamp = System.currentTimeMillis() / 1000 + "";
        Map<String, String> temp = new HashMap<>();
        temp.putAll(params);
        temp.put("Timestamp", timestamp);
        temp.put("Platform", "Android");
        temp.put("PublicKey", "A4GNADCBiQKBgQDi7DfgJeRzqEiBgQDi");
        StringBuffer requestParams = spellParams(temp);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Timestamp", timestamp);
        headers.put("Platform", "Android");
        headers.put("Sign", MD5.encode(requestParams.toString()));
        return headers;
    }
//
//
//    /**
//     * 图片验证码
//     * @param context
//     * @param imageView
//     */
//    public static void showImage(Context context, ImageView imageView) {
//        String timestamp = System.currentTimeMillis() / 1000 + "";
//        Map<String, String> maps = new HashMap<>();
//        maps.put("Timestamp", timestamp);
//        maps.put("Platform", "Android");
//        maps.put("PublicKey", "A4GNADCBiQKBgQDi7DfgJeRzqEiBgQDi");
//        StringBuffer requestParams = HttpUtils.spellParams(maps);
//        GlideUrl glideUrl = new GlideUrl("http://192.168.0.17:8888/api/v1.0/Image/captcha/" + SystemUtils.getUuid(), new LazyHeaders.Builder()
//                .addHeader("Sign", MD5.encode(requestParams.toString()))
//                .addHeader("Timestamp", timestamp)
//                .addHeader("Platform", "Android")
//                .build());
//        Glide.with(context)
//                .load(glideUrl)
//                .error(R.mipmap.ic_launcher)
//                .into(imageView);
//    }
//
//
    /**
     * 判断是否是汉字
     */
    /**
     * 是否是中文
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[u4e00-u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
//
//
    /**
     * 拼接参数
     *
     * @param hashmap
     * @return
     * @throws UnsupportedEncodingException
     */
    public static StringBuffer spellParams(Map<String, String> hashmap) {
        List<BasicNameValuePair> array = new ArrayList();
        Object[] key = hashmap.keySet().toArray();
        Arrays.sort(key);
        for (int i = 0; i < key.length; i++) {
            if (isContainChinese(hashmap.get(key[i]))) {
                String encode = null;
                try {
                    encode = URLEncoder.encode(hashmap.get(key[i]), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                array.add(new BasicNameValuePair(key[i] + "", encode + ""));
            } else {
                array.add(new BasicNameValuePair(key[i] + "", hashmap.get(key[i]) + ""));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.size(); i++) {
            if ((array.size() - 1) == i) {
                sb.append(array.get(i).toString());
            } else {
                sb.append(array.get(i).toString() + "&");
            }
        }
        return sb;
    }



}


