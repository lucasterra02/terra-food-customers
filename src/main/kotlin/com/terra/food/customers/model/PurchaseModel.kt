package com.terra.food.customers.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")
data class PurchaseModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

    @ManyToMany
    @JoinTable(
        name = "purchase_product",
        joinColumns = [JoinColumn(name = "purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    val products : MutableList<ProductModel>,

    @Column
    val nfe: String? = null,

    @Column
    val price: BigDecimal,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

)