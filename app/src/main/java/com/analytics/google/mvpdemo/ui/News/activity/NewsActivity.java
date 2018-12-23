package com.analytics.google.mvpdemo.ui.News.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.analytics.google.mvpdemo.Network.pojo.CityResponse;
import com.analytics.google.mvpdemo.R;
import com.analytics.google.mvpdemo.ui.Base.activity.BaseActivity;
import com.analytics.google.mvpdemo.ui.News.adapter.NewsAdapter;
import com.analytics.google.mvpdemo.ui.News.pojo.News;
import com.analytics.google.mvpdemo.ui.News.presenter.NewsPresenter;
import com.analytics.google.mvpdemo.ui.News.view.NewsView;
import com.analytics.google.mvpdemo.ui.utils.Constants;

public class NewsActivity extends BaseActivity<NewsView,NewsPresenter> implements NewsView {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        try {
            adapter= new NewsAdapter()  ;
            mLayoutManager = new LinearLayoutManager(NewsActivity.this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(adapter);
            presenter.loadNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    public void onNetworkLost() {
        Toast.makeText(this,"Network Lost",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkAvailable() {
        try {
            if (presenter!=null)
            presenter.loadNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Network Available",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onLoad(Object data) {

        Message msg= new Message();
        msg.obj=data;
        msg.what=Constants.NewsConstants.LoadType.NEWS_LOAD;
        handler.sendMessage(msg);

    }

    @Override
    public void onError(Object object) {

    }
    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case Constants.NewsConstants.LoadType.NEWS_LOAD:
                {
                    News data= (News) message.obj;
                    Log.e("Android",">> "+data.toString());
                    /*TextView tx=(TextView)findViewById(R.id.Name);
                    tx.setText( data.getArticles().get(0).getAuthor());*/
                        adapter.addAll(data.getArticles());

                }
            }
            return true;
        }
    });
}
