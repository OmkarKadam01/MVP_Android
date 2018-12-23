
package com.analytics.google.mvpdemo.ui.News.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class News {

    @SerializedName("articles")
    private List<Article> mArticles;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("totalResults")
    private Long mTotalResults;

    public List<Article> getArticles() {
        return mArticles;
    }

    public void setArticles(List<Article> articles) {
        mArticles = articles;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

    @Override
    public String toString() {
        return "News{" +
                "mArticles=" + mArticles +
                ", mStatus='" + mStatus + '\'' +
                ", mTotalResults=" + mTotalResults +
                '}';
    }
}
