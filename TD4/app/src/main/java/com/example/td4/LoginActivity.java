package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        Button login = (Button) findViewById(R.id.login);
        Intent intent = new Intent(this,NewsActivity.class);
        EditText et1=(EditText) findViewById(R.id.nom);

        login.setOnClickListener(new View.OnClickListener() {//ca se declenche lors d'un clique
            @Override
            public void onClick(View view) {
                String nom =et1.getText().toString();//on recuper le contenue de l'edit text
                intent.putExtra("nom",nom);
                startActivity(intent);//on vas sur la page NewsActivity avec la variable nom
                finish();
            }


        });
    }
}