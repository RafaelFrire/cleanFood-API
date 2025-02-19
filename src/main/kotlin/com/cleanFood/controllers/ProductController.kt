package com.cleanFood.controllers

import com.cleanFood.dtos.ProductDTO
import com.cleanFood.entitys.Product
import com.cleanFood.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


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
    fun storeProduct(@RequestBody product: ProductDTO): Product{
        return productService.store(product);
    }

    @PatchMapping("/product/{id}/update")
    fun updateProduct(@PathVariable(value = "id") id:String, @RequestBody product:ProductDTO):Product{
       return productService.update(id, product);
    }
}