package com.sweetievegan.domain.recipe.service;

import com.sweetievegan.domain.recipe.dto.RecipeRegisterRequest;
import com.sweetievegan.domain.recipe.dto.RecipeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {
    List<RecipeResponse> getAllRecipes();
    Long registerRecipe(RecipeRegisterRequest request);
    RecipeRegisterRequest updateRecipeDetail(Long recipeId, RecipeRegisterRequest request);
    Long removeRecipe(Long recipeId);
    RecipeResponse findRecipeByRecipeTitle(String title);
}
