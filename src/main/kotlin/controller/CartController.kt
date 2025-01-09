package com.my.buyrecipes.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class CartController {

    @GetMapping("/carts/{id}")
    fun getCartById(
        @PathVariable("id") cartId: String,
    ) : String {
        return "cart $cartId"
    }

    @PostMapping("/carts/{cartId}/add_recipe")
    fun addRecipe(
        @PathVariable("cartId") cartId: String,
        @RequestBody recipeDto: RecipeDto,
    ) : String {
        return "cart ${recipeDto.name}"
    }

    @DeleteMapping("/carts/{cartId}/recipes/{recipeId}")
    fun deleteRecipe(
        @PathVariable("cartId") cartId: String,
        @PathVariable("recipeId") recipeId: String,
    ) : String {
        return "cartId $cartId, recipeId $recipeId"
    }

    data class RecipeDto (
        val name: String
    )

}

