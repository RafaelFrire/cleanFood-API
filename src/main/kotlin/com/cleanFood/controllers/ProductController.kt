package com.cleanFood.controllers

import com.cleanFood.dtos.ProductResponseDTO
import com.cleanFood.entitys.Product
import com.cleanFood.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ProductController {

    @Autowired
    val productService: ProductService = ProductService();

    @PostMapping("/product/store")
    fun storeProduct(@RequestBody product: ProductResponseDTO): Product{
        return productService.store(product);
    }



}