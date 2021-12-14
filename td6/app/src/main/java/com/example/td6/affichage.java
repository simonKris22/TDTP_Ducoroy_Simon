package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class affichage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        Intent intent =getIntent();
        ArrayList<Repo> test = (ArrayList<Repo>) getIntent().getExtras().getSerializable("test");

        RecyclerView rvContact =(RecyclerView) findViewById(R.id.rvContacts);


        RepoAdapter repoAdapter =new RepoAdapter(test);
        rvContact.setAdapter(repoAdapter);
        rvContact.setLayoutManager(new LinearLayoutManager(this));

    }
}