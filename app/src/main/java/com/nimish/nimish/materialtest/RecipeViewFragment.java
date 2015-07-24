package com.nimish.nimish.materialtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RecipeViewFragment extends Fragment {
    private RecyclerView recipeList;
    private ListAdapter adapter;
    public RecipeViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the editbox for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recipe_view, container, false);
        recipeList = (RecyclerView) rootView.findViewById(R.id.recipe_list);
        adapter = new ListAdapter(getActivity(),getData());
        recipeList.setHasFixedSize(true);
        recipeList.setAdapter(adapter);
        recipeList.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return rootView;
    }

    public List<RecipePojo> getData(){
        List<RecipePojo> data = new ArrayList<RecipePojo>();
        int []recipeImage = {R.drawable.res1, R.drawable.res2,R.drawable.res3,R.drawable.res4,R.drawable.res5,
                R.drawable.res6 ,R.drawable.res7,R.drawable.res8};

        String []recipeName = {"Ice Cream","Burger","StrawBerry Chocolate mango chip","Chocolate Pudding","IDK","Sandwiches",
        "cake","chicken"};

        String [] recipecategory = {"Protein","Low Carbs","Sweet","Protein","Low Carbs","Sweet","Protein","Low Carbs"};

        String [] recipeDuration = {"10","20","30","10","20","30","10","20"};

        String [] recipeRating = {"12","14","19","100","12","14","19","100"};

        for(int i = 0 ;i<100;i++){
            RecipePojo current = new RecipePojo(recipeName[i%8],recipecategory[i%8],recipeDuration[i%8],recipeRating[i%8],recipeImage[i%8]);
            data.add(current);
        }

        return data;
    }

}
