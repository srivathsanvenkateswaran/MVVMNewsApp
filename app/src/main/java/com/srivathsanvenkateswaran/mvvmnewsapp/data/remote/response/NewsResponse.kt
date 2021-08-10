package com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.response

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)