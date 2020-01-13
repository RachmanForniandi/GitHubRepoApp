package com.example.githubrepoapp.repository

import com.example.githubrepoapp.modelDAO.Repo
import io.reactivex.Observable

object RepoRemoteResource :RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.empty()
    }

    override fun saveRepos(repos: ArrayList<Repo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}