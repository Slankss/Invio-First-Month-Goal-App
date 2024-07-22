// Generated by Dagger (https://dagger.dev).
package com.okankkl.movieapp.di;

import android.content.Context;
import com.okankkl.movieapp.data.local.dataStore.AppPreference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideAppPreferenceFactory implements Factory<AppPreference> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideAppPreferenceFactory(AppModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppPreference get() {
    return provideAppPreference(module, contextProvider.get());
  }

  public static AppModule_ProvideAppPreferenceFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideAppPreferenceFactory(module, contextProvider);
  }

  public static AppPreference provideAppPreference(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideAppPreference(context));
  }
}
