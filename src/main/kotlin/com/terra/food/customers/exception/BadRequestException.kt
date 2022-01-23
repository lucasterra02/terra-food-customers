package com.terra.food.customers.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {
}