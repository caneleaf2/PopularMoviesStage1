package com.udacityclass.android.popularmovies.utility;

import android.net.Uri;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.udacityclass.android.popularmovies.Movie;
import com.udacityclass.android.popularmovies.PopularMovieResponse;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * To fetch the popular movies list
 */
public class NetworkUtils {

    final static String TMBD_API_KEY="30f768fcd8b3e61c29aef0a7c3046800";
    final static String TMDB_POPULAR_MOVIES="http://api.themoviedb.org/3/movie/popular?api_key="+TMBD_API_KEY;

    public static URL buildUrl() throws Exception{
        return new URL(TMDB_POPULAR_MOVIES);
//        System.out.println("TMDB Movies:"+TMDB_POPULAR_MOVIES);
//
//        Uri uri = Uri.parse(TMDB_POPULAR_MOVIES).buildUpon()
//                .build();
//
//        URL url = null;
//        try{
//            url = new URL(uri.toString());
//        }catch(MalformedURLException e){
//            e.printStackTrace();
//        }
//        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }


    public static List<Movie> getMovieDataFromJson(String rawJson)throws Exception{

        Gson gson = new Gson();
        PopularMovieResponse response = gson.fromJson(rawJson, PopularMovieResponse.class);
        Movie[] movies = response.getResults();
        List<Movie> movieList=Arrays.asList(movies);

        return movieList;
    }



}

