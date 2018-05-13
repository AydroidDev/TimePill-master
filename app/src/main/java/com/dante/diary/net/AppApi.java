package com.dante.diary.net;


import com.dante.diary.model.AppInfo;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;


public interface AppApi {

    @GET("app.json")
    Observable<AppInfo> getAppInfo();

    @GET
    @Streaming
    Observable<ResponseBody> download(@Url String apkUrl);

}
