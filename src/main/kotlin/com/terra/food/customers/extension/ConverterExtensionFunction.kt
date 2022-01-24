package com.terra.food.customers.extension

import com.terra.food.customers.controller.request.PostCustomerRequest
import com.terra.food.customers.controller.request.PostProductRequest
import com.terra.food.customers.controller.request.PutCustomerRequest
import com.terra.food.customers.controller.request.PutProductRequest
import com.terra.food.customers.controller.response.CustomerResponse
import com.terra.food.customers.controller.response.ProductResponse
import com.terra.food.customers.enums.CustomerStatus
import com.terra.food.customers.enums.ProductStatus
import com.terra.food.customers.model.CustomerModel
import com.terra.food.customers.model.ProductModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO, password = this.password)
}

fun PostProductRequest.toProductModel(customer: CustomerModel): ProductModel {
    return ProductModel(name = this.name, price = this.price, status = ProductStatus.ATIVO, customer = customer)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        name = this.name,
        email = this.email,
        status = previousValue.status,
        password = previousValue.password
    )
}

fun PutProductRequest.toProductModel(previousValue: ProductModel): ProductModel {
    return ProductModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )

}

fun ProductModel.toResponse(): ProductResponse {
    return ProductResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}
