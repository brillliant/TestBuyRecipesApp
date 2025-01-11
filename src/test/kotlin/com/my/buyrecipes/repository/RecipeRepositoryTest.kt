package com.my.buyrecipes.repository

import com.my.buyrecipes.repository.entity.Recipe
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test

@ActiveProfiles("test")
@SpringBootTest
class RecipeRepositoryTest {

    @Autowired
    private lateinit var recipeRepository: RecipeRepository

    @Test
    fun `test get all`() {
        val recipe = Recipe(id = 0, name = "Pizza555")
        recipeRepository.save(recipe)

        val recipe2 = Recipe(id = 0, name = "Pizza2")
        recipeRepository.save(recipe2)

        val retrievedRecipes = recipeRepository.findAll()
        assertEquals(2, retrievedRecipes.size)
    }
}