package sdaishu.android_flux_blocks.baselib.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;
import sdaishu.android_flux_blocks.baselib.base.util.SpfUtils;

/**
 * Created by cq on 2017/2/28.
 * 基类Activity
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 取消绑定
     */
    private Unbinder mUnbinder;

    protected sdaishu.android_flux_blocks.baselib.base.BaseApplication mBaseApplication;

    protected Gson mGson;

    protected SpfUtils mSpfUtils;

    @Inject Dispatcher mDispatcher;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder= ButterKnife.bind(this);
        mBaseApplication= sdaishu.android_flux_blocks.baselib.base.BaseApplication.getInstance();
        mGson=mBaseApplication.getGson();
        mSpfUtils=mBaseApplication.getSpfUtils();
        initDagger();
        initView();
    }

    /**
     * 获取布局
     */
    public abstract @LayoutRes int getLayoutId();

    /**
     * 初始化注入器并注入
     */
    public abstract  void initDagger();

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 解除绑定的一切事
     */
    public abstract void detach();

    @CallSuper
    @Override protected void onDestroy() {
        super.onDestroy();
        detach();
        if(mUnbinder!=null)
        mUnbinder.unbind();
    }

}
