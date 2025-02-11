package com.cleanFood.entitys

import jakarta.persistence.*
import java.sql.Date


@Entity
@Table(name = "pedido")
class Order (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String,
    var date: Date,
    var amount: Double

)