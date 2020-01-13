package com.example.githubrepoapp.repository

import com.example.githubrepoapp.model.Repo
import io.reactivex.Observable
import java.util.*
import kotlin.collections.ArrayList

interface RepoDataSource {

    fun fetchRepos(username:String):Observable<ArrayList<Repo>>
    fun saveRepos(repos:ArrayList<Repo>)
}