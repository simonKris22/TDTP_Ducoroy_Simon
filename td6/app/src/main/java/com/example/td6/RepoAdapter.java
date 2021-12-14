package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private final List<Repo> mRepo;


    public RepoAdapter(List<Repo> mRepo) {
        this.mRepo = mRepo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_repo, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Repo repo=mRepo.get(position);

        TextView idTextView = holder.idTextView;
        idTextView.setText(String.valueOf(repo.getId()));

        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(repo.getName());

        TextView fullNameTextView = holder.fullNameTextView;
        fullNameTextView.setText(repo.getFull_name());

        TextView urlTextView = holder.urlTextView;
        urlTextView.setText(repo.getHtml_url());

    }

    @Override
    public int getItemCount() {
        return mRepo.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView idTextView;
        public TextView nameTextView;
        public TextView fullNameTextView;
        public TextView urlTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTextView=(TextView) itemView.findViewById(R.id.id);
            nameTextView=(TextView) itemView.findViewById(R.id.name);
            fullNameTextView=(TextView) itemView.findViewById(R.id.fullname);
            urlTextView=(TextView) itemView.findViewById(R.id.url);

        }


    }

}
