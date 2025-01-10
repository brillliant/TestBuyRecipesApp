package com.my.buyrecipes.service

import com.my.buyrecipes.controller.dto.RecipeDto

interface RecipeService {
    fun getAll(pageIndex: Int): List<RecipeDto>
}