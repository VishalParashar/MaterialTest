package com.nimish.nimish.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Ingredient extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        ItemData itemsData[] = { new ItemData("Plant Origin"),
                new ItemData("Animal Origin"),
              };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter mAdapter = new MyAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);
    }

    public void printTitle(View v) {
        TextView tv = (TextView) v;
        String title = tv.getText().toString();
        Intent in = new Intent(this,Ingredient2.class);
        in.putExtra("ingredient",title);
        startActivity(in);
    }
}