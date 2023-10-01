package com.sweetievegan.domain.recipe.dto;

import lombok.Data;

@Data
public class RecipeRegisterRequest {
    private String title;
    private String content;
}
