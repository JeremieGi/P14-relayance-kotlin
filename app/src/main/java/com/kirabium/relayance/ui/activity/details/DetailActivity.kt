package com.kirabium.relayance.ui.activity.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    // View Model
    private val viewModel: DetailViewModel by viewModels()

    companion object {

        const val EXTRA_CUSTOMER_ID = "customer_id"

        //
        fun create(targetContext: Context?, nIdCustomer: Int): Intent {
            return Intent(targetContext,DetailActivity::class.java).putExtra(
                EXTRA_CUSTOMER_ID,nIdCustomer)
        }

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
        else{
            setContent {
                Text( text = "Impossible to load customer ID=${customerId}" )
            }
        }

    }
}


