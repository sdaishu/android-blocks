package sdaishu.android_flux_blocks.baselib.base.di;

import javax.inject.Singleton;

import dagger.Component;
import sdaishu.android_flux_blocks.baselib.base.BaseApplication;

/**
 * Created by cq on 2017/2/28.
 * 提供app的注入
 */
@Singleton
@Component (modules=AppModule.class)
public interface AppComponent {
    void inject(BaseApplication application);
}
