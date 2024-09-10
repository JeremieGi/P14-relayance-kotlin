package com.kirabium.relayance.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.kirabium.relayance.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

/**
 * Cette classe permet un test simple mais sans cucumber (avec le runner AndroidJUnit4)
 * Ce test n'est pas lancer dans la couverture générale avec Jacoco (car pas Cucumber) mais l'équivalent existe dans Cucumber
 */

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class CustomerAddTestWithoutCucumber {

    @get:Rule(order = 1)
    var hiltRule = HiltAndroidRule(this)

    // Lancement de l'activité principale en début de test
    @get:Rule(order = 2)
    var activityTest = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun add_classic() {

        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) )

        // Clic sur le FAB "+"
        onView(withId(R.id.addCustomerFab))
            .perform( click() )

        // Attendre que le champ de texte ou un autre élément dans la nouvelle fenêtre soit visible
        onView(withId(R.id.nameEditText))
            .check(matches(isDisplayed()))

        onView(withId(R.id.nameEditText))
            .perform( typeText("client de test") )

        onView(withId(R.id.emailEditText))
            .perform( typeText("clienttest@free.fr") )

        // Clic sur le bouton d'enregistrement
        onView(withId(R.id.saveFab))
            .perform( click() )

        // Vérification que le RecyclerView fait maintenant 6 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(6) )

    }

}