package com.example.tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//tp de Simon Kristofer et Ducoroy Paul
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,Populaire.class);

        Button button=(Button) findViewById(R.id.valider);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        ((MyApplication) this.getApplication()).setLg(1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButton);
                if(idx==1){
                    ((MyApplication) getApplication()).setLg(1);//Variable globale pour la langue 1 si francais
                }
                else{
                    ((MyApplication) getApplication()).setLg(0);//Variable globale pour la langue 0 si  anglais
                }


             startActivity(intent);//envois a la page populaire
            }
        });
    }


}

