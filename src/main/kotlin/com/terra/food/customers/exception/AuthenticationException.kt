package com.terra.food.customers.exception

class AuthenticationException(override val message: String, val errorCode: String): Exception()