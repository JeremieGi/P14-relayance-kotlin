package com.kirabium.relayance.ui.activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirabium.relayance.databinding.ActivityMainBinding
import com.kirabium.relayance.ui.activity.add.AddCustomerActivity
import com.kirabium.relayance.ui.activity.details.DetailActivity
import com.kirabium.relayance.ui.adapter.CustomerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customerAdapter: CustomerAdapter

    // View Model
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()

        // Launch the UI States observer
        observeUiStates()

        setupCustomerRecyclerView()
        setupFab()

        // Load (the observer will be notified)
        viewModel.loadAllCustomers()
    }

    private fun observeUiStates() {

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Collect the uiState
                viewModel.uiState.collect {

                    // reception of the database flow

                    // No customer in the database
                    //if (it.listCustomers.isEmpty()){
                    //}

                    // Mise à jour du recycler view
                    customerAdapter.updateData(it.listCustomers)

                }

            }


        }
    }

    private fun setupFab() {
        binding.addCustomerFab.setOnClickListener {
            val intent = Intent(this, AddCustomerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupCustomerRecyclerView() {

        binding.customerRecyclerView.layoutManager = LinearLayoutManager(this)

        customerAdapter = CustomerAdapter(emptyList()) { customer ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_CUSTOMER_ID, customer.id)
            }
            startActivity(intent)
        }

        binding.customerRecyclerView.adapter = customerAdapter
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
