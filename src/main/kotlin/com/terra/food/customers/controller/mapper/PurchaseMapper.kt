package com.terra.food.customers.controller.mapper

import com.terra.food.customers.controller.request.PostPurchaseRequest
import com.terra.food.customers.model.PurchaseModel
import com.terra.food.customers.service.CustomerService
import com.terra.food.customers.service.ProductService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val productService: ProductService,
    private val customerService: CustomerService
) {
    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val products = productService.findAllById(request.productIds)

        return PurchaseModel(
            customer = customer,
            products = products.toMutableList(),
            price = products.sumOf { it.price }
        )
    }
}