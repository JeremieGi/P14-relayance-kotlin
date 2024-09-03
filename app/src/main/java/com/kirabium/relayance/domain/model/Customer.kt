package com.kirabium.relayance.domain.model

import java.util.Calendar
import java.util.Date

data class Customer(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: Date
) {

    /**
     * Nouveau client, si le client a été créé il y a moins de 3 mois
     */
    fun isNewCustomer(today: Calendar = Calendar.getInstance() ): Boolean {

        val createdAtCalendar = Calendar.getInstance().apply {
            time = createdAt
        }
        today.add(Calendar.MONTH, -3)
        return !createdAtCalendar.before(today)

    }

}
