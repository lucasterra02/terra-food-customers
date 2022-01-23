package com.terra.food.customers.repository

import com.terra.food.customers.model.PurchaseModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository : CrudRepository<PurchaseModel, Int> {

}
