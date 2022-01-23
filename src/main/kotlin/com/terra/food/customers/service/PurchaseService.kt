package com.terra.food.customers.service

import com.terra.food.customers.events.PurchaseEvent
import com.terra.food.customers.model.PurchaseModel
import com.terra.food.customers.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
        applicationEventPublisher.publishEvent(
            PurchaseEvent(
                this, purchaseModel
            )
        )
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
