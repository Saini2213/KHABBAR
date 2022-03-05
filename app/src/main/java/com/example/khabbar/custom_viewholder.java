package com.example.khabbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class custom_viewholder extends RecyclerView.ViewHolder {
    TextView text_title,text_source;
    ImageView img_headline;
    CardView cardView;
    public custom_viewholder(@NonNull View itemView) {
        super(itemView);
        text_title=itemView.findViewById(R.id.text_tittle);
        text_source=itemView.findViewById(R.id.text_source);
        img_headline=itemView.findViewById(R.id.img_headline);

        cardView=itemView.findViewById(R.id.cardview_main);

    }
}
