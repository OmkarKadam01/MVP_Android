package com.analytics.google.mvpdemo.ui.Base.presenter;

import com.analytics.google.mvpdemo.ui.Base.view.BaseView;

public interface Presenter <V extends BaseView> {

       /* Bundle getStateBundle();*/

        void attachView(V view);

        void detachView();

     //   V getView();

     /*   boolean isViewAttached();

        void onPresenterDestroy();*/

}

