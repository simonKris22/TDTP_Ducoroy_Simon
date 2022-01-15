package com.example.tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int lg = ((MyApplication) this.getApplication()).getLg();

        String rec=getIntent().getStringExtra("film");
        Intent intent=new Intent(this,Info.class);
        Intent intent1=new Intent(this,Recherche.class);
        Intent intent2=new Intent(this,Populaire.class);
        Intent intent3=new Intent(this,Recent.class);
        Intent intent4=new Intent(this,Favorie.class);

        Button recent=(Button)findViewById(R.id.recent);
        Button rech=(Button)findViewById(R.id.rech);
        Button fav=(Button)findViewById(R.id.fav);
        Button pop=(Button)findViewById(R.id.pop);

        if(lg==0){
            rech.setText("scearch");
            pop.setText("popular");
        }


        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });

        theMoviesDB theMoviesDB= new Retrofit.Builder()
                .baseUrl(com.example.tp.theMoviesDB.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(theMoviesDB.class);


        if(lg==1){
            theMoviesDB.sceach(rec).enqueue(new Callback<MovieDb>() {
                @Override
                public void onResponse(Call<MovieDb> call, Response<MovieDb> response) {
                    ArrayList<Movie> movies;
                    movies = (ArrayList<Movie>) response.body().getResults();
                    RecyclerView rvMovie = (RecyclerView) findViewById(R.id.rvMovie);
                    MovieAdapter movieAdapter = new MovieAdapter(movies);
                    rvMovie.setAdapter(movieAdapter);
                    rvMovie.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    rvMovie.addOnItemTouchListener(
                            new RecyclerItemClickListener(getApplicationContext(), rvMovie, new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    intent.putExtra("movie", movies.get(position));
                                    startActivity(intent);
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }
                            })
                    );
                }

                @Override
                public void onFailure(Call<MovieDb> call, Throwable t) {
                    startActivity(intent1);

                }
            });
        }else{
            theMoviesDB.sceachEN(rec).enqueue(new Callback<MovieDb>() {
                @Override
                public void onResponse(Call<MovieDb> call, Response<MovieDb> response) {
                    ArrayList<Movie> movies;
                    movies = (ArrayList<Movie>) response.body().getResults();
                    RecyclerView rvMovie = (RecyclerView) findViewById(R.id.rvMovie);
                    MovieAdapter movieAdapter = new MovieAdapter(movies);
                    rvMovie.setAdapter(movieAdapter);
                    rvMovie.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    rvMovie.addOnItemTouchListener(
                            new RecyclerItemClickListener(getApplicationContext(), rvMovie, new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    intent.putExtra("movie", movies.get(position));
                                    startActivity(intent);
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }
                            })
                    );
                }

                @Override
                public void onFailure(Call<MovieDb> call, Throwable t) {
                    startActivity(intent1);

                }
            });
        }



    }
}