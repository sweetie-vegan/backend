package com.sweetievegan.recipe.dto;

import lombok.Data;

@Data
public class RecipeResponse {
    private Long id;
    private String title;
    private String content;
}
