package com.kirabium.relayance.ui.activity.details

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    // View Model
    private val viewModel: DetailViewModel by viewModels()

    companion object {
        const val EXTRA_CUSTOMER_ID = "customer_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val customerId = intent.getIntExtra(EXTRA_CUSTOMER_ID, -1)
        setupUI(customerId)

    }

    private fun setupUI(customerId: Int) {

        val customer = viewModel.loadCustomerById(customerId)
        if (customer!=null){
            setContent {
                DetailScreen(customer = customer) {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }

    }
}


