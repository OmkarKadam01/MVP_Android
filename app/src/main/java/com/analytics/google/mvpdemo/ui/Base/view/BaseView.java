package com.analytics.google.mvpdemo.ui.Base.view;

public interface BaseView<T> {
    void onNetworkLost();

    void onNetworkAvailable();

    void hideLoading();

    void showLoading();

    void onLoad(T data);

    void onError(Object object);
}
