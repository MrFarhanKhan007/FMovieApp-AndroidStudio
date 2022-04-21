package com.example.movieapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.movieapp.R;
import com.example.movieapp.adapter.RecyclerViewAdapter;
import com.example.movieapp.model.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_Url="https://starter-pi-cyan.vercel.app/api";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<DataModel>lstmovies;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstmovies= new ArrayList<>();

        recyclerView= findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request= new JsonArrayRequest(JSON_Url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0;i< response.length();i++){
                    try {
                        jsonObject= response.getJSONObject(i);
                        DataModel movie= new DataModel();
                        movie.setName(jsonObject.getString("name"));
                        movie.setRating(jsonObject.getString("rating"));
                        movie.setCategories(jsonObject.getString("category"));
                        movie.setDirector(jsonObject.getString("director"));
                        movie.setStoryline(jsonObject.getString("storyline"));
                        movie.setRuntime(jsonObject.getString("runtime"));
                        movie.setImg(jsonObject.getString("img"));

                        lstmovies.add(movie);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstmovies);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<DataModel> lstmovies) {
        RecyclerViewAdapter myadapter= new RecyclerViewAdapter(this,lstmovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}