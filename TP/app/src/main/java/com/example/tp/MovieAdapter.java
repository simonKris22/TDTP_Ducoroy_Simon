package com.example.tp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private final List<Movie> mMovie;


    public MovieAdapter(List<Movie> mMovie) {
        this.mMovie=mMovie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie=mMovie.get(position);


        ImageView imageView = holder.image;
        Glide.with(imageView.getContext()).load("https://image.tmdb.org/t/p/w500//"+movie.getPoster_path()).into(imageView);



    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{


        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image=(ImageView) itemView.findViewById(R.id.image);
        }


    }
}
