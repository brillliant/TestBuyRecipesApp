package com.my.buyrecipes.repository

import com.my.buyrecipes.repository.entity.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Int>