package com.kirabium.relayance.ui.activity

import com.kirabium.relayance.domain.model.Customer

data class CustomerListUIStates (
    val listCustomers : List<Customer> = emptyList()
)
