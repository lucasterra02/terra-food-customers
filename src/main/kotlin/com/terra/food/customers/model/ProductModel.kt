package com.terra.food.customers.model

import com.terra.food.customers.enums.ProductStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "product")
data class ProductModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: ProductStatus? = null
        set(value) {
            if (field == ProductStatus.CANCELADO || field == ProductStatus.DELETADO) {
                throw Exception("Não é possível alterar um livro com status ${field!!.name}")
            }
            field = value
        }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: ProductStatus?
    ) : this(id, name, price, customer) {
        this.status = status
    }

}