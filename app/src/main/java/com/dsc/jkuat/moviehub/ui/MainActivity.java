package com.dsc.jkuat.moviehub.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.jkuat.moviehub.R;
import com.dsc.jkuat.moviehub.data.DummyDataKt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMovies = findViewById(R.id.recycler_view_movies);
        initRecyclerView(rvMovies);
    }

    private void initRecyclerView(RecyclerView rvMovies) {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        MoviesAdapter vMoviesAdapter = new MoviesAdapter(DummyDataKt.provideDummyData());
        rvMovies.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvMovies.setAdapter(vMoviesAdapter);
    }
}
