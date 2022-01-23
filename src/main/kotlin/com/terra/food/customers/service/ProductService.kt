package com.terra.food.customers.service

import com.terra.food.customers.enums.ProductStatus
import com.terra.food.customers.model.CustomerModel
import com.terra.food.customers.model.ProductModel
import com.terra.food.customers.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository
) {
    fun create(product: ProductModel) {
        productRepository.save(product)
    }

    fun findAll(pageable: Pageable): Page<ProductModel> {
        return productRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<ProductModel> {
        return productRepository.findByStatus(ProductStatus.ATIVO, pageable)
    }

    fun findById(id: Int): ProductModel {
        return productRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val product = findById(id)
        product.status = ProductStatus.CANCELADO
        update(product)
    }

    fun update(product: ProductModel) {
        productRepository.save(product)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val products = productRepository.findByCustomer(customer)
        for(product in products) {
            product.status = ProductStatus.DELETADO
        }
        productRepository.saveAll(products)
    }
}
