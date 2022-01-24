package com.terra.food.customers.controller

import com.terra.food.customers.controller.request.PostCustomerRequest
import com.terra.food.customers.controller.request.PutCustomerRequest
import com.terra.food.customers.controller.response.CustomerResponse
import com.terra.food.customers.extension.toCustomerModel
import com.terra.food.customers.extension.toResponse
import com.terra.food.customers.security.UserCanOnlyAccessTheirOwnResource
import com.terra.food.customers.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostCustomerRequest) {
        return customerService.create(request.toCustomerModel())
    }

    @GetMapping("/{id}")
    @UserCanOnlyAccessTheirOwnResource
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid request: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(request.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }

}