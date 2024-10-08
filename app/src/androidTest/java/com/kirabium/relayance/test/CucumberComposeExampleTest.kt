package com.kirabium.relayance.test

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.kirabium.relayance.ui.activity.details.DetailActivity
import io.cucumber.java.en.Given

/**
 * Article utile : https://medium.com/@santu.bhuniya2006/android-cucumber-test-with-jetpack-compose-application-f2161a8fc1b9
 * et ses sources GitHub : https://github.com/santubhuniya/CucumberCompose.git
 */

class CucumberComposeExampleTest(
    private val composeRuleHolder: ComposeRuleHolder,
    private val scenarioHolder: ActivityScenarioHolder
):
    SemanticsNodeInteractionsProvider  // Il s'agit d'une interface de Jetpack Compose utilisée pour interagir avec des nœuds d'interface utilisateur via des actions sémantiques.
    by composeRuleHolder.composeRule{ // l'instance de CucumberComposeExampleTest délègue l'implémentation de l'interface SemanticsNodeInteractionsProvider à composeRuleHolder.composeRule (pas besoin d'implémenter les méthodes)

        @Given("^Lance la fenetre de details")
        fun initializeApp(){

            val instrumentation = InstrumentationRegistry.getInstrumentation()
            scenarioHolder.launch(DetailActivity.create(instrumentation.targetContext,2))

        }


}