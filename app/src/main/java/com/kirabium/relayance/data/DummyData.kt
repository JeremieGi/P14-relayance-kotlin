package com.kirabium.relayance.data

import com.kirabium.relayance.domain.model.Customer
import java.util.Calendar
import java.util.Date

// On devrait faire un vrai repository ici avant de faire des tests

object DummyData {

    /**
     * Génère la date du jour - le nombre de mois passé en paramètre
     */
    fun generateDate(monthsBack: Int, calendar: Calendar = Calendar.getInstance()): Date {
        calendar.add(Calendar.MONTH, -monthsBack)
        return calendar.time
    }

    val customers = listOf(
        Customer(1, "Alice Wonderland", "alice@example.com", generateDate(12)),
        Customer(2, "Bob Builder", "bob@example.com", generateDate(6)),
        Customer(3, "Charlie Chocolate", "charlie@example.com", generateDate(3)),
        Customer(4, "Diana Dream", "diana@example.com", generateDate(1)),
        Customer(5, "Evan Escape", "evan@example.com", generateDate(0)),
    )
}