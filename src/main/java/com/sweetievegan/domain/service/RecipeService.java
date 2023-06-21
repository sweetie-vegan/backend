package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.RecipeRequestDto;
import com.sweetievegan.domain.dto.RecipeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    List<RecipeResponseDto> getAllRecipes();
    Long registerRecipe(RecipeRequestDto recipeRequestDto);
    RecipeRequestDto updateRecipeDetail(Long recipeId, RecipeRequestDto recipeRequestDto);
    Long removeRecipe(Long recipeId);
    RecipeResponseDto findRecipeByRecipeTitle(String title);
}
