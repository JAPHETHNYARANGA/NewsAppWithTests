package com.example.newsapplicationwithtests.data.network

import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsService :NewsService
) : BaseDataSource(){
    suspend fun getArticles() = getResult { newsService.getAllArticles("tesla", "3d71ad8a2ba04a9a89d36e0eb5910825") }
}