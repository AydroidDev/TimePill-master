package com.dante.diary.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.im.v2.AVIMMessageManager;
import com.avos.avoscloud.im.v2.messages.AVIMTextMessage;
import com.blankj.utilcode.utils.Utils;
import com.bugtags.library.Bugtags;
import com.dante.diary.chat.PMMessageHandler;

import io.realm.Realm;


public class App extends Application {
    public static final String LEAN_APP_ID = "Q2ysC4w6hRbP6Pe25BcC6sRH-gzGzoHsz";
    public static final String LEAN_APP_KEY = "ITS9V1T9DSWIGXA2Ljw2nL9e";
    public static final String BUGTAGS_APP_KEY = "6db43944fc0b79dce98107999a23f486";
    public static boolean isRunning;
    @SuppressLint("StaticFieldLeak")
    public static Context context;
//    private RefWatcher refWatcher;

//    public static RefWatcher getWatcher(Context context) {
//        App application = (App) context.getApplicationContext();
//        return application.refWatcher;
//    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        isRunning = true;
//        refWatcher = LeakCanary.install(this);
        Bugtags.start(BUGTAGS_APP_KEY, this, Bugtags.BTGInvocationEventNone);
        AVOSCloud.initialize(this, LEAN_APP_ID, LEAN_APP_KEY);
//        AVOSCloud.setDebugLogEnabled(BuildConfig.DEBUG);
        AVIMMessageManager.registerMessageHandler(AVIMTextMessage.class, new PMMessageHandler());
        Realm.init(this);
        Utils.init(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }
}
