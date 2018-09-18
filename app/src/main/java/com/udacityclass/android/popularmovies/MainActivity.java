package com.udacityclass.android.popularmovies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.udacityclass.android.popularmovies.utility.NetworkUtils;

import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_LIST_ITEM = 100;
    private RecyclerView mRecyclerViewMovieList;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerViewMovieList = (RecyclerView) findViewById(R.id.rv_movie_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewMovieList.setLayoutManager(layoutManager);

        mRecyclerViewMovieList.setHasFixedSize(false);


        mMovieAdapter = new MovieAdapter(NUM_LIST_ITEM);
        mRecyclerViewMovieList.setAdapter(mMovieAdapter);

        loadMovieData();
    }

    private void loadMovieData(){
        showMovieDataView();

    }

    void showMovieDataView(){
        mRecyclerViewMovieList.setVisibility(View.VISIBLE);
    }

    public class FetchMovieData extends AsyncTask<URL, Void, List<Movie>>{
        @Override
        protected List<Movie> doInBackground(URL... urls) {
            URL url = urls[0];
            String rawJson = null;
            List<Movie> movies = null;
            try{
                rawJson = NetworkUtils.getResponseFromHttpUrl(url);
                movies=NetworkUtils.getMovieDataFromJson(rawJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return movies;
        }
        @Override
        protected void onPostExecute(List<Movie> movies) {
            mRecyclerViewMovieList.setVisibility(View.VISIBLE);
            mMovieAdapter.setMovieData(movies);
        }



    }

}
