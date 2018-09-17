package com.udacityclass.android.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMovieList;
    private MovieImageAdapter movieImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieList = (RecyclerView) findViewById(R.id.rv_movie_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMovieList.setLayoutManager(layoutManager);

        mMovieList.setHasFixedSize(false);

        int movieCounts=100;
        movieImageAdapter = new MovieImageAdapter(movieCounts,this);
        mMovieList.setAdapter(movieImageAdapter);


    }


}
