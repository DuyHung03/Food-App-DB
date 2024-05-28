package com.duyhung.recipesmealdb.service;

import com.duyhung.recipesmealdb.entity.Image;
import com.duyhung.recipesmealdb.entity.Recipe;
import com.duyhung.recipesmealdb.repo.ImageRepository;
import com.duyhung.recipesmealdb.repo.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ImageRepository imageRepository;

    public void addNewRecipe(Recipe recipe) {
        List<Image> images = Arrays.asList(new Image("dadad"), new Image("dasdas2"));
        recipe.getImages().addAll(images);
        recipe.setCreated_at(new Date().toString());
        recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.findByUserId(userId);
    }

    public List<Recipe> getRecipeByTitle(String query) throws Exception {
        List<Recipe> recipes = recipeRepository.findAllByTitle(query);
        if (recipes.isEmpty())
            throw new Exception("No recipes found for: " + query);
        return recipes;
    }

}
