package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        String url = "https://news.google.com/";

        Button logout = (Button) findViewById(R.id.logout);
        Button detail = (Button) findViewById(R.id.detail);
        Button google = (Button) findViewById(R.id.google);

        TextView tv = (TextView) findViewById(R.id.nom);

        Intent intent0 =getIntent();
        Intent intent = new Intent(this,LoginActivity.class);
        Intent intent2 = new Intent(this,DetailsActivity.class);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        NewsListApplication app = (NewsListApplication) getApplicationContext();
        if(intent0.hasExtra("nom")){
            String nom=intent0.getStringExtra("nom");
            tv.setText(nom);
           app.setLogin(nom);

        }else{
            tv.setText(app.getLogin());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });
    }
}