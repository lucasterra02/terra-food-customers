package com.terra.food.customers.controller.response

import com.terra.food.customers.enums.ProductStatus
import com.terra.food.customers.model.CustomerModel
import java.math.BigDecimal

data class ProductResponse (

    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: ProductStatus? = null
)
