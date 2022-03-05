package com.example.khabbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khabbar.Models.NewsHeadline;
import com.squareup.picasso.Picasso;

import java.util.List;

public class customadapter extends RecyclerView.Adapter<custom_viewholder> {
    private Context context;
    private List<NewsHeadline> headlines;
    private SelectListener listener;


    public customadapter(Context context, List<NewsHeadline> headlines,SelectListener listener) {
        this.context = context;
     this.listener=listener;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public custom_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new custom_viewholder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull custom_viewholder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        listener.onNewsClicked(headlines.get(position));
    }
});
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
