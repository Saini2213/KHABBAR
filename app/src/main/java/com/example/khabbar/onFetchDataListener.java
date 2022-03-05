package com.example.khabbar;

import com.example.khabbar.Models.NewsHeadline;

import java.util.List;

public interface onFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadline> list, String message);
    void onError(String message);

}
