package com.terra.food.customers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class TerraFoodCustomersApplication

fun main(args: Array<String>) {
	runApplication<TerraFoodCustomersApplication>(*args)
}
