package com.example.githubrepoapp.model

import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language

data class Repo(@SerializedName("name")val name:String,
                @SerializedName("description")val desc:String,
                @SerializedName("language")val lang: String,
                @SerializedName("stargazers_count")val starCount: Int)