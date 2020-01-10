package com.example.githubrepoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.githubrepoapp.model.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val compositeDispose = CompositeDisposable()
    val repoLiveData = MutableLiveData<ArrayList<Repo>>()

    fun obtainStarRepos(username:String){

        val reposDisposable = RepoGithubClient.getRepoGithubService().getStarredRepo(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it->repoLiveData.value = it
                //repoAdapter.addReposDummy(it)

            }
        compositeDispose.add(reposDisposable)
    }

    fun getLiveData():LiveData<ArrayList<Repo>> = repoLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDispose.clear()
    }
}