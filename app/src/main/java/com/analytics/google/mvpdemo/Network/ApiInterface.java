package com.analytics.google.mvpdemo.Network;

import com.analytics.google.mvpdemo.Network.pojo.CityResponse;
import com.analytics.google.mvpdemo.ui.News.pojo.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("v2/top-headlines")
    Call<News> getNewsList(@Query("sources") String sources,@Query("apiKey") String apiKey);
}
