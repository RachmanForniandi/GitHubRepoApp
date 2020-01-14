package com.example.githubrepoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepoapp.modelDAO.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import com.example.githubrepoapp.repository.RepoLocalSource
import com.example.githubrepoapp.repository.RepoRemoteResource
import com.example.githubrepoapp.repository.RepoRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val repoLiveData = MutableLiveData<List<Repo>>()
    val repository = RepoRepository(RepoRemoteResource,RepoLocalSource)

    fun obtainStarRepos(username:String){
        val repoDisposable = repository.fetchRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{it-> repoLiveData.value =it}
        compositeDisposable.add(repoDisposable)
    }

    fun getLiveData():LiveData<List<Repo>> =repoLiveData
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}