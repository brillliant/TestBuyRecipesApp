package com.my.buyrecipes.controller

import com.my.buyrecipes.controller.dto.ProductDto
import com.my.buyrecipes.controller.dto.RecipeDto
import com.my.buyrecipes.service.RecipeService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.get

class RecipeControllerTest (
) {
    private val recipeService: RecipeService = mockk()
    private val recipeController = RecipeController(recipeService)
    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(recipeController).build()

    @Test
    fun `getAllRecipes should return recipes with default page index`() {
        val recipes = listOf(
            RecipeDto(id = 1, name = "Recipe 1", products =
                mutableListOf(
                    ProductDto(
                        id = 1,
                        name = "product1"
                    ),
                    ProductDto(
                        id = 2,
                        name = "product2"
                    )
                )
            ),
            RecipeDto(id = 2, name = "Recipe 2", products =
                mutableListOf(
                    ProductDto(
                        id = 3,
                        name = "product3"
                    ),
                    ProductDto(
                        id = 4,
                        name = "product4"
                    )
                )
            )
        )
        every { recipeService.getAll(0) } returns recipes

        mockMvc.get("/recipes")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].id") { value(1) }
                jsonPath("$[0].name") { value("Recipe 1") }
                jsonPath("$[1].id") { value(2) }
                jsonPath("$[1].name") { value("Recipe 2") }
            }
    }
}