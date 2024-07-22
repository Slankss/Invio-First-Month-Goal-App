// Generated by view binder compiler. Do not edit!
package com.okankkl.movieapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.okankkl.movieapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MovieListItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView moviePosterCardView;

  @NonNull
  public final ImageView moviePosterImg;

  private MovieListItemBinding(@NonNull CardView rootView, @NonNull CardView moviePosterCardView,
      @NonNull ImageView moviePosterImg) {
    this.rootView = rootView;
    this.moviePosterCardView = moviePosterCardView;
    this.moviePosterImg = moviePosterImg;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MovieListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MovieListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.movie_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MovieListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView moviePosterCardView = (CardView) rootView;

      id = R.id.moviePosterImg;
      ImageView moviePosterImg = ViewBindings.findChildViewById(rootView, id);
      if (moviePosterImg == null) {
        break missingId;
      }

      return new MovieListItemBinding((CardView) rootView, moviePosterCardView, moviePosterImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
