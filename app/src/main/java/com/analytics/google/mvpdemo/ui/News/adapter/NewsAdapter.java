package com.analytics.google.mvpdemo.ui.News.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.analytics.google.mvpdemo.R;
import com.analytics.google.mvpdemo.ui.News.NewsConstants;
import com.analytics.google.mvpdemo.ui.News.pojo.Article;
import com.analytics.google.mvpdemo.ui.News.viewHolder.NewsHolder;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Article> list=new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            //For Athlete
            case NewsConstants.ViewType.NEWS_TYPE:
                View viewAthlete = layoutInflater.inflate(R.layout.news_item, viewGroup, false);
                viewHolder = new NewsHolder(viewAthlete);
                break;

            //For FOotball
            default:
                View viewFootball = layoutInflater.inflate(R.layout.news_item, viewGroup, false);
                viewHolder = new NewsHolder(viewFootball);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            //For Athlete
            case NewsConstants.ViewType.NEWS_TYPE:
                NewsHolder newsViewHolder = (NewsHolder) viewHolder;
                newsViewHolder.loadNews(list.get(position));
                break;
            //For Football
            default:
                NewsHolder viewHolderAthlete1 = (NewsHolder) viewHolder;
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return NewsConstants.ViewType.NEWS_TYPE;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<Article> list){
       this.list=list;
       notifyChange();
    }

    public void Add(Article object){
        this.list.add(object);
        notifyChange();
    }

     public void replace(Article object, int position){
        this.list.set(position,object);
         notifyChange();
    }

     public void remove(int position){
        this.list.remove(position);
         notifyChange();
    }

     public void removeAll(){
         this.list.clear();
         notifyChange();
    }

     public void notifyChange(){
        notifyDataSetChanged();
    }



}
