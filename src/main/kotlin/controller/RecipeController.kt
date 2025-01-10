package com.my.buyrecipes.controller

import com.my.buyrecipes.controller.dto.RecipeDto
import com.my.buyrecipes.service.RecipeService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recipes")
class RecipeController(
    val recipeService: RecipeService
) {
    @GetMapping()
    fun getAllRecipes(
        @RequestParam("page", required = false) pageIndex: Int? = 0,
    ) : List<RecipeDto> {
        val effectivePageIndex = pageIndex ?: 0
        return recipeService.getAll(effectivePageIndex)
    }
}