package com.example.newsapplicationwithtests.data.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newsapplicationwithtests.domain.models.Article
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class AppDatabaseTest{
    private lateinit var articleDao: ArticleDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries().build()

        articleDao = db.articleDao()
    }

    @After
    fun teardown(){
        db.close()
    }

    @Test
   fun  writeAndReadDatabase() = runBlocking  {
        val articles = Article(
            "Test", "Test", "test", "test", "test", "test","test"
        )
        articleDao.insertAll(articles)

        val allArticles = articleDao.getAllArticles().value

        assertThat(allArticles, equalTo(allArticles))
    }


}