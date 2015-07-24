package com.nimish.nimish.materialtest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class Ingredient2 extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);

        String title = getIntent().getStringExtra("ingredient");
        ItemData itemsData[] = getData(title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter mAdapter = new MyAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);

    }

    public ItemData[] getData(String title){
        List<ItemData> itemsDataList = new ArrayList<>();
        ItemData[] itemData = null;
        switch(title){
            case "Plant Origin":
                itemsDataList.add(new ItemData("Cereal grains/ Legums"));
                itemsDataList.add(new ItemData("Fruits"));

                itemData = itemsDataList.toArray(new ItemData[itemsDataList.size()]);

                break;
            case "Animal Origin":
                itemsDataList.add(new ItemData("Egg"));
                itemsDataList.add(new ItemData("Chicken"));

                itemData = itemsDataList.toArray(new ItemData[itemsDataList.size()]);
                break;
        }
        return itemData;
    }

    public void printTitle(View v){
        Intent in = new Intent(this,AddRecipe.class);
        in.putExtra("result", "Fruits");
    }

}
