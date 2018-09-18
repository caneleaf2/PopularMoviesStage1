package com.udacityclass.android.popularmovies;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    public static final String BASE_URL="http://image.tmdb.org/t/p/w342";
    private static final String TAG = MovieAdapter.class.getSimpleName();
    private List<Movie> mMovieData;
    private int mNumberItems;



    public MovieAdapter(int numberOfItems){
        this.mNumberItems = numberOfItems;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutForListItem, viewGroup, shouldAttachToParentImmediately);
        MovieViewHolder movieViewHolder= new MovieViewHolder(view);




        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        String posterPath = this.BASE_URL+ mMovieData.get(position).getPoster_path();
        Picasso.with(holder.mMovieImageView.getContext())
                .load(posterPath)
                .into(holder.mMovieImageView);

    }


    @Override
    public int getItemCount() {
        if (mMovieData == null){
            return 0;
        }else {
            return mMovieData.size();
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setMovieData(List<Movie> movies){
        this.mMovieData = movies;
        notifyDataSetChanged();

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        public ImageView mMovieImageView;


        public MovieViewHolder(View view){
            super(view);
            mMovieImageView = (ImageView) view.findViewById(R.id.img_movie_picture);

        }

        void bind(int position){
            String movieTitle = mMovieData.get(position).getTitle();
            String moviePosterUrl =  mMovieData.get(position).getPoster_path();

            Uri uri = Uri.parse(moviePosterUrl).buildUpon().build();

            mMovieImageView.setImageURI(uri);

        }

    }
}
