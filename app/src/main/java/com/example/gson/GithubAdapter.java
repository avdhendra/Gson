package com.example.gson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.MyViewHolder> {
    ArrayList<GithubUser>githubUsers;
    Context context;
    GithubAdapter(ArrayList<GithubUser>githubUsers,Context context){
        this.githubUsers=githubUsers;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.t1.setText(githubUsers.get(position).getLogin());
        holder.t2.setText(githubUsers.get(position).getHtml_url());
        holder.t3.setText(githubUsers.get(position).getAvatar_url());
        holder.t4.setText(githubUsers.get(position).getScore());
        holder.t5.setText(githubUsers.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        t1=itemView.findViewById(R.id.tViewLogin);
        t2=itemView.findViewById(R.id.tviewUrl);
        t3=itemView.findViewById(R.id.tviewid);
        t4=itemView.findViewById(R.id.tviewscore);
        t5=itemView.findViewById(R.id.tviewavatar);

        }
    }
}
