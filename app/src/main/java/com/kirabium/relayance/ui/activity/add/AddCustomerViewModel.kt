package com.kirabium.relayance.ui.activity.add

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.repository.CustomersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val customersRepository : CustomersRepository
) : ViewModel(){


    fun addCustomer(sNameP : String, sEmailP : String){

        val customer = customersRepository.createNewCustomer(sNameP,sEmailP)
        customersRepository.addCustomer(customer)


    }

}
