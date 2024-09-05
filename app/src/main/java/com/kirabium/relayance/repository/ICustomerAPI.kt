package com.kirabium.relayance.repository

import com.kirabium.relayance.domain.model.Customer

interface ICustomerAPI {


    fun initRepo()

    fun listCustomers() : List<Customer>

    fun add(c: Customer)

    fun loadCustomerById(customerId: Int): Customer?

    fun createNewCustomer(sNameP: String, sEmailP: String): Customer


}
