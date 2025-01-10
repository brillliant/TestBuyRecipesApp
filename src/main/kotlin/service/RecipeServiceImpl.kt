package com.my.buyrecipes.service

import com.my.buyrecipes.controller.CartController
import com.my.buyrecipes.controller.dto.RecipeDto
import com.my.buyrecipes.repository.RecipeRepository
import com.my.buyrecipes.repository.entity.Recipe
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl (
    val recipeRepository: RecipeRepository
) : RecipeService {
    override fun getAll(pageIndex: Int): List<RecipeDto> {
        return recipeRepository.findAll().map { it.toDto() }
    }

    private fun Recipe.toDto(): RecipeDto =
        RecipeDto(
            id = this.id,
            name = this.name
        )
}
