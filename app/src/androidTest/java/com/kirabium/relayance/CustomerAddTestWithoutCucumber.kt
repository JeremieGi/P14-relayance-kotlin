package com.kirabium.relayance

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

// Lancement géénral des tests :
// TODO JG Denis Question : comment exclure certaines classes de la couverture (classe Hilt par exemple)
// TODO JG Denis Question : pourquoi 0% de coverage sur le repository ?

@RunWith(AndroidJUnit4::class)
class CustomerAddTestWithoutCucumber {

    // Lancement de l'activité principale en début de test
    @get:Rule
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