package com.terra.food.customers.events.listener

import com.terra.food.customers.events.PurchaseEvent
import com.terra.food.customers.service.ProductService
import com.terra.food.customers.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldProductListener(
    private val productService: ProductService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        productService.purchase(purchaseEvent.purchaseModel.products)
    }

}