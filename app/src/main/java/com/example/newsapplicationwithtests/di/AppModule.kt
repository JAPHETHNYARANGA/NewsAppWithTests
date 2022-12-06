package com.example.newsapplicationwithtests.di

import android.content.Context
import com.example.newsapplicationwithtests.data.network.NewsRemoteDataSource
import com.example.newsapplicationwithtests.data.network.NewsService
import com.example.newsapplicationwithtests.data.room.AppDatabase
import com.example.newsapplicationwithtests.data.room.ArticleDao
import com.example.newsapplicationwithtests.domain.repository.ArticleRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsService ) =
        NewsRemoteDataSource(newsService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext : Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db :AppDatabase) = db.articleDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: NewsRemoteDataSource,
        localDataSource: ArticleDao
    ) = ArticleRepository(remoteDataSource, localDataSource)
}