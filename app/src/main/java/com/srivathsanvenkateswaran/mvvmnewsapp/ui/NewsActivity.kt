package com.srivathsanvenkateswaran.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.srivathsanvenkateswaran.mvvmnewsapp.R
import com.srivathsanvenkateswaran.mvvmnewsapp.data.db.ArticleDatabase
import com.srivathsanvenkateswaran.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(
            db = ArticleDatabase(this)
        )

        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val newsNavHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment)

        newsNavHostFragment?.let { newsNavHostFragment->
            bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
        }
    }
}