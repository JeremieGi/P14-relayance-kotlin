package com.kirabium.relayance.test

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.ui.activity.details.DetailActivity
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class CucumberComposeExampleTest(
    val composeRuleHolder: ComposeRuleHolder,
    val scenarioHolder: ActivityScenarioHolder
):
    SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule{

        @Given("^I initialize App")
        fun initializeApp(){

            val instrumentation = InstrumentationRegistry.getInstrumentation()
            scenarioHolder.launch(DetailActivity.create(instrumentation.targetContext,2))

        }

        @When("^I click Greet Cucumber")
        fun checkButtonClick(){

        }


}