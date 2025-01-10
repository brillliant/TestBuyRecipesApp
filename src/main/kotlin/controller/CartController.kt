package com.my.buyrecipes.controller

import com.my.buyrecipes.controller.dto.CartDto
import com.my.buyrecipes.controller.dto.RecipeDto
import com.my.buyrecipes.repository.CartRepository
import com.my.buyrecipes.service.CartService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carts")
class CartController(
    val cartService: CartService
) {
    @GetMapping("/{id}")
    fun getCartById(
        @PathVariable("id") cartId: Int,
    ) : CartDto {
        return cartService.getById(cartId)
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

