package com.dante.diary.net;

import android.support.annotation.CallSuper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.functions.Action1;



public class HttpErrorAction<T> implements Action1<Throwable> {

    protected String errorMessage;

    @CallSuper
    @Override
    public void call(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof HttpException) {
            HttpException e = (HttpException) throwable;
            try {
                String errorResponse = e.response().errorBody().string();
                JSONObject jsonObject = new JSONObject(errorResponse);
                errorMessage = jsonObject.optString("message");

            } catch (IOException | JSONException e1) {
                e1.printStackTrace();
            }
        }
    }


}
