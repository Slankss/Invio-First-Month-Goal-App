// Generated by Dagger (https://dagger.dev).
package com.okankkl.movieapp.ui.movie_detail_screen;

import com.okankkl.movieapp.domain.repository.MovieRepository;
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
public final class MovieDetailFragmentViewModel_Factory implements Factory<MovieDetailFragmentViewModel> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  public MovieDetailFragmentViewModel_Factory(Provider<MovieRepository> movieRepositoryProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
  }

  @Override
  public MovieDetailFragmentViewModel get() {
    return newInstance(movieRepositoryProvider.get());
  }

  public static MovieDetailFragmentViewModel_Factory create(
      Provider<MovieRepository> movieRepositoryProvider) {
    return new MovieDetailFragmentViewModel_Factory(movieRepositoryProvider);
  }

  public static MovieDetailFragmentViewModel newInstance(MovieRepository movieRepository) {
    return new MovieDetailFragmentViewModel(movieRepository);
  }
}
