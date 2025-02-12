package com.cleanFood.repository

import com.cleanFood.entitys.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String>  {
}
