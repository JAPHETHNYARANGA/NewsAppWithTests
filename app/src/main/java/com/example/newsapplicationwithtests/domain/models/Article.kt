package com.example.newsapplicationwithtests.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    val publishedAt: String,
    val author: String?=null,
    val content: String?=null,
    val description: String? = null,
//    val source: Source,
    val title: String? = null,
    val url: String ? = null,
    val urlToImage: String? = null
)