package com.example.githubrepoapp.modelDAO

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Repo::class),version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getRepoDao():RepoDAO
}