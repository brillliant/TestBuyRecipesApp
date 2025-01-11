package com.my.buyrecipes.service

import com.my.buyrecipes.controller.dto.ProductDto
import com.my.buyrecipes.controller.dto.RecipeDto
import com.my.buyrecipes.repository.RecipeRepository
import com.my.buyrecipes.repository.entity.Product
import com.my.buyrecipes.repository.entity.Recipe
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl (
    val recipeRepository: RecipeRepository
) : RecipeService {

    @Transactional
    override fun getAll(pageIndex: Int): List<RecipeDto> {
        return recipeRepository.findAll().map { it.toDto() }
    }
}

fun Recipe.toDto(): RecipeDto =
    RecipeDto(
        id = this.id,
        name = this.name,
        products = this.products.map { it.toDto() }
    )

fun Product.toDto(): ProductDto =
    ProductDto(
        id = this.id,
        name = this.name
    )
