package com.example.td5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final List<Contact> mcontact;


    public ContactAdapter(List<Contact> mcontact) {
        this.mcontact = mcontact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mcontact.get(position);
        //on place les different element de du contact dans le xml
        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getPrenom());

        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getNom());

        ImageView imageView = holder.image;
        Glide.with(imageView.getContext()).load(contact.getImg()).into(imageView);


    }

    @Override
    public int getItemCount() {
        return mcontact.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //on créer les different element de l'item et on les relie au xml

        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTextView=(TextView) itemView.findViewById(R.id.prenom);
            lastNameTextView=(TextView) itemView.findViewById(R.id.nom);
            image=(ImageView) itemView.findViewById(R.id.image);
        }


    }

}
