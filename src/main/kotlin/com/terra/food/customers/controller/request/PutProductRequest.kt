package com.terra.food.customers.controller.request

import java.math.BigDecimal

data class PutProductRequest(


    var name: String?,

    var price: BigDecimal?
)
