package com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.api

import com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.response.NewsResponse
import com.srivathsanvenkateswaran.mvvmnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET(
        value = "v2/everything"
    )
    suspend fun getCryptoNews(
        @Query(
            value = "q"
        )
        newsTopic: String = "crypto",
        @Query(
            value = "page"
        )
        pageNumber: Int = 1,
        @Query(
            value = "apiKey"
        )
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET(
            value = "v2/everything"
        )
        suspend fun searchNews(
            @Query(
                value = "q"
            )
            searchQuery: String,
            @Query(
                value = "page"
            )
            pageNumber: Int = 1,
            @Query(
                value = "apiKey"
            )
            apiKey: String = API_KEY
        ): Response<NewsResponse>
}