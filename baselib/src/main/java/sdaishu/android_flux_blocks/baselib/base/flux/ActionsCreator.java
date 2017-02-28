package sdaishu.android_flux_blocks.baselib.base.flux;

import android.util.Log;

/**
 * Created by cq on 2017/2/28.
 */

public class ActionsCreator {
    final Dispatcher mDispatcher;

    public ActionsCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }


    /**
     * 分发数据
     */
    public void dispatch(String type,Object action) {
        Log.e("-->>","dispatch  "+type);
        mDispatcher.dispatch(type,action);
    }



}
