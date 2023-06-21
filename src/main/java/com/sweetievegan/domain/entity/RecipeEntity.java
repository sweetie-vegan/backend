package com.sweetievegan.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe;

    private String title;
    private String content;

    @Builder
    public RecipeEntity(Long recipe, String title, String content) {
        this.recipe = recipe;
        this.title = title;
        this.content = content;
    }
}
