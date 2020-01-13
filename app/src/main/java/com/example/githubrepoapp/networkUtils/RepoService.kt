package com.example.githubrepoapp.networkUtils

import com.example.githubrepoapp.modelDAO.Repo
import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.Observable
import kotlin.collections.ArrayList

interface RepoService {
    @GET("users/{user}/starred")
    fun getStarredRepo(@Path("user")username:String):Observable<ArrayList<Repo>>
}