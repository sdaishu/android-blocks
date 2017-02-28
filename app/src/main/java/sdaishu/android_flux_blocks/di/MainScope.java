package sdaishu.android_flux_blocks.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by cq on 2017/2/28.
 * 标记主module
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface MainScope {}
