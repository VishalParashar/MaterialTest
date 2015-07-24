package com.nimish.nimish.materialtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetialedRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detialed_recipe);

        TextView title = (TextView) findViewById(R.id.title);
        TextView category = (TextView) findViewById(R.id.category);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView duration = (TextView) findViewById(R.id.duration);

        title.setText("Title " + getIntent().getStringExtra("title"));
        category.setText("Category " + getIntent().getStringExtra("category"));
        rating.setText("Rating " + getIntent().getStringExtra("rating"));
        duration.setText("Duration " + getIntent().getStringExtra("duration"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detialed_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
