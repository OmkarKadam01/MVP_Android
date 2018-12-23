package com.analytics.google.mvpdemo.ui.Base;

public interface CallBack<T> {
    void onSuccess(T object);
    void onError (T object);
}
