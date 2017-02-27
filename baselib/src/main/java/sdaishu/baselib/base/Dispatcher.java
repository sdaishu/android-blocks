package sdaishu.baselib.base;

import android.text.TextUtils;


/**
 * Created by cq on 2017/2/27.
 */

public class Dispatcher {
    private final RxManage bus;
    private static Dispatcher instance;

    public static Dispatcher get(RxManage bus) {
        if (instance == null) {
            instance = new Dispatcher(bus);
        }
        return instance;
    }

    Dispatcher(RxManage bus) {
        this.bus = bus;
    }


    public void emitChange(Object o) {
        post(Constants.EVENT_STORE_CHANGE, o);
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

        post(type, new Action.Builder().with(type).bundle(data));
    }


    private void post(String tag, final Object event) {
        bus.post(tag, event);
    }
}
