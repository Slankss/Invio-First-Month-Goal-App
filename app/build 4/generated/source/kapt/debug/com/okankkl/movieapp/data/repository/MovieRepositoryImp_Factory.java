// Generated by Dagger (https://dagger.dev).
package com.okankkl.movieapp.data.repository;

import com.okankkl.movieapp.data.local.room.database.MovieDao;
import com.okankkl.movieapp.data.remote.MovieApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MovieRepositoryImp_Factory implements Factory<MovieRepositoryImp> {
  private final Provider<MovieApi> movieApiProvider;

  private final Provider<MovieDao> movieDaoProvider;

  public MovieRepositoryImp_Factory(Provider<MovieApi> movieApiProvider,
      Provider<MovieDao> movieDaoProvider) {
    this.movieApiProvider = movieApiProvider;
    this.movieDaoProvider = movieDaoProvider;
  }

  @Override
  public MovieRepositoryImp get() {
    return newInstance(movieApiProvider.get(), movieDaoProvider.get());
  }

  public static MovieRepositoryImp_Factory create(Provider<MovieApi> movieApiProvider,
      Provider<MovieDao> movieDaoProvider) {
    return new MovieRepositoryImp_Factory(movieApiProvider, movieDaoProvider);
  }

  public static MovieRepositoryImp newInstance(MovieApi movieApi, MovieDao movieDao) {
    return new MovieRepositoryImp(movieApi, movieDao);
  }
}
