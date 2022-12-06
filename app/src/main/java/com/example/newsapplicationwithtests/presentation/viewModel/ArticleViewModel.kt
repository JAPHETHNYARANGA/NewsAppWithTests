package com.example.newsapplicationwithtests.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplicationwithtests.domain.models.Article
import com.example.newsapplicationwithtests.domain.repository.ArticleRepository
import com.example.newsapplicationwithtests.presentation.utils.Resource
import javax.inject.Inject

class ArticleViewModel @Inject
constructor(private val repository: ArticleRepository):ViewModel() {
    val articles : LiveData<Resource<List<Article>>> = repository.getArticle()
}