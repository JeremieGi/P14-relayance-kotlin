package com.kirabium.relayance.test

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.details.DetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Cette classe permet un test simple mais sans cucumber (avec le runner AndroidJUnit4)
 * Ce test n'est pas lancé dans la couverture générale avec Jacoco (car pas Cucumber) mais l'équivalent existe dans Cucumber
 */


@RunWith(AndroidJUnit4::class)
class DetailActivityTestWithoutCucumber {

    // https://developer.android.com/codelabs/jetpack-compose-testing?hl=fr#2

    companion object {
        private const val IDCUSTOMER = 1
    }

    // lancer l'activité avec son paramètre
    @get:Rule //@get:Rule est utilisée pour gérer automatiquement l'initialisation et la configuration des règles dans les tests JUnit
    val activityScenarioRule = ActivityScenarioRule<DetailActivity>(
        Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_CUSTOMER_ID, IDCUSTOMER)
        }
    )

    // Cela permet d'interagir avec les composants Compose dans les tests.
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun detailActivity_Test() {

        // Attend que les redessins soient finis
        composeTestRule.waitForIdle()

        // Testez les propriétés sémantiques (ajoutées dans le code de l'écran)

        // Dans DetailsScreen => modifier = Modifier.semantics { contentDescription = "Customer name" }
        composeTestRule
            .onNodeWithContentDescription("Customer name")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription("Customer email")
            .assertIsDisplayed()

    }

}