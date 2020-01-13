package com.example.githubrepoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.githubrepoapp.adapter.RepoAdapter
import com.example.githubrepoapp.model.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import com.example.githubrepoapp.viewmodel.RepoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_my_star_repos.*

class MyStarReposActivity : AppCompatActivity() {

    val repoList = ArrayList<Repo>()
    private  lateinit var repoAdapter :RepoAdapter
    private lateinit var repoViewModel: RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_star_repos)

        repoAdapter = RepoAdapter()
        repoAdapter.addReposDummy(repoList)
        listStarredRepo.adapter = repoAdapter

       /* repoList.add(Repo("ProjectAndroid_1", "simple project android using java","Java"))
        repoList.add(Repo("ProjectAndroid_2", "simple project android using kotlin", "Kotlin"))
        repoList.add(Repo("ProjectAndroid_3", "Example android project design pattern MVP using java", "Java"))
        repoList.add(Repo("ProjectAndroid_4", "Example android project design pattern MVP using Kotlin", "Kotlin"))
        repoList.add(Repo("ProjectAndroid_5", "android project design pattern MVVM using kotlin", "Kotlin"))*/
        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)

        getStaredRepo(repoViewModel)
        observeMyStars(repoViewModel)

    }

    fun getStaredRepo(viewModel: RepoViewModel){
        /*RepoGithubClient.getRepoGithubService().getStarredRepo("RachmanForniandi")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it->
                repoAdapter.addReposDummy(it)

            }*/
        viewModel.obtainStarRepos("RachmanForniandi")
    }

    fun observeMyStars(viewModel: RepoViewModel){
        viewModel.getLiveData().observe(this, Observer {
            repos -> repoAdapter.addReposDummy(repos!!)
        })
    }

}
