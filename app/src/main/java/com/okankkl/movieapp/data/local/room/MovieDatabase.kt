package com.okankkl.movieapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.local.room.entity.MovieEntity

@Database(
    entities = [MovieEntity::class, FavouriteEntity::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase()
{
    abstract fun dao() : MovieDao
    companion object{
        private var INSTANCE : MovieDatabase? = null
        fun getDatabase(context : Context) : MovieDatabase
        {
            val tmpInstance = INSTANCE
            if(tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    "cache_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}