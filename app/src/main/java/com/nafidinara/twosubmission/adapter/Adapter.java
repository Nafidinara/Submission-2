package com.nafidinara.twosubmission.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nafidinara.twosubmission.Items;
import com.nafidinara.twosubmission.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Items> list;
    private OnItemClickListener mListener;

    public Adapter(Context context, ArrayList<Items> list) {
        this.list = list;
        this.context = context;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_items;
        public TextView title_items;
        public TextView release_items;
        public TextView genre_items;

        public CategoryViewHolder(@NonNull View view) {
            super(view);

            img_items = view.findViewById(R.id.img_items);
            title_items = view.findViewById(R.id.txt_title_title);
            release_items = view.findViewById(R.id.txt_release_items);
            genre_items = view.findViewById(R.id.txt_genre_items);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position){
        Items items = list.get(position);

        Glide.with(holder.img_items).load(items.getImage()).into(holder.img_items);

        holder.title_items.setText(items.getTitle());

        holder.release_items.setText(items.getRelease());

        holder.genre_items.setText(items.getGenre());
    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
