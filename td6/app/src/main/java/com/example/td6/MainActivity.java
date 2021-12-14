package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        EditText editText=(EditText) findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                githubService.listRepos(editText.getText().toString()).enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        afficherRepos(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });

            }
        });
    }

    public void afficherRepos(List<Repo> repos) {
        ArrayList<Repo> repos1;
        repos1= (ArrayList<Repo>) repos;
        Intent intent = new Intent(this,affichage.class);
        intent.putExtra("test",repos1);

        startActivity(intent);

    }

}