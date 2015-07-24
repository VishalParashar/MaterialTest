package com.nimish.nimish.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private final LayoutInflater inflater;
    List<RecipePojo> data = Collections.emptyList();
    ListViewHolder viewHolder;

    public ListAdapter(Context context, List<RecipePojo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view, parent, false);

         viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        RecipePojo current = data.get(position);
        viewHolder.recipeImage.setImageDrawable(null);
        viewHolder.recipeName.setText(current.getRecipeName());
        viewHolder.recipeCategory.setText(current.getRecipeCategory());
        viewHolder.recipeDuration.setText(current.getRecipeDuration());
        viewHolder.recipeRating.setText(current.getRecipeRating());
        viewHolder.recipeImage.setImageResource(current.getRecipeImage());

        viewHolder.recipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(),DetialedRecipe.class);
                in.putExtra("title", data.get(position).getRecipeName());
                in.putExtra("category",data.get(position).getRecipeCategory());
                in.putExtra("duration",data.get(position).getRecipeDuration());
                in.putExtra("rating",data.get(position).getRecipeRating());

                        v.getContext().startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        TextView recipeCategory;
        TextView recipeDuration;
        TextView recipeRating;
        ImageView recipeImage;

        public ListViewHolder(View itemView) {
            super(itemView);

            recipeName = (TextView) itemView.findViewById(R.id.recipe_name);
            recipeCategory = (TextView) itemView.findViewById(R.id.recipe_category);
            recipeDuration = (TextView) itemView.findViewById(R.id.recipe_duration);
            recipeRating = (TextView) itemView.findViewById(R.id.recipe_rating);
            recipeImage = (ImageView) itemView.findViewById(R.id.recipe_image);
        }
    }
}
