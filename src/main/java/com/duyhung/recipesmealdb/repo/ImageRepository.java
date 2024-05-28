package com.duyhung.recipesmealdb.repo;

import com.duyhung.recipesmealdb.entity.Image;
import com.duyhung.recipesmealdb.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
