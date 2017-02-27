package sdaishu.baselib.base;

/**
 * Created by cq on 2017/2/28.
 */

public class ActionsCreator {
    private static ActionsCreator instance;
    final Dispatcher mDispatcher;

    ActionsCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }


    /**
     * 分发数据
     */
    public void dispatch(String type,Object action) {
        mDispatcher.dispatch(type,action);
    }

}
