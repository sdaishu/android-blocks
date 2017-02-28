package sdaishu.android_flux_blocks.baselib.base.flux;

import android.text.TextUtils;

import io.reactivex.functions.Consumer;
import sdaishu.android_flux_blocks.baselib.base.Constants;


/**
 * Created by cq on 2017/2/27.
 */

public class Dispatcher {
    private final RxManage bus;


    public Dispatcher(RxManage bus) {
        this.bus = bus;
    }


    public void emitChange() {
        emitChange(Constants.EVENT_STORE_CHANGE);
    }

    public void emitChange(String type) {
        post(type, "");
    }

    /**
     * 分配事件
     *
     * @param type 事件的种类
     * @param data 数据
     */
    public void dispatch(String type, Object data) {
        if (TextUtils.isEmpty(type)) {
            throw new IllegalArgumentException("Type must not be empty");
        }

        post(type, data);
    }


    private void post(String tag, final Object event) {
        bus.post(tag, event);
    }

    public void on(String tag, Consumer<Object> action1){
        bus.on(tag,action1);
    }

    public void detach(){
        bus.clear();
    }



}
