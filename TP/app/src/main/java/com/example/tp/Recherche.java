package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Recherche extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        EditText editText =(EditText) findViewById(R.id.film);
        Button button=(Button) findViewById(R.id.val);
        Intent intent=new Intent(this,Result.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//recuperation du text de la recherche

                String s= editText.getText().toString();
                if(s.isEmpty() || s==" "){
                    Toast.makeText(getApplicationContext(),"erreur",Toast.LENGTH_SHORT).show();
                }
                else {
                intent.putExtra("film",s);
                startActivity(intent);}


            }
        });

    }
}