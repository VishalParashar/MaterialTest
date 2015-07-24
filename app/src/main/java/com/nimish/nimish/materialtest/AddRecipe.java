package com.nimish.nimish.materialtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class AddRecipe extends Activity {
    private static int REQUEST_CODE = 1;
    private static int editTextCount = 0;
    private static int imageCount = 0;
    private Spinner recipeCategoryAdd;
    private Bitmap[] bitmap = new Bitmap[8];
    private ImageView[] image = new ImageView[8];
    private EditText[] editText = new EditText[10];
    private HorizontalScrollView hsv;
    private LinearLayout horizontalScrollLinearLayout;
    private LinearLayout horizontalScrollLinearLayoutContainer;
    String[] spinnerValues = {"High Protein", "Low Carbs", "Spicy", "Low Fat", "Sweet"};
    String[] spinnerSubs = {"Proteins help in muscle building", "For those who are on diet", "Indian Special", "Who wants fat ?", "Desert Time"};
    int total_images[] = {R.drawable.ic_high_protein, R.drawable.ic_low_carb, R.drawable.ic_spicy, R.drawable.ic_low_fat, R.drawable.ic_sweet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        init();

        EditText ingredient_1 = (EditText) findViewById(R.id.ingredient_1);
        ingredient_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Ingredient.class);
                startActivity(in);
            }
        });
        /*  *//*  @Override
            public boolean onClick(View v, MotionEvent event) {


                return false;
            }*//*
        });*/

        ingredient_1.setText(getIntent().getStringExtra("result"));
    }

    public void init() {

        horizontalScrollLinearLayout = (LinearLayout) findViewById(R.id.horizontalScrollLinearLayout);
        horizontalScrollLinearLayout.setGravity(Gravity.CENTER);

        horizontalScrollLinearLayoutContainer = (LinearLayout) findViewById(R.id.horizontalScrollLinearLayoutContainer);

        hsv = (HorizontalScrollView) findViewById(R.id.hsv);

        recipeCategoryAdd = (Spinner) findViewById(R.id.recipe_category_add);
        recipeCategoryAdd.setAdapter(new MyAdapter(this, R.layout.spinner_style,
                spinnerValues));

        LinearLayout.LayoutParams imageDimention = new LinearLayout.LayoutParams(getPx(120), getPx(120));
        imageDimention.setMargins(getPx(3), getPx(3), getPx(3), getPx(3));

        for (int i = 0; i < 8; i++) {
            image[i] = new ImageView(getApplicationContext());
            image[i].setLayoutParams(imageDimention);
            image[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
        }


        for (int i = 0; i < 10; i++) {
            editText[i] = (EditText) getLayoutInflater().inflate(R.layout.new_edit_text, null);
        }


    }

    public class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.spinner_style, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(spinnerValues[position]);
            TextView subSpinner = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            subSpinner.setText(spinnerSubs[position]);
            ImageView left_icon = (ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(total_images[position]);
            return mySpinner;
        }
    }


    public int getPx(int dimensionDp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_recipe, menu);
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

    public void pickImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void addEditText(View view) {
        LinearLayout vg = (LinearLayout) findViewById(R.id.ingredients);
        if (editTextCount < 10) {
            vg.addView(editText[editTextCount]);
            editTextCount++;
        } else {
            Toast.makeText(this, "Cannot add more ingredients", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int request_code, int result_code, Intent data) {
        InputStream stream = null;
        if (imageCount < 8 && REQUEST_CODE == 1 && result_code == Activity.RESULT_OK) {
            try {
                if (bitmap[imageCount] != null) {
                    bitmap[imageCount].recycle();
                }
                //to get the image file form the subactivity
                stream = getContentResolver().openInputStream(data.getData());
                bitmap[imageCount] = BitmapFactory.decodeStream(stream);

                image[imageCount].setImageBitmap(bitmap[imageCount]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (stream != null)
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            horizontalScrollLinearLayout.addView(image[imageCount]);
            hsv.post(new Runnable() {
                @Override
                public void run() {
                        hsv.fullScroll(ScrollView.FOCUS_RIGHT);
                    }
            });
        } else {
            Toast.makeText(this, "Cannot add more images", Toast.LENGTH_LONG).show();
        }

        imageCount++;
    }


}

