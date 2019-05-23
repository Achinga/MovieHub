package com.dsc.jkuat.moviehub.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.jkuat.moviehub.R;
import com.dsc.jkuat.moviehub.model.Movie;
import com.dsc.jkuat.moviehub.service.MovieListResponse;
import com.dsc.jkuat.moviehub.service.MoviesApi;
import com.dsc.jkuat.moviehub.service.MoviesApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvMovies = findViewById(R.id.recycler_view_movies);
//        initRecyclerView(rvMovies)
        loadData();
    }

    private void initRecyclerView(RecyclerView rvMovies, MoviesAdapter adapter) {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
//        MoviesAdapter vMoviesAdapter = new MoviesAdapter(DummyDataKt.provideDummyData());
        rvMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMovies.setAdapter(adapter);
    }

    private void loadData() {
        MoviesApi vMoviesApi = MoviesApiService.INSTANCE.getInstance();
        vMoviesApi
                .getPopularMovies("Put Your Api Key Here Only For Now")
                .enqueue(new Callback<MovieListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieListResponse> call, @NonNull Response<MovieListResponse> response) {
                        if (response.body() != null) {
                            List<Movie> listOfMovies = response.body().component1();
                            if (!listOfMovies.isEmpty())
                                initRecyclerView(mRvMovies, new MoviesAdapter(listOfMovies));
//                                Log.d(MainActivity.class.getSimpleName(), vMovies.get(0).toString());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MovieListResponse> call, @NonNull Throwable t) {
                        Log.e(MainActivity.class.getSimpleName(), t.getMessage());
                    }
                });
    }

}
