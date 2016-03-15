package io.github.yamacraft.requestpermissions;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by yamacraft on 2016/03/10.
 */
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
