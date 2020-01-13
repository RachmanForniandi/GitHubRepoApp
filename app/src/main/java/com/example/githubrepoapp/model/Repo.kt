package com.example.githubrepoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language

@Entity(tableName = "repo")
data class Repo(
                @PrimaryKey
                @ColumnInfo(name = "id")
                @SerializedName("id")val id:String,
                @ColumnInfo(name = "name")
                @SerializedName("name")val name:String,
                @ColumnInfo(name = "description")
                @SerializedName("description")val desc:String,
                @ColumnInfo(name = "language")
                @SerializedName("language")val lang: String,
                @ColumnInfo(name = "stargazers_count")
                @SerializedName("stargazers_count")val starCount: Int
)