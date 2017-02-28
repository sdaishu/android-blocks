package sdaishu.android_flux_blocks.baselib.base.di;

import android.app.Application;
import android.content.res.Resources;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sdaishu.android_flux_blocks.baselib.base.util.SpfUtils;

/**
 * Created by cq on 2017/2/28.
 * 提供 application的Module  等一些单例
 */
@Module public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Singleton @Provides public Application provideApp() {
        return mApplication;
    }

    @Singleton @Provides public Gson provideGson() {
        return new Gson();
    }

    @Singleton @Provides public SpfUtils provideSpfUtils(){
        return new SpfUtils(mApplication);
    }

    @Singleton @Provides public Resources provideResource(){
        return mApplication.getResources();
    }


}
