package com.example.githubrepoapp.repository

import com.example.githubrepoapp.RxApp
import com.example.githubrepoapp.modelDAO.AppDatabase
import com.example.githubrepoapp.modelDAO.Repo
import io.reactivex.Observable

object RepoLocalSource:RepoDataSource {

    override fun fetchRepos(username: String): Observable<ArrayList<Repo>> {
        //return Observable.empty()
        return AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchAllMyRepos()
    }

    override fun saveRepos(repos: ArrayList<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllStarRepos(repos)
    }
}