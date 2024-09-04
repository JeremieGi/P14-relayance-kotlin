package com.kirabium.relayance.repository

import com.kirabium.relayance.domain.model.Customer
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

    // TODO Denis : Il faut faire un MVVM avec des Flow + UI State ?
    private val _customers : MutableList<Customer> = mutableListOf(
        Customer(1, "Alice Wonderland", "alice@example.com", generateDate(12)),
        Customer(2, "Bob Builder", "bob@example.com", generateDate(6)),
        Customer(3, "Charlie Chocolate", "charlie@example.com", generateDate(3)),
        Customer(4, "Diana Dream", "diana@example.com", generateDate(1)),
        Customer(5, "Evan Escape", "evan@example.com", generateDate(0)),
    )
    val customers : List<Customer> = _customers.toList()



    /**
     * Ajouter un client
     */
    fun addCustomer(c : Customer){
        _customers.add(c)
    }

    fun loadCustomerById(customerId: Int) : Customer? {
        return customers.find { it.id == customerId }
    }


}