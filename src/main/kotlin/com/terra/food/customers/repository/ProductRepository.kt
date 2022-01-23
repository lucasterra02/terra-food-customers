package com.terra.food.customers.repository

import com.terra.food.customers.enums.ProductStatus
import com.terra.food.customers.model.CustomerModel
import com.terra.food.customers.model.ProductModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<ProductModel, Int> {
    fun findByStatus(ativo: ProductStatus ,pageable: Pageable): Page<ProductModel>
    fun findByCustomer(cusstomer: CustomerModel): List<ProductModel>
}