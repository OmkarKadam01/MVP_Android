package com.analytics.google.mvpdemo.ui.News.interactor;

import com.analytics.google.mvpdemo.Network.ApiClient;
import com.analytics.google.mvpdemo.Network.ApiInterface;
import com.analytics.google.mvpdemo.ui.Base.CallBack;
import com.analytics.google.mvpdemo.ui.Base.interactor.BaseInteractor;
import com.analytics.google.mvpdemo.ui.News.pojo.News;
import com.analytics.google.mvpdemo.ui.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsInteractor implements BaseInteractor {
    public void setNewsResponseCallback(CallBack<Object> newsResponseCallback) {
        this.newsResponseCallback = newsResponseCallback;
    }

    private CallBack<Object> newsResponseCallback;

    @Override
    public void run() throws Exception {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<News> call = apiService.getNewsList("espn-cric-info",Constants.NewsConstants.apiKey);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                onError( t);
            }
        });

    }

    @Override
    public void onSuccess(Object object) {
        newsResponseCallback.onSuccess(object);
    }

    @Override
    public void onError(Object object) {
    newsResponseCallback.onError(object);
    }
}
