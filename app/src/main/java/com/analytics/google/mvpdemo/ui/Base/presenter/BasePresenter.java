package com.analytics.google.mvpdemo.ui.Base.presenter;

import com.analytics.google.mvpdemo.Network.NetworkChangeHandler;
import com.analytics.google.mvpdemo.Network.NetworkChangeListener;
import com.analytics.google.mvpdemo.Network.NetworkDetails;
import com.analytics.google.mvpdemo.ui.Base.view.BaseView;

public abstract class BasePresenter <V extends BaseView> implements Presenter<V>, NetworkChangeListener {
    public V view;

 /*   @Override
    public Bundle getStateBundle() {
        return null;
    }
*/
    @Override
    public void attachView(V view) {
        this.view=view;
        NetworkChangeHandler.getHandler().registerNetworkChangeListener(this);
    }

    @Override
    public void detachView() {
        view=null;
        NetworkChangeHandler.getHandler().unregisterNetworkChangeListener(this);
    }

    public boolean viewNotNull(){
        return view!=null;
    }

    @Override
    public void onAvailable(NetworkDetails network) {
        if (viewNotNull()){
            view.onNetworkAvailable();
        }
    }

    @Override
    public void onLost(NetworkDetails network) {
        if (viewNotNull()){
            view.onNetworkLost();
        }
    }
 /*   @Override
    public V getView() {
        return null;
    }

    @Override
    public boolean isViewAttached() {
        return false;
    }

    @Override
    public void onPresenterDestroy() {

    }*/
}
