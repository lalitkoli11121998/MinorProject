package com.example.dell.minorproject;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    ArrayList<UserData>userDatalist = new ArrayList<>();
    UsersRecyclerAdapter usersRecyclerAdapter;
    RecyclerView recyclerView;
    Fragment1 fragment1 = new Fragment1();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Normal:

                    Toast.makeText(MainActivity.this,"Normal", Toast.LENGTH_LONG).show();
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager1.beginTransaction();
                    transaction.replace(R.id.container,fragment1).commit();
                    return true;
                case R.id.Emergency:
                    Toast.makeText(MainActivity.this,"Emergency", Toast.LENGTH_LONG).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager1.beginTransaction();
        transaction.replace(R.id.container, fragment1).commit();
    }

}
