package com.terra.food.customers.controller.response

import com.terra.food.customers.enums.CustomerStatus
import javax.persistence.*

data class CustomerResponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
