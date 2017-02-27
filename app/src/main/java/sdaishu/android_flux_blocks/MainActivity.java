package sdaishu.android_flux_blocks;

import android.widget.TextView;

import butterknife.BindView;
import sdaishu.baselib.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.txt) TextView mTxt;

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

    }

    /**
     * 初始化View
     */
    @Override public void initView() {

    }

    /**
     * 解除绑定的一切事
     */
    @Override public void detach() {

    }
}
