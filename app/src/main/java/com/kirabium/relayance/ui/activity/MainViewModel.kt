package com.kirabium.relayance.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirabium.relayance.repository.CustomersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val customersRepository : CustomersRepository
) : ViewModel(){

    // Class for the communication between the ViewModel and the fragment
    private val _uiState = MutableStateFlow(CustomerListUIStates())
    val uiState: StateFlow<CustomerListUIStates> = _uiState.asStateFlow()

    init {
        customersRepository.initRepo()
        observeCustomers()
    }

    private fun observeCustomers() {

        // Durée de vie du scope = durée de vie du viewModel
        viewModelScope.launch {

            // Collecte du Flow
            customersRepository.customersFlow.collect { listCustomer ->

                _uiState.value = CustomerListUIStates(listCustomer)

            }
        }

    }

    fun loadAllCustomers() {
        viewModelScope.launch {
            customersRepository.loadAllCustomers()
        }
    }

}
