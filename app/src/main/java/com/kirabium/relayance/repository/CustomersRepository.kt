package com.kirabium.relayance.repository

import com.kirabium.relayance.domain.model.Customer
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CustomersRepository @Inject constructor(
    private val customerAPI : ICustomerAPI
) {


    private val _customersFlow = MutableSharedFlow<List<Customer>>()
    val customersFlow: SharedFlow<List<Customer>> get() = _customersFlow

    init {
        customerAPI.initRepo()
    }

    // Chargement des clients
    suspend fun loadAllCustomers() {
        _customersFlow.emit(
            customerAPI.listCustomers()
        )
    }

    /**
     * Ajouter un client
     */
    fun addCustomer(c : Customer){
        customerAPI.add(c)
    }

    fun loadCustomerById(customerId: Int) : Customer? {
        return customerAPI.loadCustomerById(customerId)
    }

    fun createNewCustomer(sNameP: String, sEmailP: String): Customer {
        return customerAPI.createNewCustomer(sNameP,sEmailP)
    }



}