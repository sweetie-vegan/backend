package com.sweetievegan.recipe.dto.request;

import lombok.Data;

@Data
public class RecipeRegisterRequest {
    private String title;
    private String content;
}
