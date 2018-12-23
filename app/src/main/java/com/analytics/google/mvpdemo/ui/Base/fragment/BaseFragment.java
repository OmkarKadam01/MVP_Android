package com.analytics.google.mvpdemo.ui.Base.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.analytics.google.mvpdemo.ui.Base.presenter.Presenter;
import com.analytics.google.mvpdemo.ui.Base.view.BaseView;

public abstract class BaseFragment <V extends BaseView,P extends Presenter<V>> extends Fragment {
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



//        presenter = viewModel.getPresenter();initPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }

    }

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        initDestroy();
    }

    public void initDestroy() {
        if (presenter != null) {

            presenter.detachView();
        }
    }

    protected abstract P initPresenter();


}
