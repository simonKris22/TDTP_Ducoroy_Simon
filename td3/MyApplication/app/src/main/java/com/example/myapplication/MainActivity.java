package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.button);
        TextView tv1 = (TextView)findViewById(R.id.textView1);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        EditText et1=(EditText) findViewById(R.id.editText);
        Random random = new Random();//on crée un element ramdom




        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String e= et1.getText().toString();//on recuper la valeur du editText en string
                boolean digitsOnly = TextUtils.isDigitsOnly(e);//on test si la valeur de l'editText est un nombre
          if(digitsOnly && !e.isEmpty()){//on test la valeur du boolean qui verifie editText et si l'editText est nul
              int k= Integer.parseInt(e);//on passe le string en integer

              int nb = random.nextInt(k);
              int nb2 = random.nextInt(k);
              tv1.setText(String.valueOf(nb+1));//on affiche la valeur de nb avec +1 pour avoir une plage de valeur de 1 a nb
              tv2.setText(String.valueOf(nb2+1));//on affiche la valeur de nb2 avec +1 pour avoir une plage de valeur de 1 a nb
          }
          else{//message si l'editText ne convient pas
              Toast toast = Toast.makeText(MainActivity.this, "rentre un chiffre stp", Toast.LENGTH_SHORT);
              toast.show();
          }

            }
        });
    }
}