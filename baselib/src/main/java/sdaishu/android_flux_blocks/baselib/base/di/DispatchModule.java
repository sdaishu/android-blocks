package sdaishu.android_flux_blocks.baselib.base.di;

import dagger.Module;
import dagger.Provides;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;
import sdaishu.android_flux_blocks.baselib.base.flux.RxManage;

/**
 * Created by cq on 2017/2/28.
 */

@Module
public class DispatchModule {
     @Provides Dispatcher provideDispatch(){
        return new Dispatcher(new RxManage());
    }
}
