package com.terra.food.customers.enums

enum class Errors(val code :String, val message: String) {

    ML000("ML000", "Access Denied"),
    ML101("ML101", "Product [%s] not exists"),
    ML102("ML102", "Cannot update Product with status [%s]"),
    ML201("ML201", "Customer [%s] not exists"),
    ML001("ML001", "Invalid Request")
}