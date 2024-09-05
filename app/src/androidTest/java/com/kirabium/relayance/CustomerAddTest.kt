package com.kirabium.relayance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.kirabium.relayance.ui.activity.MainActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.runner.RunWith


// https://www.youtube.com/watch?v=vZV6EiSJAfc
// Source de la vidéo : https://github.com/innovationindiaforall/Testing => projet Android_BDD_UI

/**
 * Feature: Ajout d'un client
 *   Ajout un client dans la liste des clients
 *
 * @add-feature
 * Scenario Outline: Add
 *     Given la fenêtre principale est ouverte
 *     When Je clique sur ajouter
 *     And Je saisis un nom
 *     And Je saisis un email correct
 * 	And Je clique sur le bouton d'enregistrement
 *     Then La fenêtre d'ajout se ferme et la fenêtre listant les clients fait apparaître le nouveau client
 *     Examples:
 *         Jeremie |  jeremie@free.fr
 */

//TODO Denis Prio 1 : Le test ne passe pas (remettre testInstrumentationRunner dans build.gradle)

@SmallTest
@RunWith(AndroidJUnit4::class)
class CustomerAddTest {

    // Lancement de l'activité principale en début de test

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var activity: MainActivity

    @Before("@add-feature")
    fun setup() {
        // `onActivity` is used to interact with the activity directly.
        activityScenarioRule.scenario.onActivity { activityInstance ->
            activity = activityInstance
        }
    }

    @After("@add-feature")
    fun tearDown() {
        // `ActivityScenarioRule` automatically closes the activity after the test,
    }

    /**
     * ^ : Ce symbole indique le début de la chaîne.
     * $ : Ce symbole indique la fin de la chaîne.
     */

    @Given("^la fenêtre principale est ouverte$")
    fun fenetre_principale() {
        assertNotNull(activity)
    }

    @When("^Je clique sur ajouter$")
    fun click_plus() {
        onView(withId(R.id.addCustomerFab))
            .perform( click() )
    }


    @Then("la fenetre pour ajouter un nouveau client est affichee$")
    //@Throws(Throwable::class)
    fun la_fenetre_pour_ajouter_un_nouveau_client_est_affichee() {

        onView(withId(R.id.nameEditText))
            //.check( doesNotExist() )
            .check(matches(isDisplayed())) // Vérifie si le champ est visible
    }


}