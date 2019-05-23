package com.dsc.jkuat.moviehub.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.jkuat.moviehub.R;
import com.dsc.jkuat.moviehub.model.Movie;

import java.util.List;


public final class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movie> mMovieList;

    MoviesAdapter(List<Movie> movieList) {
        mMovieList = movieList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater vInflater = LayoutInflater.from(parent.getContext());
        View v = vInflater.inflate(R.layout.movie_item_layout, parent, false);
        return new MoviesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.movieTitle.setText(mMovieList.get(position).getTitle());
        holder.movieRating.setText(mMovieList.get(position).getRatings());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle, movieRating;

        MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.text_view_movie_title);
            movieRating = itemView.findViewById(R.id.text_view_movie_ratings);
        }
    }
}
