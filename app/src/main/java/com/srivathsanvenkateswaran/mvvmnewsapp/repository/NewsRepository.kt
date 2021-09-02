package com.srivathsanvenkateswaran.mvvmnewsapp.repository

import com.srivathsanvenkateswaran.mvvmnewsapp.data.db.ArticleDatabase
import com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.api.RetrofitInstance

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getCryptoNews(newsTopic: String, pageNumber: Int) =
        RetrofitInstance.api.getCryptoNews(newsTopic, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)
}