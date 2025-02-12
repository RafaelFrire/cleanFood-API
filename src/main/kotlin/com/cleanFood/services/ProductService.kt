package com.cleanFood.services

import com.cleanFood.dtos.ProductResponseDTO
import com.cleanFood.entitys.Product
import com.cleanFood.exceptions.ExceptionProductNotFounded
import com.cleanFood.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.Exception

@Service
class ProductService(){
    @Autowired
    private lateinit var productRepository: ProductRepository;

    fun store(data:ProductResponseDTO):Product{
        try{
            var product: Product = Product(name = data.name, price = data.price, stock = data.stock, order = null);
            productRepository.save(product);
            return product;
        }
        catch (ex: Exception){
            throw Exception("error:" + ex.message);
        }
    }

    fun findById(id: String):Optional<Product>{
        try{
            val product:Optional<Product> = this.productRepository.findById(id);
            if(product.isEmpty){
                throw ExceptionProductNotFounded("Produto não encontrado.")
            }
            return product;

        }
        catch (ex:Exception){
            throw ExceptionProductNotFounded("Produto não encontrado.")
        }
    }

    fun findMany():List<Product>{
        try{
            val productList: List<Product> = this.productRepository.findAll();

            return productList;

        }
        catch (ex:Exception){
            throw Exception("error" + ex.message);
        }
    }
}