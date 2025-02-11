package com.cleanFood.entitys

import jakarta.persistence.*

@Entity
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String,
    var name: String,
    var price: Double,
    var stock: Int,
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    var order: Order
)