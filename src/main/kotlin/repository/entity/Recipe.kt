package com.my.buyrecipes.repository.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Recipe (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,

    @ManyToMany
    @JoinTable(
        name = "recipe_product", // Название промежуточной таблицы
        joinColumns = [JoinColumn(name = "recipe_id")], // Внешний ключ на сторону "product"
        inverseJoinColumns = [JoinColumn(name = "product_id")] // Внешний ключ на сторону "Product"
    )
    @JsonManagedReference
    val products: List<Product> = mutableListOf(),

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonBackReference
    val cartItems: MutableList<CartItem> = mutableListOf(),
)