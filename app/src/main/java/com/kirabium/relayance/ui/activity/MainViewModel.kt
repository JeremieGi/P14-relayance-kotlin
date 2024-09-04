package com.kirabium.relayance.ui.activity

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.repository.CustomersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val customersRepository : CustomersRepository
) : ViewModel(){

    fun loadAllCustomers(): List<Customer> {
        return customersRepository.customers
    }

}
