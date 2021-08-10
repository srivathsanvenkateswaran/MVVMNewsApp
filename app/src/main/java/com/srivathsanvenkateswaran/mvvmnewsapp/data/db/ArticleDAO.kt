package com.srivathsanvenkateswaran.mvvmnewsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.response.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query(
        value = "SELECT * FROM articles"
    )
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}