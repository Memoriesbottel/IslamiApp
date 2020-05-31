package com.example.monicaashraf.islamiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.example.monicaashraf.islamiapp.adapter.sourasRecyclerAdapter;

public class SurasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    sourasRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras);
        recyclerView=findViewById(R.id.rec);
        adapter=new sourasRecyclerAdapter(constant.ArSuras);

        adapter.setItemOnClickListener(new sourasRecyclerAdapter.itemOnClickListener() {
            @Override
            public void OnItemClick(int position, String name) {
                //n handel el action , n start el activity el bt3rd el saura details
                Toast.makeText(SurasActivity.this, position + " " + name, Toast.LENGTH_SHORT);
            }
        });


        layoutManager=new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        SnapHelper helper=new PagerSnapHelper();
        helper.attachToRecyclerView(recyclerView);
    }
}
