package com.example.githubrepoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.githubrepoapp.modelDAO.Repo
import io.reactivex.Observable

class RepoViewModel: ViewModel() {

    fun obtainStarRepos():Observable<List<Repo>>{
        return Observable.empty()
    }

    override fun onCleared() {
        super.onCleared()
    }
}