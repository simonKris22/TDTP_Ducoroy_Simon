package com.example.tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
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

public class Recent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        Intent intent=new Intent(this,Info.class);
        Intent intent2=new Intent(this,Recherche.class);
        Intent intent1=new Intent(this,Populaire.class);
        Intent intent3=new Intent(this,Favorie.class);
        int lg = ((MyApplication) this.getApplication()).getLg();

        Button pop=(Button)findViewById(R.id.pop);
        Button rech=(Button)findViewById(R.id.rech);
        Button fav=(Button)findViewById(R.id.fav);

        if(lg==0){
            rech.setText("search");
            pop.setText("popular");
        }

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });
        theMoviesDB theMoviesDB= new Retrofit.Builder()
                .baseUrl(com.example.tp.theMoviesDB.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(theMoviesDB.class);


        if(lg==1){
            theMoviesDB.listUpcoming().enqueue(new Callback<MovieDb>() {
                @Override
                public void onResponse(Call<MovieDb> call, Response<MovieDb> response) {
                    ArrayList<Movie> movies;
                    movies=(ArrayList<Movie>) response.body().getResults();
                    RecyclerView rvMovie =(RecyclerView) findViewById(R.id.rvUp);
                    MovieAdapter movieAdapter=new MovieAdapter(movies);
                    rvMovie.setAdapter(movieAdapter);
                    rvMovie.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    rvMovie.addOnItemTouchListener(
                            new RecyclerItemClickListener(getApplicationContext(), rvMovie ,new RecyclerItemClickListener.OnItemClickListener() {
                                @Override public void onItemClick(View view, int position) {
                                    intent.putExtra("movie",movies.get(position));
                                    startActivity(intent);
                                }

                                @Override public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }
                            })
                    );
                }
                public void onFailure(Call<MovieDb> call, Throwable t) {
                    t.getCause();
                }
            });


        }
        else{
            theMoviesDB.listUpcomingEN().enqueue(new Callback<MovieDb>() {
                @Override
                public void onResponse(Call<MovieDb> call, Response<MovieDb> response) {
                    ArrayList<Movie> movies;
                    movies=(ArrayList<Movie>) response.body().getResults();
                    RecyclerView rvMovie =(RecyclerView) findViewById(R.id.rvUp);
                    MovieAdapter movieAdapter=new MovieAdapter(movies);
                    rvMovie.setAdapter(movieAdapter);
                    rvMovie.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    rvMovie.addOnItemTouchListener(
                            new RecyclerItemClickListener(getApplicationContext(), rvMovie ,new RecyclerItemClickListener.OnItemClickListener() {
                                @Override public void onItemClick(View view, int position) {
                                    intent.putExtra("movie",movies.get(position));
                                    startActivity(intent);
                                }

                                @Override public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }
                            })
                    );
                }
                public void onFailure(Call<MovieDb> call, Throwable t) {
                    t.getCause();
                }
            });


        }




    }


}

