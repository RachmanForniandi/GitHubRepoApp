package com.example.githubrepoapp.modelDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import kotlin.collections.ArrayList

@Dao
interface RepoDAO {
    @Query("SELECT * FROM repo")
    fun fetchAllMyRepos():List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStarRepos(repos:List<Repo>)
}