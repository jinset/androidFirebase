package com.jinsoft.firebasetestingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jinsoft.firebasetestingapp.Objects.Adapter;
import com.jinsoft.firebasetestingapp.Objects.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPage extends AppCompatActivity {


    RecyclerView rv;

    List<User> users;

    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rv = findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));

        users = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapter = new Adapter(users);

        rv.setAdapter(adapter);

        database.getReference().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.removeAll(users);
                for (DataSnapshot snap:
                        dataSnapshot.getChildren()) {
                    User user = snap.getValue(User.class);
                    users.add(user);
                    
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
