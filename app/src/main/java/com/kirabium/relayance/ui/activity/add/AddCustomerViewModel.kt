package com.kirabium.relayance.ui.activity.add

import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.repository.CustomersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val customersRepository : CustomersRepository
) : ViewModel(){


    fun addCustomer(sNameP : String, sEmailP : String){

        val customer = Customer(
            id = customersRepository.getNewID(),
            name = sNameP,
            email = sEmailP,
            createdAt = Calendar.getInstance().time
        )

        customersRepository.addCustomer(customer)

    }

}
