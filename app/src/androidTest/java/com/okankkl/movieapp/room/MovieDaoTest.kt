package com.okankkl.movieapp.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.okankkl.movieapp.data.local.room.MovieDao
import com.okankkl.movieapp.data.local.room.MovieDatabase
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule

@ExperimentalCoroutinesApi
@SmallTest
@RunWith(AndroidJUnit4::class)
class MovieDaoTest {
    
    // Herşeyi main thraed'de çalıştıracağımızı söyledik
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    private lateinit var movieDao: MovieDao
    private lateinit var database: MovieDatabase
    
    // Create database and dao
    @Before
    fun setup(){
        // geçici database
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDatabase::class.java
        ).allowMainThreadQueries().build()
        
        movieDao = database.dao()
    }
    
    @After
    fun closeDatabase(){
        database.close()
    }
    
    @Test
    fun insertFavouriteMovie() = runBlocking {
        val favourite = FavouriteEntity(1,"null","null","The Lord of The Rings")
        movieDao.addFavourite(favourite)
        
        val favouriteList = movieDao.getFavourites()
        // if it is not null return favourite,
        val result = favouriteList.find { it.id == favourite.id} != null
        assert(result)
    }
    
    @Test
    fun deleteFavouriteMovie() = runBlocking {
        val favourite = FavouriteEntity(1,"null","null","The Lord of The Rings")
        movieDao.addFavourite(favourite)
        movieDao.deleteFavourite(favourite.id)
        
        val favouriteList = movieDao.getFavourites()
        // if it is not find if it is null
        val result = favouriteList.find { it.id == favourite.id } == null
        assert(result)
    }
    
    @Test
    fun getMovies() = runBlocking{
        val movie1 = MovieEntity(1,100,"null","null","The Lord of The Rings",MovieListType.Popular.routeName)
        val movie2 = MovieEntity(2,101,"null","null","Deadpool and Wolverine",MovieListType.NowPlaying.routeName)
        val movie3 = MovieEntity(3,102,"null","null","The Lord of The Rings",MovieListType.Popular.routeName)
    
        val movieList = listOf(movie1,movie2,movie3)
        movieDao.addMovies(movieList)
        
        val movieListFromDb = movieDao.getMovies()
        val result = movieListFromDb.size == 3
        assert(result)
    }
}