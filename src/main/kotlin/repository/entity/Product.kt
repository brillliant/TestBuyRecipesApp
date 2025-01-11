package com.my.buyrecipes.repository.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val priceInCents: Int,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonBackReference
    val cartItems: MutableList<CartItem> = mutableListOf(),

    @ManyToMany(mappedBy = "products") // Связь управляется сущностью Recipe
    @JsonBackReference
    val recipes: MutableList<Recipe> = mutableListOf()
)