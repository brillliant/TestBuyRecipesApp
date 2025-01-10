package com.my.buyrecipes.service

import com.my.buyrecipes.controller.dto.CartDto
import com.my.buyrecipes.repository.CartRepository
import com.my.buyrecipes.repository.entity.Cart
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

    private fun Cart.toDto(): CartDto =
        CartDto(
            id = this.id,
            totalInCents = this.totalInCents
        )
}