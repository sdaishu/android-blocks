package sdaishu.android_flux_blocks.di;

import dagger.Module;
import dagger.Provides;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;
import sdaishu.android_flux_blocks.flux.MainCreator;
import sdaishu.android_flux_blocks.flux.MainStore;

/**
 * Created by cq on 2017/2/28.
 */
@Module
@MainScope
public class FluxModule {

    @MainScope @Provides MainCreator provideCreator(Dispatcher dispatcher){
        return new MainCreator(dispatcher);
    }

    @MainScope @Provides MainStore provideStore(Dispatcher dispatcher){
        return new MainStore(dispatcher);
    }
}
