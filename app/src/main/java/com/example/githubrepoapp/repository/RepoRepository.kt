package com.example.githubrepoapp.repository

import com.example.githubrepoapp.modelDAO.Repo
import io.reactivex.Observable

class RepoRepository(val remoteResource:RepoRemoteResource, val  localResource:RepoLocalSource) :RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        //return Observable.empty()
        return Observable.concat(localResource.fetchRepos(username),
            remoteResource.fetchRepos(username))
            .doOnNext{it -> saveRepos(it)}
            .onErrorResumeNext(Observable.empty())
    }

    override fun saveRepos(repos: List<Repo>) {
        Observable.fromCallable { localResource.saveRepos(repos) }
    }

}