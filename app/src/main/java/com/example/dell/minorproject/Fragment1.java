package com.example.dell.minorproject;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by dell on 2/19/2019.
 */

public class Fragment1 extends android.support.v4.app.Fragment {
    UsersRecyclerAdapter usersRecyclerAdapter;

    RecyclerView recyclerView;
    ArrayList<UserData> arrayList = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_main2, container, false);

        recyclerView = view.findViewById(R.id.recycle1);
           fetchDataFromDataBase();
        return view;


    }

    private void fetchDataFromDataBase() {
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        CollectionReference coffeeRef = rootRef.collection("photo");
        coffeeRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        Toast.makeText(getContext(), document.getId().toString(), Toast.LENGTH_SHORT).show();
                        UserData userData = document.toObject(UserData.class);
                        arrayList.add(userData);
                    }
                    usersRecyclerAdapter = new UsersRecyclerAdapter(getContext(), arrayList, new UsersRecyclerAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    });
                    Log.d("newfind3", String.valueOf(arrayList.size()));
                    recyclerView.setAdapter(usersRecyclerAdapter);
                    usersRecyclerAdapter.notifyDataSetChanged();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));


                } else {
                    Toast.makeText(getContext(), "Not Succesfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
