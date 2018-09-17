package com.udacityclass.android.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MovieImageAdapter extends RecyclerView.Adapter<MovieImageAdapter.MovieViewHolder>{

    private int mNumberItems;
    private Context mContext;


    public MovieImageAdapter(int mNumberItems, Context mContext) {
        this.mNumberItems = mNumberItems;
        this.mContext = mContext;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutForListItem, viewGroup, shouldAttachToParentImmediately);
        MovieViewHolder movieViewHolder= new MovieViewHolder(view);

        Picasso.with(context)
                .load("http://i.imgur.com/DvpvklR.png")
                .into(movieViewHolder.mMovieImageView);
//        movieViewHolder.itemView.setBackground();

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    class MovieViewHolder extends RecyclerView.ViewHolder{
        public ImageView mMovieImageView;

        public MovieViewHolder(View view){
            super(view);
            mMovieImageView = (ImageView) view.findViewById(R.id.img_movie_picture);

        }


    }
}
