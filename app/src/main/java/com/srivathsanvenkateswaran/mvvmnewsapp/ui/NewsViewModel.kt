package com.srivathsanvenkateswaran.mvvmnewsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.models.NewsResponse
import com.srivathsanvenkateswaran.mvvmnewsapp.repository.NewsRepository
import com.srivathsanvenkateswaran.mvvmnewsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
): ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getCryptoNews("crypto")
    }

    fun getCryptoNews(newsTopic: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getCryptoNews(newsTopic = newsTopic, pageNumber = breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}