package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favorie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorie);
        Intent intent=new Intent(this,Info.class);
        RecyclerView rvMovie =(RecyclerView) findViewById(R.id.favo);
        SharedPreferences mPrefs = getApplicationContext().getSharedPreferences("favor", 0);;
        ListMovie listMovie;
        int lg = ((MyApplication) this.getApplication()).getLg();

        Button pop=(Button)findViewById(R.id.pop);
        Button recent=(Button)findViewById(R.id.recent);
        Button rech=(Button)findViewById(R.id.rech);

        if(lg==0){
            rech.setText("search");
            pop.setText("popular");
        }
        Intent intent1=new Intent(this,Recent.class);
        Intent intent2=new Intent(this,Recherche.class);
        Intent intent3=new Intent(this,Populaire.class);



        recent.setOnClickListener(new View.OnClickListener() {
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

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        if (mPrefs.getInt("size", 0) == 0) {
            if(lg==0){
                Toast.makeText(getApplicationContext(), "no favorite", Toast.LENGTH_LONG).show();
            }
            else{

            Toast.makeText(getApplicationContext(), "pas de favori", Toast.LENGTH_LONG).show();}
        } else {

            Gson gson = new Gson();
            String json = mPrefs.getString("list", "ttt");
            listMovie = gson.fromJson(json,ListMovie.class);
            ArrayList<Movie> movies = (ArrayList<Movie>)listMovie.getResults();
            if(movies.size()==0){
                if(lg==0){
                    Toast.makeText(getApplicationContext(), "no favorite", Toast.LENGTH_LONG).show();
                }
                else{
                Toast.makeText(getApplicationContext(), "pas de favori", Toast.LENGTH_LONG).show();}
            }

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




    }
}