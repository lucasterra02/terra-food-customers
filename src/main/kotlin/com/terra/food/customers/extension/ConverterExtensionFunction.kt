package com.terra.food.customers.extension

import com.terra.food.customers.controller.request.PostCustomerRequest
import com.terra.food.customers.controller.request.PutCustomerRequest
import com.terra.food.customers.model.CustomerModel

fun PostCustomerRequest.toCustomerModel() : CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int) : CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}