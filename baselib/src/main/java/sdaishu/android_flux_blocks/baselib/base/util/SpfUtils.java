package sdaishu.android_flux_blocks.baselib.base.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import sdaishu.android_flux_blocks.baselib.base.Constants;

/**
 * Created by cq on 2017/2/28.
 * SharedPreferences工具类
 */

public class SpfUtils {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SpfUtils(Application application) {
        mSharedPreferences = application.getSharedPreferences(Constants.SPF_KEY_BASE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }


    /**
     * 获取 String
     */
    public String getString(String key) {
        return getString(key, "");
    }

    /**
     * 获取 String
     */
    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    /**
     * 获取 int
     */
    public int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * 获取 int
     */
    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, 0);
    }

    /**
     * put String
     *
     * @return 请执行完之后 务必调用 applay
     */
    public SpfUtils saveString(String key, String value) {
        mEditor.putString(key, value);
        return this;
    }


    /**
     * 提交数据
     */
    public void apply() {
        mEditor.apply();
    }

    /**
     * 直接 apply
     */
    public void applyInt(String key, int value) {
        mEditor.putInt(key, value).apply();
    }

    /**
     * 直接 commit
     */
    public void commitInt(String key, int value) {
        mEditor.putInt(key, value).commit();
    }

    /**
     * 直接 apply
     */
    public void applyString(String key, String value) {
        mEditor.putString(key, value).apply();
    }

    /**
     * 直接 commit
     */
    public void commitString(String key, String value) {
        mEditor.putString(key, value).commit();
    }
}
