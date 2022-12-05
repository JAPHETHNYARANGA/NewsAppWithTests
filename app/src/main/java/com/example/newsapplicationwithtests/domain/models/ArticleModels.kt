package com.example.newsapplicationwithtests.domain.models

data class ArticleModels(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)