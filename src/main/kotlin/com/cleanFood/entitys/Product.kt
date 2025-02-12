package com.cleanFood.entitys

import jakarta.persistence.*

@Entity
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null,
    var name: String,
    var price: Double,
    var stock: Int,
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    var order: Order? = null
)