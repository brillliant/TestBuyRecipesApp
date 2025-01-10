package com.my.buyrecipes.controller

import com.my.buyrecipes.controller.dto.RecipeDto
import org.springframework.web.bind.annotation.*

@RestController("/carts")
//@RequestMapping("/")
class CartController {

    @GetMapping("/{id}")
    fun getCartById(
        @PathVariable("id") cartId: String,
    ) : String {
        return "cart $cartId"
    }

    @PostMapping("/{cartId}/add_recipe")
    fun addRecipe(
        @PathVariable("cartId") cartId: String,
        @RequestBody recipeDto: RecipeDto,
    ) : String {
        return "cart ${recipeDto.name}"
    }

    @DeleteMapping("/{cartId}/recipes/{recipeId}")
    fun deleteRecipe(
        @PathVariable("cartId") cartId: String,
        @PathVariable("recipeId") recipeId: String,
    ) : String {
        return "cartId $cartId, recipeId $recipeId"
    }
}

