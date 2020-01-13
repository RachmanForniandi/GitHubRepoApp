package com.example.githubrepoapp.repository

import com.example.githubrepoapp.model.Repo
import io.reactivex.Observable

object RepoLocalSource:RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.empty()
    }

    override fun saveRepos(repos: ArrayList<Repo>) {

    }
}