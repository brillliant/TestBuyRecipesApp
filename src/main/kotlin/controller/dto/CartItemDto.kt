package com.my.buyrecipes.controller.dto

import com.my.buyrecipes.repository.entity.Product
import com.my.buyrecipes.repository.entity.Recipe

data class CartItemDto (
    val id: Int,
    val product: Product,
    val recipe: Recipe
)