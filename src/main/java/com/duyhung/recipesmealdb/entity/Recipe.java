package com.duyhung.recipesmealdb.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "[recipes]")
public class Recipe {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue
    private Long recipeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String description;

    private String instructions;

    private Integer servings;

    private Integer prep_time; // in minutes

    private Integer cook_time; // in minutes

    private String created_at;

    private String note;

    @OneToMany(targetEntity = Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Image> images = new ArrayList<>();

}
