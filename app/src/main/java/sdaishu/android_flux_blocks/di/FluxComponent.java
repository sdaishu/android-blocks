package sdaishu.android_flux_blocks.di;

import dagger.Component;
import sdaishu.android_flux_blocks.MainActivity;
import sdaishu.android_flux_blocks.baselib.base.di.DispatchModule;

/**
 * Created by cq on 2017/2/28.
 */

@MainScope
@Component(modules = {FluxModule.class, DispatchModule.class})
public interface FluxComponent {
    void inject(MainActivity activity);
}
