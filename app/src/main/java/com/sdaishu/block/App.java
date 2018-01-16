package com.sdaishu.block;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.sdaishu.block.config.AppConfig;
import com.sdaishu.block.config.UMengConfig;
import com.sdaishu.block.config.WEEXConfig;
import com.sdaishu.block.hybrid.weex.adapter.ImageAdapter;
import com.sdaishu.block.hybrid.weex.module.HybridPageModule;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import com.umeng.socialize.PlatformConfig;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dongmingcui on 2018/1/9.
 */

public class App extends MultiDexApplication implements ReactApplication {

    private static App _instance;

    @Override
    protected void attachBaseContext(Context base) {

        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {

        super.onCreate();
        run();
    }

    /**
     * 获取实例
     */
    public static App getApp() {

        return _instance;
    }


    /**
     * 初始化运行
     */
    public void run() {

        _instance = (App) getApplicationContext();

        initARouter();

        //initWEEX();

        initUMENG();

        //initNIM();

    }


    /**
     * 网易云
     */
//    public void initNIM() {
//        NIMClient.init(this, Nim.loginInfo(), Nim.options());
//
//        if (NIMUtil.isMainProcess(this)) {
//            // 注意：以下操作必须在主进程中进行
//            // 1、UI相关初始化操作
//            // 2、相关Service调用
//        }
//
//    }


    /**
     * 友盟
     */
    public void initUMENG() {

        PlatformConfig.setWeixin(UMengConfig.WEICHAT_APPID, UMengConfig.WEICHAT_SECRET);
        //QQ空间
        PlatformConfig.setQQZone(UMengConfig.QQ_APPID, UMengConfig.QQ_APPKEY);
        //新浪微博
        PlatformConfig.setSinaWeibo(UMengConfig.WEIBO_APPID, UMengConfig.WEIBO_APPKEY, UMengConfig.REDIRECT_URL);
    }

    /**
     * 路由
     */
    public void initARouter() {

        if (AppConfig.isDebug) {   // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    /**
     * weex
     */
//    public void initWEEX() {
//
//        WXEnvironment.sApplication = App.getApp();
//        WXSoInstallMgrSdk.init(App.getApp());
//        InitConfig.Builder builder = new InitConfig.Builder();
//        //builder.setHttpAdapter(new OkHttpAdapter())
//        builder.setImgAdapter(new ImageAdapter());
//        InitConfig config = builder.build();
//        try {
//            WXSDKEngine.initialize(this, config);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            WXSDKEngine.registerModule(WEEXConfig.commonPage, HybridPageModule.class, true);
//        } catch (WXException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * RN method
     */
    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }
}
