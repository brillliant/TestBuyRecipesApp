package com.my.buyrecipes.repository

import com.my.buyrecipes.repository.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Int>