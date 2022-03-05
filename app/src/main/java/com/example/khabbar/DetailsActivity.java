package com.example.khabbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khabbar.Models.NewsHeadline;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadline headline;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txt_author=findViewById(R.id.text_Detail_author);
        txt_time=findViewById(R.id.text_Detail_time);
        txt_detail=findViewById(R.id.text_Details_details);
        txt_content=findViewById(R.id.text_Detail_content);
        txt_title=findViewById(R.id.text_Deatil_title);
        img_news=findViewById(R.id.img_Detail_News);
        headline= (NewsHeadline) getIntent().getSerializableExtra("data");
      txt_title.setText(headline.getTitle());
      txt_author.setText(headline.getAuthor());
      txt_detail.setText(headline.getDescription());
      txt_time.setText(headline.getPublishedAt());
      txt_content.setText(headline.getContent());
        Picasso.get().load(headline.getUrlToImage()).into(img_news);
    }
}