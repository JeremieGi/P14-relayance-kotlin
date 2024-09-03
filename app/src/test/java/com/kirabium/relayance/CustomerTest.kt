package com.kirabium.relayance

import com.kirabium.relayance.domain.model.Customer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar
import java.util.Date

class CustomerTest {


    private fun dFakeDDay() : Date {
        val paramCalendar = Calendar.getInstance()
        paramCalendar.set(2024, Calendar.SEPTEMBER, 1)
        return paramCalendar.time
    }

    @Test
    fun isNewCustomer_true_today() {

        val dToday = dFakeDDay()
        val calendarToDay = Calendar.getInstance()
        calendarToDay.time = dToday

        val newCustomer = Customer(1,"","",dToday)

        val bNewCustomer = newCustomer.isNewCustomer(calendarToDay)

        assertEquals(true, bNewCustomer)

    }



    @Test
    fun isNewCustomer_true_3month() {

        val dToday = dFakeDDay()

        val calendarToDay = Calendar.getInstance()
        calendarToDay.time = dToday

        // 3 mois
        val calendarCustomerCreation = calendarToDay
        calendarCustomerCreation.add(Calendar.MONTH, 3)
        val newDate = calendarCustomerCreation.time

        val newCustomer = Customer(1,"","",newDate)

        val bNewCustomer = newCustomer.isNewCustomer(calendarToDay)

        assertEquals(true, bNewCustomer)

    }


    @Test
    fun isNewCustomer_false_3monthAndOneDay() {

        val dToday = dFakeDDay()

        val calendarToDay = Calendar.getInstance()
        calendarToDay.time = dToday

        // 3 mois
        val calendarCustomerCreation = calendarToDay
        calendarCustomerCreation.add(Calendar.MONTH, 3)
        calendarCustomerCreation.add(Calendar.DAY_OF_MONTH, 1)
        val newDate = calendarCustomerCreation.time

        val newCustomer = Customer(1,"","",newDate)

        val bNewCustomer = newCustomer.isNewCustomer(calendarToDay)

        assertEquals(true, bNewCustomer)

    }




}