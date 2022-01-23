package com.terra.food.customers.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostProductRequest(
    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)