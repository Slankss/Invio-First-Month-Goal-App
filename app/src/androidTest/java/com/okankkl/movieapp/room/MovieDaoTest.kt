package com.okankkl.movieapp.room

import android.content.Context
import android.text.TextUtils
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.okankkl.movieapp.data.local.room.MovieDao
import com.okankkl.movieapp.data.local.room.MovieDatabase
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.Throws
import org.hamcrest.MatcherAssert.assertThat
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {
    
    private lateinit var movieDao: MovieDao
    private lateinit var db : MovieDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,MovieDatabase::class.java
        ).allowMainThreadQueries().build()
        movieDao = db.dao()
    }
    
    @After
    fun closeDb(){
        db.close()
    }
    
    @Test
    @Throws(Exception::class)
    fun addMovieToFavourites() = runBlocking{
        val favourite = FavouriteEntity(0,"posterPath","backdropPath","lord of the rings")
        movieDao.addFavourite(favourite)
        
        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            val favourites = movieDao.getFavourites()
            // isMovieInFavorites returns 0 if movie is not in favourites
            val result = movieDao.isMovieInFavourites(100) > 0
            
            assert(result)
            latch.countDown()
        }
        latch.await()
        // Wait for the job to complete and cancel it
        job.cancelAndJoin()
    }
    
  
    
}