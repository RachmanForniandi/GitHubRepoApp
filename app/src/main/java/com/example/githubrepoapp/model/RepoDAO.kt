package com.example.githubrepoapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import java.util.*
import kotlin.collections.ArrayList

@Dao
interface RepoDAO {
    @Query("SELECT * FROM repo")
    fun fetchAllMyRepos():Observable<ArrayList<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStarRepos(repos:ArrayList<Repo>)
}