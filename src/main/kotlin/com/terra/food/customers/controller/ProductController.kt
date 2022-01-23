package com.terra.food.customers.controller

import com.terra.food.customers.controller.request.PostProductRequest
import com.terra.food.customers.controller.request.PutProductRequest
import com.terra.food.customers.controller.response.ProductResponse
import com.terra.food.customers.extension.toProductModel
import com.terra.food.customers.extension.toResponse
import com.terra.food.customers.service.CustomerService
import com.terra.food.customers.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("product")
class ProductController(
    val productService: ProductService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostProductRequest) {
        val customer = customerService.findById(request.customerId)

        return productService.create(request.toProductModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<ProductResponse> =
        productService.findAll(pageable).map { it.toResponse() }

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<ProductResponse> = productService.findActives(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ProductResponse {
        return productService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        productService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody product: PutProductRequest) {
        val productSaved = productService.findById(id)
        productService.update(product.toProductModel(productSaved))
    }

}