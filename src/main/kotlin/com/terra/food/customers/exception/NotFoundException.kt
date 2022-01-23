package com.terra.food.customers.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}