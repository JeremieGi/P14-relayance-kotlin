package com.kirabium.relayance.repository

import com.kirabium.relayance.domain.model.Customer
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import java.util.Calendar
import java.util.Date

// Brancher Repo + Hilt + App + ViewModel

class CustomersRepository {

    companion object {
        /**
         * Génère la date du jour - le nombre de mois passé en paramètre
         */
        fun generateDate(monthsBack: Int, calendar: Calendar = Calendar.getInstance()): Date {
            calendar.add(Calendar.MONTH, -monthsBack)
            return calendar.time
        }
    }

    private val _customersFlow = MutableSharedFlow<List<Customer>>()
    val customersFlow: SharedFlow<List<Customer>> get() = _customersFlow


    private val _customers : MutableList<Customer> = mutableListOf(
        Customer(1, "Alice Wonderland", "alice@example.com", generateDate(12)),
        Customer(2, "Bob Builder", "bob@example.com", generateDate(6)),
        Customer(3, "Charlie Chocolate", "charlie@example.com", generateDate(3)),
        Customer(4, "Diana Dream", "diana@example.com", generateDate(1)),
        Customer(5, "Evan Escape", "evan@example.com", generateDate(0)),
    )


    // Chargement des clients
    suspend fun loadAllCustomers() {

         _customersFlow.emit(_customers)

    }


    /**
     * Ajouter un client
     */
    fun addCustomer(c : Customer){
        _customers.add(c)
    }

    fun loadCustomerById(customerId: Int) : Customer? {
        return _customers.find { it.id == customerId }
    }

    fun getNewID(): Int {
        return _customers.maxOf { it.id } + 1
    }


}