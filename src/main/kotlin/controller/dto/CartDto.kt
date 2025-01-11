package com.my.buyrecipes.controller.dto

data class CartDto (
    val id: Int,
    val totalInCents: Int,
    val cartItems: List<CartItemDto>,
)