package com.jinsoft.firebasetestingapp.Objects;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinsoft.firebasetestingapp.R;

import java.util.List;

/**
 * Created by desa-tecno007 on 2/2/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.UsersPageHolder> {

    List<User> users;

    public Adapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UsersPageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler,parent,false);
        UsersPageHolder holder = new UsersPageHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(UsersPageHolder holder, int position) {
        User user = users.get(position);
        holder.textViewUser.setText(user.getUser());
        holder.textViewName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UsersPageHolder extends RecyclerView.ViewHolder{

        TextView textViewUser, textViewName;

        public UsersPageHolder(View itemView) {
            super(itemView);
            textViewUser = itemView.findViewById(R.id.textViewUser);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }

}

