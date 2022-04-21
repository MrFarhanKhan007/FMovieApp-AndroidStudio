package com.example.movieapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapp.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

//        hide default action bar
        getSupportActionBar().hide();

//        Receive data from RecyclerViewAdapter.java
        String name= getIntent().getExtras().getString("movie_name");
        String storyline= getIntent().getExtras().getString("movie_storyline");
        String director= getIntent().getExtras().getString("movie_director");
        String category= getIntent().getExtras().getString("movie_category");
        String runtime= getIntent().getExtras().getString("movie_runtime");
        String image= getIntent().getExtras().getString("movie_image");
        String rating= getIntent().getExtras().getString("movie_rating");

//        Initial Collapse View
        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

//        define view by findviewid
        TextView movie_name=findViewById(R.id.m_movie_name);
        TextView movie_director=findViewById(R.id.m_director);
        TextView movie_cateogory=findViewById(R.id.m_category);
        TextView movie_storyline=findViewById(R.id.m_description);
        TextView movie_rating=findViewById(R.id.m_rating);
        ImageView img= findViewById(R.id.m_thumbnail);

//        Setting value to each view

        movie_name.setText(name);
        movie_cateogory.setText(category);
        movie_storyline.setText(storyline);
        movie_rating.setText(rating);
        movie_director.setText(director);

//        Set movie title in Collapsing toolbar
        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions=new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

//        Set image using Glide Library
        Glide.with(this).load(image).apply(requestOptions).into(img);
    }
}