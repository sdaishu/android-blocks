package sdaishu.android_flux_blocks;

import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import sdaishu.android_flux_blocks.baselib.base.BaseActivity;
import sdaishu.android_flux_blocks.baselib.base.di.DispatchModule;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;
import sdaishu.android_flux_blocks.di.DaggerFluxComponent;
import sdaishu.android_flux_blocks.flux.MainCreator;
import sdaishu.android_flux_blocks.flux.MainStore;

public class MainActivity extends BaseActivity {


    @BindView(R.id.txt) TextView mTxt;

    @Inject MainCreator mMainCreator;
    @Inject MainStore mMainStore;
    @Inject Dispatcher mDispatcher;
    /**
     * 获取布局
     */
    @Override public int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化注入器并注入
     */
    @Override public void initDagger() {
        DaggerFluxComponent.builder()
                .dispatchModule(new DispatchModule()).build().inject(this);
    }

    /**
     * 初始化View
     */
    @Override public void initView() {
        mMainCreator.getShowTxt();
        mDispatcher.on(mMainStore.changeEvent(),o ->{
            mTxt.setText(mMainStore.getTxt());
        });
    }

    /**
     * 解除绑定的一切事
     */
    @Override public void detach() {
        mDispatcher.detach();
    }
}
