package com.example.githubrepoapp.repository

import com.example.githubrepoapp.modelDAO.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import io.reactivex.Observable

object RepoRemoteResource :RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        //return Observable.empty()
        return RepoGithubClient.getRepoGithubService().getStarredRepo(username)
    }

    override fun saveRepos(repos: List<Repo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}