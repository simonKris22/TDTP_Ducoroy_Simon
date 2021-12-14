package com.example.td5;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    List<Contact> contacts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RecyclerView rvContact =(RecyclerView) findViewById(R.id.rvContacts);
        //on ajoute touts les contact qu'on veut afficher dans la list contacts
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("jeanne","au secours","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));



        ContactAdapter adapter =new ContactAdapter(contacts);//on passe la liste dans l'adapter
        rvContact.setAdapter(adapter);//on passe l'adapter dans la recicler view
        rvContact.setLayoutManager(new LinearLayoutManager(this));//on créer un linearlayout dans la recicler view pour afficher les element

    }
}