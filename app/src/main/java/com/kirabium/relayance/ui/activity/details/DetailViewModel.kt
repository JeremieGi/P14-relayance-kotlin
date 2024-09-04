package com.kirabium.relayance.ui.activity.details

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.repository.CustomersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val customersRepository : CustomersRepository
) : ViewModel(){


    fun loadCustomerById(customerId: Int): Customer? {
        return customersRepository.loadCustomerById(customerId)
    }


}
