package com.my.buyrecipes.repository.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Cart (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val totalInCents: Int,

    @OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val cartItems: MutableList<CartItem> = mutableListOf(),

//    @OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
//    @JsonManagedReference
//    val recipes: MutableList<Recipe> = mutableListOf()
)