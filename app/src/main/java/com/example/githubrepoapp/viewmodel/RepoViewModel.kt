package com.example.githubrepoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.githubrepoapp.model.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val repoLiveData = MutableLiveData<List<Repo>>()

    fun obtainStarRepos(username:String){
        RepoGithubClient.getRepoGithubService().getStarredRepo(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it->repoLiveData.value = it
                //repoAdapter.addReposDummy(it)

            }
    }

    override fun onCleared() {
        super.onCleared()
    }
}