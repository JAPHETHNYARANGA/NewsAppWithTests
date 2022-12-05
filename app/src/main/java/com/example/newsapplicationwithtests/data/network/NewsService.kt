package com.example.newsapplicationwithtests.data.network

import com.bumptech.glide.load.engine.Resource
import com.example.newsapplicationwithtests.domain.models.ArticleModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/everything")
    suspend fun getAllArticles(@Query("q")tesla:String, @Query("apiKey")apiKey:String): Response<ArticleModels>
}