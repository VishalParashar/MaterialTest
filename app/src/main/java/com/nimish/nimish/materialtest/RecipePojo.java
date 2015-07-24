package com.nimish.nimish.materialtest;

import android.graphics.Bitmap;

public class RecipePojo {
    String recipeName;
    String recipeCategory;
    String recipeDuration;
    String recipeRating;
    int recipeImage;
    public RecipePojo() {
    }

    public RecipePojo(String recipeName, String recipeCategory, String recipeDuration, String recipeRating, int recipeImage) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.recipeDuration = recipeDuration;
        this.recipeRating = recipeRating;
        this.recipeImage = recipeImage;
    }

    public RecipePojo(String recipeName, String recipeCategory, String recipeDuration, String recipeRating) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.recipeDuration = recipeDuration;
        this.recipeRating = recipeRating;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDuration() {
        return recipeDuration;
    }

    public void setRecipeDuration(String recipeDuration) {
        this.recipeDuration = recipeDuration;
    }

    public String getRecipeRating() {
        return recipeRating;
    }

    public void setRecipeRating(String recipeRating) {
        this.recipeRating = recipeRating;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }
}
