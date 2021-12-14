package com.example.td5;

import android.content.Context;

public class Contact {
    private String nom;
    private String prenom;
    private String img;

    public Contact(String nom,String prenom,String img){
        this.img=img;
        this.prenom=prenom;
        this.nom=nom;

    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String  getImg() {
        return img;
    }
}
