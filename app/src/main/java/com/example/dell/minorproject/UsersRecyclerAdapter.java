package com.example.dell.minorproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ralph on 18/03/18.
 */

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {
    interface OnItemClickListener {

        void onItemClick(int position);
    }
    TextView t;
    ArrayList<UserData> users=new ArrayList<>();
    Context context;
    UsersRecyclerAdapter.OnItemClickListener listener;
    String name,art,img,rem,sym,yout;

    public UsersRecyclerAdapter(Context context, ArrayList<UserData> users, UsersRecyclerAdapter.OnItemClickListener listener){
        this.users = users;
        this.context = context;
        this.listener = listener;
    }
//#5aa184
    @Override
    public UsersRecyclerAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.dmo2,parent,false);
        UsersRecyclerAdapter.UserViewHolder holder = new UsersRecyclerAdapter.UserViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final UsersRecyclerAdapter.UserViewHolder holder, final int position) {
       // Toast.makeText(context,users.get(position).getDisease(),Toast.LENGTH_SHORT).show();
        Log.d("findit", users.get(position).getDisease());
        final Uri uri = Uri.parse(users.get(position).getImageurl());
        Picasso.get().load(uri).fit().into(holder.imageView);
        holder.txt.setText(users.get(position).getDisease());
        Toast.makeText(context,users.get(position).getRemedies(),Toast.LENGTH_SHORT).show();
        holder.youtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse(users.get(position).getYoutube() ) );
                context.startActivity(browse);
            }
        });
        holder.art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse(users.get(position).getArticle() ) );
                context.startActivity(browse);
            }
        });
        holder.rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog mydialog = new Dialog(context);
                mydialog = new Dialog(context);
                mydialog.setContentView(R.layout.showremedies);

                t = (TextView) mydialog.findViewById(R.id.showtext);
                t.setText(users.get(position).getRemedies());
                t.setEnabled(true);
                mydialog.show();
            }
        });
        holder.sym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Dialog mydialog = new Dialog(context);
                    mydialog = new Dialog(context);
                    mydialog.setContentView(R.layout.showremedies);

                    t = (TextView) mydialog.findViewById(R.id.showtext);
                    t.setText(users.get(position).getSymptoms());
                    t.setEnabled(true);
                    mydialog.show();

            }
        });
       // Glide.with(context.getApplicationContext()).load(uri).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return  users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageButton youtb, art,sym,rem;
        TextView txt;


        public UserViewHolder(View itemView) {
            super(itemView);
         imageView = itemView.findViewById(R.id.diseaseimage);
         youtb = itemView.findViewById(R.id.youtubebutton);
         art = itemView.findViewById(R.id.article);
         sym= itemView.findViewById(R.id.symtomsbutton);
         rem = itemView.findViewById(R.id.remediesbutton);
         txt = itemView.findViewById(R.id.diseasetext);
             }
    }
}
