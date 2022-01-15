package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Info extends AppCompatActivity {

    private   int fav=0;//variable pour savoir si le film est dans les favorie

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        int lg = ((MyApplication) this.getApplication()).getLg();//recuperation de la date
        Movie movie= (Movie) getIntent().getSerializableExtra("movie");//recuperation du film envoier de la page
        ImageView imageView = (ImageView)findViewById(R.id.fond) ;
        Button button=(Button) findViewById(R.id.fav);
        Glide.with(imageView.getContext()).load("https://image.tmdb.org/t/p/w500//"+movie.getBackdrop_path()).into(imageView);//affichage de l'image du film par internet
        TextView des = (TextView) findViewById(R.id.des);
        des.setText(movie.getOverview());
        TextView date =(TextView) findViewById(R.id.date);
        date.setText("date : "+movie.getRelease_date());
        String g="genre: ";
        TextView genre=(TextView) findViewById(R.id.genre);
      for(int i=0;i<movie.getGenre_ids().size();i++){//switch pour transformer le genre de int en nom
          switch (movie.getGenre_ids().get(i)){
              case 28:
                  g=g+" Action";
                  break;
              case 12:
                  g=g+" Aventure";
                  break;
              case 16:
                  g=g+" Animation";
                  break;
              case 35:
                  g=g+" Comedy";
                  break;
              case 80:
                  g=g+" Documentary";
                  break;
              case 99:
                  g=g+" Drama";
                  break;
              case 18:
                  g=g+" Family";
                  break;
              case 10751:
                  g=g+" Family";
                  break;
              case 14:
                  g=g+" Fantasy";
                  break;
              case 27:
                  g=g+" Horror";
                  break;
              case 9648:
                  g=g+" Music";
                  break;
              case 10749:
                  g=g+" Romance";
                  break;
              case 878:
                  g=g+" Science Fiction";
                  break;
              case 10770:
                  g=g+" TV Movie";
                  break;
              case 53:
                  g=g+" Thriller";
                  break;
              case 10752:
                  g=g+" War";
                  break;
              case 37:
                  g=g+" Western";
                  break;

          }
      }
        genre.setText(g);

        if(lg==0){
            button.setText("add to favorites");
        }

      SharedPreferences mPrefs = getApplicationContext().getSharedPreferences("favor", 0);//recuperation des favorie
      ListMovie listMovie = new ListMovie();//


        if (mPrefs.getInt("size", 0) == 0) {


        } else {

            Gson gson = new Gson();
            String json = mPrefs.getString("list", "ttt");
            listMovie = gson.fromJson(json,ListMovie.class);
            for(int i=0;i<listMovie.getResults().size();i++){//on verifie que le favorie est dans la base
                if(listMovie.getResults().get(i).getId()==movie.getId()){
                    if(lg==0){
                        button.setText("remove to favorites");
                    }else{
                    button.setText("supprimer favorie");}
                    fav=1;
                }
            }

        }



        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              SharedPreferences mPrefs = getApplicationContext().getSharedPreferences("favor", 0);
              SharedPreferences.Editor prefsEditor = mPrefs.edit();
              ListMovie listMovie = new ListMovie();
              if(fav ==0){//ajout d'un favorie
                  if (mPrefs.getInt("size", 0) != 0) {//cas ou la list de favorie n'existe pas
                      Gson gson = new Gson();
                      String json = mPrefs.getString("list", "");
                      listMovie = gson.fromJson(json,ListMovie.class);
                      listMovie.getResults().add(movie);
                      gson = new Gson();
                      json = gson.toJson(listMovie);
                      prefsEditor.putString("list", json);
                      prefsEditor.apply();
                  } else {//cas ou la list de favorie existe
                      ArrayList<Movie> str = new ArrayList<Movie>();
                      str.add(movie);
                      listMovie.setResults(str);
                      Gson gson = new Gson();
                      String json = gson.toJson(listMovie);
                      prefsEditor.putInt("size",1);
                      prefsEditor.putString("list", json);
                      prefsEditor.apply();
                  }
                  if(lg==0){
                      button.setText("remove to favorites");
                  }else{
                  button.setText("supprimer favori");}
                  fav=1;

              }else{//supression des favorie
                    int indice=0;
                  Gson gson = new Gson();
                  String json = mPrefs.getString("list", "");
                  listMovie = gson.fromJson(json,ListMovie.class);
                  for(int i=0;i<listMovie.getResults().size();i++){
                      if(listMovie.getResults().get(i).getId()==movie.getId()){
                          indice=i;//recuperation de la position du film dans la liste
                      }
                  }

                  listMovie.getResults().remove(indice);
                  gson = new Gson();
                  json = gson.toJson(listMovie);
                  prefsEditor.putString("list", json);
                  prefsEditor.apply();
                  if(lg==0){
                      button.setText("add to favorites");
                  }else{

                  button.setText("ajouter favori");}
                  fav=0;
              }

          }
      });

    }
}