package com.example.newsapplicationwithtests.domain.repository

import com.example.newsapplicationwithtests.data.network.NewsRemoteDataSource
import com.example.newsapplicationwithtests.data.room.ArticleDao
import com.example.newsapplicationwithtests.presentation.utils.performGetOperation
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource : ArticleDao) {
    fun getArticle() = performGetOperation(
        databaseQuery = {localDataSource.getAllArticles()},
        networkCall = {remoteDataSource.getArticles()},
        saveCallResult = {localDataSource.insertAll(it.articles)}

    )

}