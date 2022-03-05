package com.example.khabbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.khabbar.Models.NewsApiResponse;
import com.example.khabbar.Models.NewsHeadline;

import java.util.List;

public class  MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {
RecyclerView recyclerView;
LinearLayout linearLayout;
customadapter adapter;
ProgressDialog progressDialog;
Button b1,b2,b3,b4,b5,b6,b7;
SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Fetching news article....");
        progressDialog.show();
        searchView=findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching news articles...." + query);
                progressDialog.show();

                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              return false;
            }
        });
        b1=findViewById(R.id.button_1);
        b1.setOnClickListener(this);

        b2=findViewById(R.id.button_2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.button_3);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.button_4);
        b4.setOnClickListener(this);
        b5=findViewById(R.id.button_5);
        b5.setOnClickListener(this);
        b6=findViewById(R.id.button_6);
        b6.setOnClickListener(this);
        b7=findViewById(R.id.button_7);
        b7.setOnClickListener(this);
        RequestManager manager=new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);
    }
    private final onFetchDataListener<NewsApiResponse> listener=new onFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadline> list, String message) {
            if (list.isEmpty()) {
                Toast.makeText(MainActivity.this, "No data found!!!!", Toast.LENGTH_SHORT).show();
            } else {
                showNews(list);
                progressDialog.dismiss();
            }
        }
        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this,"Error occured",Toast.LENGTH_SHORT).show();

        }
    };
    private void showNews(List<NewsHeadline> list){
    recyclerView=findViewById(R.id.Reclyerview);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    adapter=new customadapter(this,list,this);
    recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNewsClicked(NewsHeadline headline) {
        startActivity(new Intent(MainActivity.this,DetailsActivity.class)
        .putExtra("data",headline));

    }

    @Override
    public void onClick(View v) {
        Button button=(Button) v;
        String category=button.getText().toString();
        progressDialog.setTitle("Fetching news article of " + category);
        progressDialog.show();
        RequestManager manager=new RequestManager(this);
        manager.getNewsHeadlines(listener,category,null);
    }
}