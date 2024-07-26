package com.okankkl.movieapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.okankkl.movieapp.data.data_source.DataStoreManager
import com.okankkl.movieapp.data.data_source.LocalDataSource
import com.okankkl.movieapp.data.data_source.RemoteDataSource
import com.okankkl.movieapp.data.local.room.MovieDao
import com.okankkl.movieapp.data.local.room.MovieDatabase
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.repository.MovieRepository
import com.okankkl.movieapp.data.repository.MovieRepositoryImp
import com.okankkl.movieapp.ui.screen.favourites.FavouritesFragmentViewModel
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class FavouriteFragmentViewModelTest
{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    
    private lateinit var db : MovieDatabase
    
    private lateinit var dao : MovieDao
    
    @Mock
    private lateinit var repository : MovieRepository
    
    @Mock
    private lateinit var localDataSource: LocalDataSource
    
    private lateinit var viewModel : FavouritesFragmentViewModel
    
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        val db = Room.inMemoryDatabaseBuilder(
            mockk(relaxed = true),
            MovieDatabase::class.java
        ).build()
        
        dao = db.dao()
        localDataSource = LocalDataSource(dao)
        val dataStoreManager = mockk<DataStoreManager>(relaxed = true)
        val remoteDataSource = mockk<RemoteDataSource>(relaxed = true)
        
        repository = MovieRepositoryImp(
            dataStoreManager,
            localDataSource,
            remoteDataSource
        )
        viewModel = FavouritesFragmentViewModel(repository)
    }
    
    @After
    fun closeDb(){
        db.close()
    }
    
    @Test
    fun getFavouriteList() = runBlocking{
        
        val favourite1 = FavouriteEntity(1,"path","path","The Lord of The Rings: Return The King")
        val favourite2 = FavouriteEntity(2,"path","path","The Lord of The Rings: The Two Towers")
        val favourite3 = FavouriteEntity(3,"path","path","The Lord of The Rings: Fellowship of The Ring")
        
        dao.addFavourite(favourite1)
        dao.addFavourite(favourite2)
        dao.addFavourite(favourite3)
        
        viewModel.getFavouritesList()
        val state = viewModel.state.last()
        assert(state.favourites != null)
    }
}