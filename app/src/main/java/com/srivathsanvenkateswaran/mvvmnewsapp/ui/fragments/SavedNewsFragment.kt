package com.srivathsanvenkateswaran.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.srivathsanvenkateswaran.mvvmnewsapp.R
import com.srivathsanvenkateswaran.mvvmnewsapp.ui.NewsActivity
import com.srivathsanvenkateswaran.mvvmnewsapp.ui.NewsViewModel

class SavedNewsFragment: Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }
}