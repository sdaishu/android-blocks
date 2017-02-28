package sdaishu.android_flux_blocks.flux;

import android.util.Log;

import sdaishu.android_flux_blocks.MainConstant;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;
import sdaishu.android_flux_blocks.baselib.base.flux.Store;

import static sdaishu.android_flux_blocks.MainConstant.EVENT_MAIN_GET_TXT;

/**
 * Created by cq on 2017/2/28.
 */

public class MainStore extends Store {
    private String mTxt;

    public MainStore(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override public String changeEvent() {
        return MainConstant.EVENT_STORE_CHANGE_MAIN;
    }

    @Override public void initAction() {
        mDispatcher.on(EVENT_MAIN_GET_TXT, o -> {
            Log.e("-->>", "on  " + EVENT_MAIN_GET_TXT);
            mTxt = (String) o;
            emitStoreChange();
        });
    }

    public String getTxt() {
        return mTxt;
    }
}
