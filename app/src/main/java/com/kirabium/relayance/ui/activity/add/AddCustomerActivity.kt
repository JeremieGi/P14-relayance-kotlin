package com.kirabium.relayance.ui.activity.add

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kirabium.relayance.R
import com.kirabium.relayance.databinding.ActivityAddCustomerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCustomerBinding

    // View Model
    private val viewModel: AddCustomerViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()

        binding.saveFab.setOnClickListener {
            saveCustomer()
        }
    }

    private fun saveCustomer() {

        // Les champs obligatoires sont bien remplis ?
        if (bCheckInputOK()){

            viewModel.addCustomer(
                binding.nameEditText.text.toString(),
                binding.emailEditText.text.toString())

            Toast.makeText(this.applicationContext,
                getString(R.string.customer_added), Toast.LENGTH_SHORT).show();

            // Ferme l'activity
            finish()
        }
        // else : les champs apparaissent déjà en rouge

    }

    /**
     * Vérifie que les champs sont saisis
     */
    private fun bCheckInputOK(): Boolean {

        var bImputsOK = true

        if (! inputNameOK()){
            bImputsOK = false
        }

        if (! inputEmailOK()){
            bImputsOK = false
        }

        return bImputsOK
    }

    private fun inputEmailOK(): Boolean {

        var bImputsOK = true

        val inputEmail = binding.emailEditText.text.toString().trim()
        if (inputEmail.isEmpty()) {
            binding.emailTextInputLayout.error = getString(R.string.mail_check)
            binding.emailTextInputLayout.isErrorEnabled = true
            bImputsOK = false
        } else {

            // Mail correct
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){

                binding.emailTextInputLayout.error = null
                binding.emailTextInputLayout.isErrorEnabled = false

            }
            else{

                binding.emailTextInputLayout.error = getString(R.string.invalid_format)
                binding.emailTextInputLayout.isErrorEnabled = true
                bImputsOK = false

            }
        }

        return bImputsOK

    }

    private fun inputNameOK(): Boolean {

        var bImputsOK = true

        val inputFirstName = binding.nameEditText.text.toString().trim()
        if (inputFirstName.isEmpty()) {
            binding.nameTextInputLayout.error = getString(R.string.name_check)
            binding.nameTextInputLayout.isErrorEnabled = true
            bImputsOK = false
        } else {
            binding.nameTextInputLayout.error = null
            binding.nameTextInputLayout.isErrorEnabled = false
        }

        return bImputsOK

    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupBinding() {
        binding = ActivityAddCustomerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}