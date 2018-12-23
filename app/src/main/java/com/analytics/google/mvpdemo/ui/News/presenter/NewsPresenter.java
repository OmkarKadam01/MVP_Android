package com.analytics.google.mvpdemo.ui.News.presenter;

import com.analytics.google.mvpdemo.ui.Base.CallBack;
import com.analytics.google.mvpdemo.ui.Base.presenter.BasePresenter;
import com.analytics.google.mvpdemo.ui.News.interactor.NewsInteractor;
import com.analytics.google.mvpdemo.ui.News.view.NewsView;

public class NewsPresenter extends BasePresenter <NewsView> {

    public void loadNews () throws Exception{

        NewsInteractor interactor= new NewsInteractor();
        interactor.setNewsResponseCallback(new CallBack<Object>() {
            @Override
            public void onSuccess(Object object) {
                if (viewNotNull()){
                    view.onLoad(object);
                }
            }

            @Override
            public void onError(Object object) {
                if (viewNotNull()){
                    view.onError(object);
                }
            }
        });
        interactor.run();
    }

}
