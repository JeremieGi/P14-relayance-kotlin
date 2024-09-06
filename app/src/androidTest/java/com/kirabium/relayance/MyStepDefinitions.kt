package com.kirabium.relayance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import cucumber.api.java.Before
import dagger.hilt.android.testing.HiltAndroidTest
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Rule


@HiltAndroidTest
class MyStepDefinitions {

    // Initialise Hilt
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    // Injecte les dépendances
    @Before
    fun init() {
        // Initialiser Hilt pour injecter les dépendances
        hiltRule.inject()
    }


    @Given("^la fenêtre principale est ouverte$")
    fun laFenetrePrincipaleEstOuverte() {
        // Vérification que le RecyclerView fait 5 éléments
        onView(withId(R.id.customerRecyclerView))
            .check( RecyclerViewItemCountAssertion.withItemCount(5) )
    }

    @When("^je clique sur ajouter$")
    fun jeCliqueSurAjouter() {
        onView(withId(R.id.addCustomerFab))
            .perform( click() )
    }

    @Then("^la fenêtre pour ajouter un nouveau client est affichée$")
    fun laFenetrePourAjouterUnNouveauClientEstAffichee() {
        onView(withId(R.id.nameEditText))
            //.check( doesNotExist() )
            .check(matches(isDisplayed())) // Vérifie si le champ est visible
    }

}