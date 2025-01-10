package com.my.buyrecipes.service

import com.my.buyrecipes.controller.dto.CartDto

interface CartService {
    fun getById(id: Int) : CartDto
}