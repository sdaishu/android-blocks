package sdaishu.android_flux_blocks.baselib.base;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Inject;

import sdaishu.android_flux_blocks.baselib.base.di.AppComponent;
import sdaishu.android_flux_blocks.baselib.base.di.AppModule;
import sdaishu.android_flux_blocks.baselib.base.di.DaggerAppComponent;
import sdaishu.android_flux_blocks.baselib.base.util.SpfUtils;

/**
 * Created by cq on 2017/2/28.
 *
 */

public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    /**
     * 提供单例的 component
     */
    private AppComponent mAppComponent;

    @Inject Gson mGson;
    @Inject SpfUtils mSpfUtils;

    @Override public void onCreate() {
        super.onCreate();
        mApplication = this;
        mAppComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
    }


    public static BaseApplication getInstance() {
        return mApplication;
    }

    public Gson getGson() {
        return mGson;
    }

    public SpfUtils getSpfUtils() {
        return mSpfUtils;
    }
}
