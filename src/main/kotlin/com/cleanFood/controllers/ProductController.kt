package com.cleanFood.controllers

import com.cleanFood.dtos.ProductResponseDTO
import com.cleanFood.entitys.Product
import com.cleanFood.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional


@RestController
class ProductController {

    @Autowired
    val productService: ProductService = ProductService();

    @GetMapping("/products")
    fun getAllProduct():List<Product>{
        return this.productService.findMany();
    }

    @GetMapping("/product/{id}")
    fun findById(@PathVariable(value = "id") id: String):Optional<Product>{
        return this.productService.findById(id);
    }

    @PostMapping("/product/store")
    fun storeProduct(@RequestBody product: ProductResponseDTO): Product{
        return productService.store(product);
    }


}