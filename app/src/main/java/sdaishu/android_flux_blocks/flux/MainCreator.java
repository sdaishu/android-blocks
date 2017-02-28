package sdaishu.android_flux_blocks.flux;

import sdaishu.android_flux_blocks.baselib.base.flux.ActionsCreator;
import sdaishu.android_flux_blocks.baselib.base.flux.Dispatcher;

import static sdaishu.android_flux_blocks.MainConstant.EVENT_MAIN_GET_TXT;

/**
 * Created by cq on 2017/2/28.
 */

public class MainCreator extends ActionsCreator{


    public MainCreator(Dispatcher dispatcher) {
        super(dispatcher);
    }


    public void getShowTxt(){
        dispatch(EVENT_MAIN_GET_TXT,"cq");
    }
}
