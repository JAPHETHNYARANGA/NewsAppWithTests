package com.example.newsapplicationwithtests.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapplicationwithtests.domain.models.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: Article)

}