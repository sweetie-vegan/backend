package com.sweetievegan.recipe.service;

import com.sweetievegan.recipe.dto.RecipeRegisterRequest;
import com.sweetievegan.recipe.dto.RecipeResponse;

import java.util.List;

public interface RecipeService {
    List<RecipeResponse> getAllRecipes();
    Long registerRecipe(RecipeRegisterRequest request);
    RecipeRegisterRequest updateRecipeDetail(Long recipeId, RecipeRegisterRequest request);
    Long removeRecipe(Long recipeId);
    RecipeResponse findRecipeByRecipeTitle(String title);
}
