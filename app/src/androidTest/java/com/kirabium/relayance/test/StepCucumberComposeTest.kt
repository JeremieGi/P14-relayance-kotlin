package com.kirabium.relayance.test

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.ui.activity.details.DetailActivity
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class StepCucumberComposeTest(
    val composeRuleHolder: ComposeRuleHolder
) : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule
{

    @Given("^La fenetre de détail est lancee")
    fun initializeApp(){
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val intent = DetailActivity.create(instrumentation.targetContext,1)
        // Lancer l'activité avec l'Intent
        ActivityScenario.launch<DetailActivity>(intent)
    }


    @When("^Le nom du client est affiche")
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