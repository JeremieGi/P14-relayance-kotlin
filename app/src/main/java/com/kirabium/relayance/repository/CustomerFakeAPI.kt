package com.kirabium.relayance.repository

import com.kirabium.relayance.domain.model.Customer
import java.util.Calendar
import java.util.Date

class CustomerFakeAPI : ICustomerAPI {

    private var _customers : MutableList<Customer>  = mutableListOf()

    companion object {
        /**
         * Génère la date du jour - le nombre de mois passé en paramètre
         */
        fun generateDate(monthsBack: Int, calendar: Calendar = Calendar.getInstance()): Date {
            calendar.add(Calendar.MONTH, -monthsBack)
            return calendar.time
        }
    }


    // Fonction utile surtout dans les tests autos pour réinitialiser les données
    override fun initRepo() {
        _customers = mutableListOf(
            Customer(1, "Alice Wonderland", "alice@example.com", generateDate(12)),
            Customer(2, "Bob Builder", "bob@example.com", generateDate(6)),
            Customer(3, "Charlie Chocolate", "charlie@example.com", generateDate(3)),
            Customer(4, "Diana Dream", "diana@example.com", generateDate(1)),
            Customer(5, "Evan Escape", "evan@example.com", generateDate(0)),
        )
    }

    override fun listCustomers(): List<Customer> {
        return _customers
    }

    override fun add(c: Customer) {
        _customers.add(c)
    }

    override fun loadCustomerById(customerId: Int): Customer? {
        return _customers.find { it.id == customerId }
    }

    override fun createNewCustomer(sNameP: String, sEmailP: String): Customer {
        return Customer(
            id = getNewID(),
            name = sNameP,
            email = sEmailP,
            createdAt = Calendar.getInstance().time
        )
    }


    private fun getNewID(): Int {
        return _customers.maxOf { it.id } + 1
    }


}