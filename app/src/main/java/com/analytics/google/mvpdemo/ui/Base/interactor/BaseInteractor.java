package com.analytics.google.mvpdemo.ui.Base.interactor;

public interface BaseInteractor<T> {
    void run() throws Exception;

    void onSuccess(T object);

    void onError(T object);
}
