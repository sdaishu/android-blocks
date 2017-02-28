package sdaishu.android_flux_blocks.baselib.base.flux;

import android.util.Log;

/**
 * Created by cq on 2017/2/27.
 */

public abstract class Store {
    protected Dispatcher mDispatcher;

    public Store(Dispatcher dispatcher) {
        this.mDispatcher = dispatcher;
        initAction();
    }

    protected void emitStoreChange() {
        Log.e("-->>","post  "+changeEvent());

        mDispatcher.emitChange(changeEvent());
    }

    protected void emitStoreChangeNormal() {
        mDispatcher.emitChange();
    }

    public abstract String changeEvent();
    public abstract void initAction();

}
