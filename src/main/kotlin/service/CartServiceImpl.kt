package com.my.buyrecipes.service

import com.my.buyrecipes.controller.dto.CartDto
import com.my.buyrecipes.controller.dto.CartItemDto
import com.my.buyrecipes.repository.CartRepository
import com.my.buyrecipes.repository.entity.Cart
import com.my.buyrecipes.repository.entity.CartItem
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CartServiceImpl (
    val cartRepository: CartRepository
) : CartService {

    @Transactional
    override fun getById(id: Int): CartDto {
        return cartRepository.findById(id).getOrNull()?.toDto() ?: throw EntityNotFoundException("Entity with $id is not found")
    }
}

fun Cart.toDto(): CartDto =
    CartDto(
        id = this.id,
        totalInCents = this.totalInCents,
        cartItems = this.cartItems.map { it.toDto() },
        //recipeItems = this.recipes.map { it.toDto() }
    )

fun CartItem.toDto(): CartItemDto =
    CartItemDto(
        id = this.id,
        product = this.product,
        recipe = this.recipe
    )