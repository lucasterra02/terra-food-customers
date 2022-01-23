package com.terra.food.customers.controller.request

import com.terra.food.customers.validation.EmailAvailable
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest(

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,
    @field:NotEmpty(message = "E-mail deve ser informado")
    @EmailAvailable
    var email: String
)