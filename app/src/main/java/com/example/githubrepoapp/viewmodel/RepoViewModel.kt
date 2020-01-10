package com.example.githubrepoapp.viewmodel

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.githubrepoapp.model.Repo
import io.reactivex.Observable

class RepoViewModel: ViewModel() {

    fun obtainStarRepos():Observable<List<Repo>>{
        return Observable.empty()
    }

    override fun onCleared() {
        super.onCleared()
    }
}