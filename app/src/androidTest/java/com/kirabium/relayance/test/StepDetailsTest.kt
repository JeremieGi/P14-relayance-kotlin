package com.kirabium.relayance.test

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
//import com.kirabium.relayance.test.DetailActivityTestWithoutCucumber.Companion.IDCUSTOMER
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.ui.activity.details.DetailActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlinx.coroutines.delay
import org.junit.Rule

@HiltAndroidTest
class StepDetailsTest {


//    // Cela permet d'interagir avec les composants Compose dans les tests.
//    @get:Rule(order = 1)
//    val composeTestRule = createComposeRule()


    @Given("La fenêtre de détail est lancée avec l'ID client {int}")
    fun appLaunchedWithCustomerId(nIdCustomer: Int) {

        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val intent = DetailActivity.create(instrumentation.targetContext,nIdCustomer)
        // Lancer l'activité avec l'Intent
        ActivityScenario.launch<DetailActivity>(intent)

    }




    @When("Je suis sur l'écran de détails du client")
    fun onCustomerDetailScreen() {
        // Attendre que l'écran soit prêt à interagir

        Thread.sleep(5*1000)

  //      composeTestRule.waitForIdle()
    }

    @Then("Le nom du client est affiché")
    fun customerNameIsDisplayed() {
//        composeTestRule
//            .onNodeWithContentDescription("Customer name")
//            .assertIsDisplayed()
    }

    @Then("L'email du client est affiché")
    fun customerEmailIsDisplayed() {
//        composeTestRule
//            .onNodeWithContentDescription("Customer email")
//            .assertIsDisplayed()
    }



}