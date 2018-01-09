package com.sdaishu.block.config;

/**
 * Created by dongmingcui on 2018/1/9.
 */

public class AppConfig {

    public static boolean isDebug = true;

    public static  String HOST;
    public static  String API_URL;

    static {
        if (isDebug) {

            AppConfig.HOST = "apitest.jkxxkj.com";
            AppConfig.API_URL = "http://apitest.jkxxkj.com/api/";

        } else {

            AppConfig.HOST = "api.jkxxkj.com";
            AppConfig.API_URL = "http://apitest.jkxxkj.com/api/";
        }
    }

    public final static String DEFAULT_IMG_CACHE_PATH = "/blocks/cache";
}
