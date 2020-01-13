package com.example.githubrepoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubrepoapp.adapter.RepoAdapter
import com.example.githubrepoapp.modelDAO.Repo
import com.example.githubrepoapp.networkUtils.RepoGithubClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_my_star_repos.*

class MyStarReposActivity : AppCompatActivity() {

    val repoList = ArrayList<Repo>()
    private  lateinit var repoAdapter :RepoAdapter
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

        getStarredRepo()

    }

    fun getStarredRepo(){
        RepoGithubClient.getRepoGithubService().getStarredRepo("RachmanForniandi")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it->
                repoAdapter.addReposDummy(it)
            }
    }

}
