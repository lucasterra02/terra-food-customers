package com.terra.food.customers.events

import com.terra.food.customers.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val purchaseModel: PurchaseModel
) : ApplicationEvent(source)