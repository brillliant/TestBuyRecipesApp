package com.my.buyrecipes.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RecipeController {

    @GetMapping("/recipes")
    fun getRecipes() : String {
        return "bla"
    }
}