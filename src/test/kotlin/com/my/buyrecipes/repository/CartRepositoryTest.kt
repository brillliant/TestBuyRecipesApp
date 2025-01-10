package com.my.buyrecipes.repository

import com.my.buyrecipes.repository.entity.Cart
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private lateinit var cartRepository: CartRepository

    @Test
    fun `test find by id`() {
        val createdCartId = cartRepository.save(
            Cart(id = 0, totalInCents = 44)
        ).id

        val createdCart = cartRepository.findById(createdCartId).get()
        assertEquals(44, createdCart.totalInCents)
    }
}