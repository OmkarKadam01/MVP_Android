package com.analytics.google.mvpdemo.ui.Base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.analytics.google.mvpdemo.ui.Base.view.BaseView;
import com.analytics.google.mvpdemo.ui.Base.presenter.Presenter;

public abstract class BaseActivity < V extends BaseView,P extends Presenter<V>> extends AppCompatActivity
        implements BaseView {
    protected P presenter;

    protected abstract int getLayout();

    protected abstract P initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.detachView();
        }
    }


}
