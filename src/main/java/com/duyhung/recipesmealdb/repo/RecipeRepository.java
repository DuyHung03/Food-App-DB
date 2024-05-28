package com.duyhung.recipesmealdb.repo;

import com.duyhung.recipesmealdb.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "select * from recipes where user_id = :userId", nativeQuery = true)
    List<Recipe> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM recipes WHERE title LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Recipe> findAllByTitle(@Param("query") String query);

}
