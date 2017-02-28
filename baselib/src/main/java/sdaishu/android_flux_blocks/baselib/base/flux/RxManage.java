package sdaishu.android_flux_blocks.baselib.base.flux;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by cq on 2017/2/27.
 * https://github.com/north2016/T-MVP
 */

public class RxManage {
    public RxBus mRxBus = RxBus.$();
    private Map<String, Observable<?>> mObservables = new HashMap<>();// 管理观察者
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();// 管理订阅者者


    /**
     * 接收时间
     */
    public void on(String eventName, Consumer<Object> action1) {
        Observable<?> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        mCompositeDisposable.add(mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1, new Consumer<Throwable>() {
                    @Override public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                }));
    }


    public void add(Disposable m) {
        mCompositeDisposable.add(m);
    }

    /**
     * 清除全部
     */
    public void clear() {
        mCompositeDisposable.dispose();// 取消订阅
        for (Map.Entry<String, Observable<?>> entry : mObservables.entrySet()) {
            mRxBus.unregister(entry.getKey(), entry.getValue());// 移除观察
        }
    }


    /**
     * 提交事件
     * @param tag
     * @param content
     */
    public void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }
}
