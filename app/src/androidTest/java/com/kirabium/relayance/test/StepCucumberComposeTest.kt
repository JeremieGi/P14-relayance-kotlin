package com.kirabium.relayance.test


import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.kirabium.relayance.ui.activity.details.DetailActivity
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


class StepCucumberComposeTest(
    private val composeRuleHolder: ComposeRuleHolder
) : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule
{

    @Given("La fenetre de detail est lancee avec idCustomer = {int}")
    fun initializeApp(nIdCustomer : Int){

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = DetailActivity.create(appContext,nIdCustomer)

        // Lancer l'activité avec l'Intent
        ActivityScenario.launch<DetailActivity>(intent)
    }


    @When("Le nom du client est affiche")
    fun checkButtonClick(){
        onNodeWithContentDescription("Customer name")
            .assertIsDisplayed()
    }

    @Then("L'email du client est affiche")
    fun customerEmailIsDisplayed() {
        onNodeWithContentDescription("Customer email")
            .assertIsDisplayed()
    }


}