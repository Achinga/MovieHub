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
        rvMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMovies.setAdapter(vMoviesAdapter);
    }
//    TODO 1. Create an account with movie provider api and get an api key for data access
//    TODO 2. Import a http library like Retrofit that will carry out async or sync requests
//     (you can check out Volley too)
//    TODO 3. Add Internet Permission
//    TODO 4. Create an interface that defines endpoints to the data you wish to access
//    TODO 5. Create an instance to Retrofit using the builder class that will facilitate calls to the endpoints
//     and return responses eg query for upcoming movies should return a list of upcoming movies
//    TODO 6. Bind Movie List Data to Recycler View
}
