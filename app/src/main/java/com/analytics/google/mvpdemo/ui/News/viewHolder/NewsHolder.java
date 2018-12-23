package com.analytics.google.mvpdemo.ui.News.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.analytics.google.mvpdemo.R;
import com.analytics.google.mvpdemo.ui.News.pojo.Article;
import com.analytics.google.mvpdemo.ui.News.pojo.News;
import com.bumptech.glide.Glide;

public class NewsHolder extends RecyclerView.ViewHolder {
    private TextView newsTitle;
    private ImageView newsImage;
    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        newsTitle = (TextView) itemView.findViewById(R.id.newsTitle);
        newsImage= (ImageView) itemView.findViewById(R.id.newsImage);

    }

    public void loadNews(Article article){
        newsTitle.setText(article.getTitle());
        Glide.with(newsImage.getContext()).load(article.getUrlToImage()).into(newsImage);

    }
}
