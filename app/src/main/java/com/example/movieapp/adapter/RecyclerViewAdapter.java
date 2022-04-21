package com.example.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapp.R;
import com.example.movieapp.activities.MovieActivity;
import com.example.movieapp.model.DataModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewholder > {
RequestOptions options;
    private Context mContext;
    private List<DataModel> mData;

    public RecyclerViewAdapter(Context mContext, List<DataModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        options=new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }
    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater inflater= LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.movie_row_item,parent,false);
        MyViewholder viewholder= new MyViewholder(view);

        viewholder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(mContext, MovieActivity.class);
                i.putExtra("movie_name",mData.get(viewholder.getAdapterPosition()).getName());
                i.putExtra("movie_storyline",mData.get(viewholder.getAdapterPosition()).getStoryline());
                i.putExtra("movie_director",mData.get(viewholder.getAdapterPosition()).getDirector());
                i.putExtra("movie_category",mData.get(viewholder.getAdapterPosition()).getCategories());
                i.putExtra("movie_runtime",mData.get(viewholder.getAdapterPosition()).getRuntime());
                i.putExtra("movie_image",mData.get(viewholder.getAdapterPosition()).getImg());
                i.putExtra("movie_rating",mData.get(viewholder.getAdapterPosition()).getRating());

                mContext.startActivity(i);
            }
        });

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_director.setText(mData.get(position).getDirector());
        holder.tv_category.setText(mData.get(position).getCategories());

        Glide.with(mContext).load(mData.get(position).getImg()).apply(options).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_director;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewholder(@NonNull View itemView){
            super(itemView);
            tv_name=itemView.findViewById(R.id.movie_name);
            tv_category=itemView.findViewById(R.id.category);
            tv_rating=itemView.findViewById(R.id.rating);
            tv_director=itemView.findViewById(R.id.director);
            img_thumbnail=itemView.findViewById(R.id.thumbnail);
            view_container=itemView.findViewById(R.id.container);
        }
    }
}