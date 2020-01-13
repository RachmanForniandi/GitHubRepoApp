package com.example.githubrepoapp.repository

import com.example.githubrepoapp.modelDAO.Repo
import io.reactivex.Observable

class RepoRepository(val remoteResource:RepoRemoteResource,val  localResource:RepoLocalSource) :RepoDataSource {
    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        return Observable.empty()
    }

    override fun saveRepos(repos: ArrayList<Repo>) {

    }

}