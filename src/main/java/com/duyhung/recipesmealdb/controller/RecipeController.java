package com.duyhung.recipesmealdb.controller;

import com.duyhung.recipesmealdb.entity.Recipe;
import com.duyhung.recipesmealdb.entity.Response;
import com.duyhung.recipesmealdb.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public ResponseEntity<Response<Recipe>> addNewRecipe(
            @RequestBody Recipe recipe
    ) {
        try {
            recipeService.addNewRecipe(recipe);
            return ResponseEntity.ok(new Response<>(200, null, recipe));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<Recipe>>> getAllRecipe() {
        try {
            List<Recipe> recipes = recipeService.getAllRecipe();
            return ResponseEntity.ok(new Response<>(200, null, recipes));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Response<List<Recipe>>> getRecipesByUserId(@PathVariable Long userId) {
        try {
            List<Recipe> recipes = recipeService.getRecipesByUserId(userId);
            return ResponseEntity.ok(new Response<>(200, null, recipes));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Response<List<Recipe>>> searchRecipe(@RequestParam String query) {
        try {
            List<Recipe> recipes = recipeService.getRecipeByTitle(query);
            return ResponseEntity.ok(new Response<>(200, null, recipes));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

}
