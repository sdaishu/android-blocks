package com.sdaishu.block.hybrid.weex.module;

import android.net.Uri;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;


/**
 * Created by sepai on 2017/8/22.
 */

public class HybridPageModule extends WXModule {

    @JSMethod()
    public void openPage(String page) {
        Uri uri = Uri.parse(page);
        if (uri == null || uri.getHost() == null || uri.getScheme() == null) {

        }

    }

}


