package com.example.newsapplicationwithtests.data.network

import com.example.newsapplicationwithtests.data.network.NewsRemoteDataSource_Factory.create
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import mockwebserver3.MockWebServer
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject


@ExperimentalCoroutinesApi
@ActivityScoped
class NewsRemoteDataSourceTest {


    @Test
     fun testRetrofitInstance () = runBlocking{

            val api = Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                 .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiResponse = api.create(NewsService::class.java)

            val response = apiResponse.getAllArticles("tesla", "3d71ad8a2ba04a9a89d36e0eb5910825")



            assertThat(response.code(), CoreMatchers.equalTo(200))


    }

}